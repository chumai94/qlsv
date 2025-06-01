package com.example.dao;

import com.example.model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UserDAO extends DBConnect{
    public List<Teacher> searchUsers(String keyword, int offset, int limit) {
        List<Teacher> usersList = new ArrayList<>();
        String sql = "SELECT * FROM TEACHER " +
                "WHERE TYPE='giaovien' AND DELETED = 0 AND NAME LIKE ? " +
                "LIMIT ? OFFSET ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            pst.setInt(2, limit);
            pst.setInt(3, offset);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Teacher user = new Teacher(
                        rs.getString("ID"),
                        rs.getString("NAME"),
                        rs.getString("PHONE"),
                        rs.getString("MAIL"),
                        rs.getString("address"),
                        rs.getDate("date_of_birth"),
                        rs.getString("type"),
                        rs.getDate("starttime"),
                        rs.getDate("endtime"),
                        rs.getDate("create_at"),
                        rs.getDate("lastmodified"),
                        rs.getBoolean("deleted"),
                        rs.getBoolean("lock_status")
                );
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public int countUsers(String keyword) {
        String sql = "SELECT COUNT(*) FROM users WHERE type='giaovien' AND deleted = 0 AND name LIKE ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    public List<Teacher> searchStudent(String keyword, int offset, int limit) {
        List<Teacher> usersList = new ArrayList<>();
        String sql = "SELECT * FROM users " +
                "WHERE type='sinhvien' AND deleted = 0 AND name LIKE ? " +
                "LIMIT ? OFFSET ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            pst.setInt(2, limit);
            pst.setInt(3, offset);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Teacher user = new Teacher(
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
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public int countStudent(String keyword) {
        String sql = "SELECT COUNT(*) FROM users WHERE type='sinhvien' AND deleted = 0 AND name LIKE ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    public List<Teacher> getAll(){
        List<Teacher> usersList = new ArrayList<>();
        String sql = "select * from users where type='giaovien' and deleted = 0";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Teacher users = new Teacher(rs.getString("id"),
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
                        rs.getBoolean("lock_status"));
                usersList.add(users);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public List<Teacher> getAllStudent(){
        List<Teacher> usersList = new ArrayList<>();
        String sql = "select * from users where type='sinhvien' and deleted = 0";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Teacher users = new Teacher(rs.getString("id"),
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
                        rs.getBoolean("lock_status"));
                usersList.add(users);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public Teacher findById(String id){
        String sql = "select * from users where id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Teacher users = new Teacher(rs.getString("id"),
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
                        rs.getBoolean("lock_status"));
                return users;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
	public void addUser(Teacher user) {
        String sql = "INSERT INTO users (id, name, phone, email, address, date_of_birth, type, type_position, starttime, endtime, create_at, lastmodified, deleted, lock_status) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getAddress());
            ps.setDate(6, new java.sql.Date(user.getDateOfBirth().getTime()));
            ps.setString(7, user.getType());
            ps.setString(8, user.getTypePosition());
            ps.setDate(9, new java.sql.Date(user.getStartTime().getTime()));
            ps.setDate(10, new java.sql.Date(user.getEndTime().getTime()));
            ps.setDate(11, new java.sql.Date(user.getCreateAt().getTime()));
            ps.setDate(12, new java.sql.Date(user.getLastmodified().getTime()));
            ps.setBoolean(13, user.isDeleted()); 
            ps.setBoolean(14, user.isLockStatus());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(Teacher user) {
        String sql = "UPDATE users SET name = ?, phone = ?, email = ?, address = ?, date_of_birth = ?, type = ?, type_position = ?, "
                     + "starttime = ?, endtime = ?, lastmodified = ?, deleted = ?, lock_status = ?, position_id = ? WHERE id = ?";

        try {
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setDate(5, new java.sql.Date(user.getDateOfBirth().getTime()));
            ps.setString(6, user.getType());
            ps.setString(7, user.getTypePosition());
            ps.setDate(8, new java.sql.Date(user.getStartTime().getTime()));
            ps.setDate(9, new java.sql.Date(user.getEndTime().getTime()));
            ps.setDate(10, new java.sql.Date(user.getLastmodified().getTime()));
            ps.setBoolean(11, user.isDeleted());  
            ps.setBoolean(12, user.isLockStatus()); 
            ps.setString(13, null);
            ps.setString(14, user.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void deleteUser(String userId) {
        String sql = "UPDATE users SET deleted = 1 WHERE id = ?";

        try {
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void lockUser(String userId) {
        String sql = "UPDATE users SET lock_status = 1 WHERE id = ?";

        try {
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void unLockUser(String userId) {
        String sql = "UPDATE users SET lock_status = 0 WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Teacher> getAllStudentNotInClass(String classId) {
        List<Teacher> usersList = new ArrayList<>();
        String sql = "SELECT u.* " +
                "FROM users u " +
                "WHERE u.type = 'sinhvien' " +
                "AND u.id NOT IN ( " +
                "    SELECT cu.student_id FROM class_user cu " +
                "    WHERE cu.class_id = ? )";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, classId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Teacher users = new Teacher(rs.getString("id"),
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
                        rs.getBoolean("lock_status"));
                usersList.add(users);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public int countTeachers() {
        String sql = "SELECT COUNT(*) FROM users WHERE type = 'giaovien' AND deleted = 0";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int countStudents() {
        String sql = "SELECT COUNT(*) FROM users WHERE type = 'sinhvien' AND deleted = 0";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
