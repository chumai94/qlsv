package com.example.dao;

import com.example.model.Cycle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CycleDAO extends DBConnect{
    public List<Cycle> getAll() {
        List<Cycle> cycleList = new ArrayList<>();
        String sql = "SELECT * FROM cycle WHERE deleted = 0";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cycle cycle = new Cycle();
                cycle.setId(rs.getString("id"));
                cycle.setName(rs.getString("name"));
                cycle.setDescription(rs.getString("description"));
                cycle.setStartDate(rs.getDate("start_date"));
                cycle.setEndDate(rs.getDate("end_date"));
                cycle.setCreateAt(rs.getDate("created_at"));
                cycle.setLastmodified(rs.getDate("lastmodified"));
                cycle.setDeleted(rs.getBoolean("deleted"));
                cycle.setStatus(rs.getBoolean("status"));
                cycleList.add(cycle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cycleList;
    }

    public Cycle findById(String id) {
        String sql = "SELECT * FROM cycle WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Cycle cycle = new Cycle();
                cycle.setId(rs.getString("id"));
                cycle.setName(rs.getString("name"));
                cycle.setDescription(rs.getString("description"));
                cycle.setStartDate(rs.getDate("start_date"));
                cycle.setEndDate(rs.getDate("end_date"));
                cycle.setCreateAt(rs.getDate("created_at"));
                cycle.setLastmodified(rs.getDate("lastmodified"));
                cycle.setDeleted(rs.getBoolean("deleted"));
                cycle.setStatus(rs.getBoolean("status"));
                return cycle;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void add(Cycle cycle) {
        String sql = "INSERT INTO cycle (id, name, description, start_date, end_date, created_at, lastmodified, deleted, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cycle.getId());
            ps.setString(2, cycle.getName());
            ps.setString(3, cycle.getDescription());
            ps.setDate(4, new java.sql.Date(cycle.getStartDate().getTime()));
            ps.setDate(5, new java.sql.Date(cycle.getEndDate().getTime()));
            ps.setDate(6, new java.sql.Date(cycle.getCreateAt().getTime()));
            ps.setDate(7, new java.sql.Date(cycle.getLastmodified().getTime()));
            ps.setBoolean(8, cycle.isDeleted());
            ps.setBoolean(9, cycle.isStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Cycle cycle) {
        String sql = "UPDATE cycle SET name = ?, description = ?, start_date = ?, end_date = ?, "
                + "lastmodified = ?, deleted = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cycle.getName());
            ps.setString(2, cycle.getDescription());
            ps.setDate(3, new java.sql.Date(cycle.getStartDate().getTime()));
            ps.setDate(4, new java.sql.Date(cycle.getEndDate().getTime()));
            ps.setDate(5, new java.sql.Date(cycle.getLastmodified().getTime()));
            ps.setBoolean(6, cycle.isDeleted());
            ps.setBoolean(7, cycle.isStatus());
            ps.setString(8, cycle.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        String sql = "UPDATE cycle SET deleted = 1 WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
