package com.example.dao;

import com.example.model.Student;
import com.example.model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UserDAO extends DBConnect{
    public List<Teacher> searchUsers(String keyword, int offset, int limit) {
        List<Teacher> usersList = new ArrayList<>();
        String sql = "SELECT * FROM TEACHER WHERE TYPE='1' AND DELETED = 0 AND NAME LIKE ? OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            pst.setInt(2, offset);
            pst.setInt(3, limit);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Teacher user = new Teacher(
                        rs.getString("ID"),
                        rs.getString("NAME"),
                        rs.getString("PHONE"),
                        rs.getString("MAIL"),
                        rs.getDate("DATE_OF_BIRTH"),
                        rs.getInt("TYPE"),
                        null,
                        rs.getDate("CREATE_AT"),
                        rs.getDate("LASTMODIFIED"),
                        rs.getBoolean("DELETED"),
                        rs.getBoolean("STATUS")
                );
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public int countUsers(String keyword) {
        String sql = "SELECT COUNT(*) FROM TEACHER WHERE TYPE='1' AND DELETED = 0 AND NAME LIKE ?";
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
    public List<Student> searchStudent(String keyword, int offset, int limit) {
        List<Student> usersList = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT " +
                "WHERE DELETED = 0 AND NAME LIKE ? " +
                "LIMIT ? OFFSET ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            pst.setInt(2, limit);
            pst.setInt(3, offset);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Student user = new Student(
                        rs.getString("ID"),
                        rs.getString("NAME"),
                        rs.getString("PHONE"),
                        rs.getString("MAIL"),
                        rs.getDate("DATE_OF_BIRTH"),
                        rs.getString("ADDRESS"),
                        null,
                        rs.getDate("START_YEAR"),
                        rs.getDate("END_YEAR"),
                        rs.getDate("CREATE_AT"),
                        rs.getDate("LASTMODIFIED"),
                        rs.getBoolean("DELETED"),
                        rs.getBoolean("STATUS")
                );
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public int countStudent(String keyword) {
        String sql = "SELECT COUNT(*) FROM STUDENT WHERE DELETED = 0 AND NAME LIKE ?";
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
        String sql = "select * from TEACHER where TYPE='1' and DELETED = 0";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Teacher user = new Teacher(
                        rs.getString("ID"),
                        rs.getString("NAME"),
                        rs.getString("PHONE"),
                        rs.getString("MAIL"),
                        rs.getDate("DATE_OF_BIRTH"),
                        rs.getInt("TYPE"),
                        null,
                        rs.getDate("CREATE_AT"),
                        rs.getDate("LASSMODIFIED"),
                        rs.getBoolean("DELETED"),
                        rs.getBoolean("STATUS")
                );
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public List<Student> getAllStudent(){
        List<Student> usersList = new ArrayList<>();
        String sql = "select * from STUDENT where DELETED = 0";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Student users = new Student(
                        rs.getString("ID"),
                        rs.getString("NAME"),
                        rs.getString("PHONE"),
                        rs.getString("MAIL"),
                        rs.getDate("DATE_OF_BIRTH"),
                        rs.getString("ADDRESS"),
                        null,
                        rs.getDate("START_YEAR"),
                        rs.getDate("END_YEAR"),
                        rs.getDate("CREATE_AT"),
                        rs.getDate("LASTMODIFIED"),
                        rs.getBoolean("DELETED"),
                        rs.getBoolean("STATUS")
                );
                usersList.add(users);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public Teacher findById(String id){
        String sql = "select * from TEACHER where ID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Teacher users = new Teacher(
                        rs.getString("ID"),
                        rs.getString("NAME"),
                        rs.getString("PHONE"),
                        rs.getString("MAIL"),
                        rs.getDate("DATE_OF_BIRTH"),
                        rs.getInt("TYPE"),
                        null,
                        rs.getDate("CREATE_AT"),
                        rs.getDate("LASTMODIFIED"),
                        rs.getBoolean("DELETED"),
                        rs.getBoolean("STATUS")
                );
                return users;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Student findStudentById(String id){
        String sql = "select * from STUDENT where ID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Student users = new Student(
                        rs.getString("ID"),
                        rs.getString("NAME"),
                        rs.getString("PHONE"),
                        rs.getString("MAIL"),
                        rs.getDate("DATE_OF_BIRTH"),
                        rs.getString("ADDRESS"),
                        null,
                        rs.getDate("START_YEAR"),
                        rs.getDate("END_YEAR"),
                        rs.getDate("CREATE_AT"),
                        rs.getDate("LASTMODIFIED"),
                        rs.getBoolean("DELETED"),
                        rs.getBoolean("STATUS")
                );
                return users;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
	public void addUser(Teacher user) {
        String sql = "INSERT INTO TEACHER (ID, NAME, PHONE, MAIL, DATE_OF_BIRTH, TYPE,PASSWORD, CREATE_AT, LASTMODIFIED, DELETED, STATUS) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
            ps.setDate(5, new java.sql.Date(user.getDateOfBirth().getTime()));
            ps.setInt(6, user.getType());
            ps.setString(7, user.getPassword());
            ps.setDate(8, new java.sql.Date(user.getCreateAt().getTime()));
            ps.setDate(9, new java.sql.Date(user.getLastmodified().getTime()));
            ps.setBoolean(10, user.isDeleted());
            ps.setBoolean(11, user.isStatus());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addStudent(Student user) {
        String sql = "INSERT INTO STUDENT (ID, NAME, PHONE, MAIL,ADDRESS , DATE_OF_BIRTH,START_YEAR, END_YEAR ,PASSWORD, CREATE_AT, LASTMODIFIED, DELETED, STATUS) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
            ps.setString(5,user.getAddress());
            ps.setDate(6, new java.sql.Date(user.getDateOfBirth().getTime()));
            ps.setDate(7,user.getStartYear());
            ps.setDate(8,user.getEndYear());
            ps.setString(9, user.getPassword());
            ps.setDate(10, new java.sql.Date(user.getCreateAt().getTime()));
            ps.setDate(11, new java.sql.Date(user.getLastmodified().getTime()));
            ps.setBoolean(12, user.isDeleted());
            ps.setBoolean(13, user.isStatus());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(Teacher user) {
        String sql = "UPDATE TEACHER SET NAME = ?, PHONE = ?, MAIL = ?, DATE_OF_BIRTH = ?, TYPE = ?, PASSWORD = ?, "
                     + " LASTMODIFIED = ?, DELETED = ?, STATUS = ? WHERE ID = ?";

        try {
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getEmail());
            ps.setDate(4, new java.sql.Date(user.getDateOfBirth().getTime()));
            ps.setInt(5, user.getType());
            ps.setString(6, user.getPassword());
            ps.setDate(7, new java.sql.Date(user.getLastmodified().getTime()));
            ps.setBoolean(8, user.isDeleted());
            ps.setBoolean(9, user.isStatus());
            ps.setString(10, user.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void deleteUser(String userId) {
        String sql = "UPDATE TEACHER SET DELETED = 1 WHERE ID = ?";

        try {
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(String userId) {
        String sql = "UPDATE STUDENT SET DELETED = 1 WHERE ID = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void lockUser(String userId) {
        String sql = "UPDATE TEACHER SET STATUS = 1 WHERE ID = ?";

        try {
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void lockStudent(String userId) {
        String sql = "UPDATE STUDENT SET STATUS = 1 WHERE ID = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void unLockUser(String userId) {
        String sql = "UPDATE TEACHER SET STATUS = 0 WHERE ID = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void unLockStudent(String userId) {
        String sql = "UPDATE STUDENT SET STATUS = 0 WHERE ID = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Student> getAllStudentNotInClass(String classId) {
        List<Student> usersList = new ArrayList<>();
        String sql = "SELECT u.* " +
                "FROM STUDENT u " +
                "WHERE u.ID NOT IN ( " +
                "    SELECT cu.STUDENT_ID FROM CLASS_STUDENT cu " +
                "    WHERE cu.CLASS_ID = ? )";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, classId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Student users = new Student(
                        rs.getString("ID"),
                        rs.getString("NAME"),
                        rs.getString("PHONE"),
                        rs.getString("MAIL"),
                        rs.getDate("DATE_OF_BIRTH"),
                        rs.getString("ADDRESS"),
                        null,
                        rs.getDate("START_YEAR"),
                        rs.getDate("END_YEAR"),
                        rs.getDate("CREATE_AT"),
                        rs.getDate("LASTMODIFIED"),
                        rs.getBoolean("DELETED"),
                        rs.getBoolean("STATUS")
                );
                usersList.add(users);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }
    public int countTeachers() {
        String sql = "SELECT COUNT(*) FROM TEACHER WHERE TYPE = '1' AND DELETED = 0";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int countStudents() {
        String sql = "SELECT COUNT(*) FROM STUDENT WHERE DELETED = 0";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
