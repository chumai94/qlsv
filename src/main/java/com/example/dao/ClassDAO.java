package com.example.dao;

import com.example.model.Class;
import com.example.model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO extends DBConnect {
    public List<Class> getClassByTeacher(String teacherId) {
        List<Class> classList = new ArrayList<>();
        String sql = "SELECT c.*, u.* " +
                "FROM class c " +
                "JOIN users u ON c.teacher_id = u.id " +
                "WHERE c.teacher_id = ? AND c.deleted = 0";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, teacherId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getDate("date_of_birth"),
                        rs.getString("type"),
                        rs.getString("type_position"),
                        rs.getDate("starttime"),
                        rs.getDate("endtime"),
                        rs.getDate("create_at"),
                        rs.getDate("lastmodified"),
                        rs.getBoolean("deleted"),
                        rs.getBoolean("lock_status")
                );

                Class clazz = new Class(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("created_at"),
                        rs.getDate("lastmodified"),
                        rs.getBoolean("deleted"),
                        rs.getBoolean("status"),
                        teacher
                );

                classList.add(clazz);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return classList;
    }

    public Class getClassByStudentId(String studentId) {
        String sql = "SELECT c.* " +
                "FROM class c " +
                "JOIN class_user cu ON c.id = cu.class_id " +
                "JOIN users u ON cu.student_id = u.id " +
                "WHERE u.id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Class clazz = new Class(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("created_at"),
                        rs.getDate("lastmodified"),
                        rs.getBoolean("deleted"),
                        rs.getBoolean("status"),
                        null
                );
                return clazz;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public List<Class> getAll(){
        List<Class> classes = new ArrayList<>();
        String sql = "select * from class where deleted = 0";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String teacherId = rs.getString("teacher_id");
                Teacher teacher = new UserDAO().findById(teacherId);
                Class clazz = new Class(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("created_at"),
                        rs.getDate("lastmodified"),
                        rs.getBoolean("deleted"),
                        rs.getBoolean("status"),
                        teacher);
                classes.add(clazz);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classes;
    }
    public List<Class> searchByName(String keyword) {
        List<Class> classList = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM class c " +
                "WHERE c.deleted = 0 AND c.name LIKE ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Class cls = new Class();
                cls.setId(rs.getString("id"));
                cls.setName(rs.getString("name"));
                cls.setDescription(rs.getString("description"));
                cls.setCreatedAt(rs.getDate("created_at"));
                cls.setLastModified(rs.getDate("lastmodified"));
                cls.setDeleted(rs.getBoolean("deleted"));
                cls.setStatus(rs.getBoolean("status"));
                String teacherId = rs.getString("teacher_id");
                Teacher teacher = new UserDAO().findById(teacherId);
                cls.setTeacher(teacher);
                classList.add(cls);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classList;
    }

    public void insert(Class clazz) {
        String sql = "INSERT INTO class (id, name, description, created_at, lastmodified, deleted, status, teacher_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, clazz.getId());
            ps.setString(2, clazz.getName());
            ps.setString(3, clazz.getDescription());
            ps.setDate(4, new java.sql.Date(clazz.getCreatedAt().getTime()));
            ps.setDate(5, new java.sql.Date(clazz.getLastModified().getTime()));
            ps.setBoolean(6, clazz.isDeleted());
            ps.setBoolean(7, clazz.isStatus());
            if (clazz.getTeacher() != null && clazz.getTeacher().getId() != null) {
                ps.setString(8,clazz.getTeacher().getId());
            } else {
                ps.setNull(8, Types.VARCHAR);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Class getById(String id){
        String sql = "select * from class where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String teacherId = rs.getString("teacher_id");
                Teacher teacher = new UserDAO().findById(teacherId);
                Class clazz = new Class(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("created_at"),
                        rs.getDate("lastmodified"),
                        rs.getBoolean("deleted"),
                        rs.getBoolean("status"),
                        teacher);
               return clazz;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void update(Class clazz) {
        String sql = "UPDATE class SET name = ?, description = ?, lastmodified = ?, " +
                "deleted = ?, status = ?, teacher_id = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, clazz.getName());
            ps.setString(2, clazz.getDescription());
            ps.setDate(3, new java.sql.Date(clazz.getLastModified().getTime()));
            ps.setBoolean(4, clazz.isDeleted());
            ps.setBoolean(5, clazz.isStatus());
            ps.setString(6, clazz.getTeacher().getId());
            ps.setString(7, clazz.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(String classId) {
        String sql = "UPDATE class SET deleted = 1 WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,classId );
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void unDelete(String classId) {
        String sql = "UPDATE class SET deleted = 0 WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,classId );
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void lock(String classId) {
        String sql = "UPDATE class SET status = 1 WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,classId );
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void unLock(String classId) {
        String sql = "UPDATE class SET status = 0 WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,classId );
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int countClasses() {
        String sql = "SELECT COUNT(*) FROM class WHERE deleted = 0";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
