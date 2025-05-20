package com.example.dao;

import com.example.model.Class;
import com.example.model.Class_User;
import com.example.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassUserDAO extends DBConnect{
    public List<Class_User> getStudentsByTeacher(String teacherId,String classId) {
        List<Class_User> list = new ArrayList<>();
        String sql = "SELECT c.*, u.* " +
                "FROM class c " +
                "JOIN class_user cu ON c.id = cu.class_id " +
                "JOIN users u ON cu.student_id = u.id " +
                "WHERE c.teacher_id = ? AND c.id = ? AND c.deleted = 0 AND u.deleted = 0";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, teacherId);
            stmt.setString(2,classId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Users student = new Users(
                        rs.getString("u.id"),
                        rs.getString("u.name"),
                        rs.getString("u.phone"),
                        rs.getString("u.email"),
                        rs.getString("u.address"),
                        rs.getDate("u.date_of_birth"),
                        rs.getString("u.type"),
                        rs.getString("u.type_position"),
                        rs.getDate("u.starttime"),
                        rs.getDate("u.endtime"),
                        rs.getDate("u.create_at"),
                        rs.getDate("u.lastmodified"),
                        rs.getBoolean("u.deleted"),
                        rs.getBoolean("u.lock_status")
                );

                Class clazz = new Class(
                        rs.getString("c.id"),
                        rs.getString("c.name"),
                        rs.getString("c.description"),
                        rs.getDate("c.created_at"),
                        rs.getDate("c.lastmodified"),
                        rs.getBoolean("c.deleted"),
                        rs.getBoolean("c.status"),
                        null
                );

                list.add(new Class_User(student, clazz));
            }

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching students by teacher", e);
        }

        return list;
    }
    public List<Class_User> getAllStudentByClassId(String classId, String searchTerm) {
        List<Class_User> classUsers = new ArrayList<>();
        String sql = "SELECT * FROM class_user cu " +
                "JOIN users u ON cu.student_id = u.id " +
                "WHERE cu.class_id = ? " +
                "AND (u.id LIKE ? OR u.name LIKE ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, classId);
            ps.setString(2, "%" + searchTerm + "%");
            ps.setString(3, "%" + searchTerm + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users student = new UserDAO().findById(rs.getString("student_id"));
                Class clazz = new ClassDAO().getById(rs.getString("class_id"));
                Class_User classUser = new Class_User(student, clazz);
                classUsers.add(classUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classUsers;
    }
    public void addStudentsToClass(String classId, List<Users> students) {
        String sql = "INSERT INTO class_user (class_id, student_id) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (Users student : students) {
                ps.setString(1, classId);
                ps.setString(2, student.getId());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding students to class", e);
        }
    }
    public void delete(String classId, String studentId) {
        String sql = "DELETE FROM class_user WHERE class_id = ? AND student_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, classId);
            ps.setString(2, studentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting student from class", e);
        }
    }
}
