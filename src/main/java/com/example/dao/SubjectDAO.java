package com.example.dao;

import com.example.model.Cycle;
import com.example.model.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends DBConnect{
    CycleDAO cycleDAO = new CycleDAO();
    public List<Subject> getSubjectsByTeacherId(String teacherId) {
        List<Subject> subjectList = new ArrayList<>();
        String sql = "SELECT * FROM subject WHERE user_id = ? AND deleted = 0";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, teacherId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cycleId = rs.getString("cycle_id");
                Cycle cycle = cycleDAO.findById(cycleId);
                Subject subject = new Subject(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("create_at"),
                        rs.getDate("lastmodified"),
                        rs.getBoolean("deleted"),
                        rs.getBoolean("status"),
                        cycle
                );
                subjectList.add(subject);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjectList;
    }
    public Subject findById(String id) {
        String sql = "SELECT * FROM subject WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getString("id"));
                subject.setName(rs.getString("name"));
                subject.setDescription(rs.getString("description"));
                subject.setCreateAt(rs.getDate("create_at"));
                subject.setLastmodified(rs.getDate("lastmodified"));
                subject.setDeleted(rs.getBoolean("deleted"));
                subject.setStatus(rs.getBoolean("status"));
                return subject;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void add(Subject subject, String cycleId) {
        String sql = "INSERT INTO subject (id, name, description, create_at, lastmodified, deleted, status, cycle_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, subject.getId());
            ps.setString(2, subject.getName());
            ps.setString(3, subject.getDescription());
            ps.setDate(4, new java.sql.Date(subject.getCreateAt().getTime()));
            ps.setDate(5, new java.sql.Date(subject.getLastmodified().getTime()));
            ps.setBoolean(6, subject.isDeleted());
            ps.setBoolean(7, subject.isStatus());
            ps.setString(8, subject.getCycle().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Subject subject) {
        String sql = "UPDATE subject SET name = ?, description = ?, lastmodified = ?, deleted = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, subject.getName());
            ps.setString(2, subject.getDescription());
            ps.setDate(3, new java.sql.Date(subject.getLastmodified().getTime()));
            ps.setBoolean(4, subject.isDeleted());
            ps.setBoolean(5, subject.isStatus());
            ps.setString(6, subject.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        String sql = "UPDATE subject SET deleted = 1 WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
