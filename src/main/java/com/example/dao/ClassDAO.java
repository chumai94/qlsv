package com.example.dao;

import com.example.model.Class;
import com.example.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                Users teacher = new Users(
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
                        rs.getDate("create_at"),
                        rs.getDate("lastmodified"),
                        rs.getBoolean("deleted"),
                        rs.getBoolean("status"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("shift"),
                        teacher
                );

                classList.add(clazz);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return classList;
    }
}
