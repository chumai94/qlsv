package com.example.dao;

import com.example.model.Score;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO extends DBConnect{
    public List<Score> getAll() {
        List<Score> list = new ArrayList<>();
        String sql = "SELECT * FROM score WHERE deleted = 0";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Score score = new Score();
                score.setId(rs.getString("id"));
                score.setCreateAt(rs.getDate("created_at"));
                score.setLastmodified(rs.getDate("lastmodified"));
                score.setDeleted(rs.getBoolean("deleted"));
                list.add(score);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Score findById(String id) {
        String sql = "SELECT * FROM score WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Score score = new Score();
                score.setId(rs.getString("id"));
                score.setCreateAt(rs.getDate("created_at"));
                score.setLastmodified(rs.getDate("lastmodified"));
                score.setDeleted(rs.getBoolean("deleted"));
                return score;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void add(Score score, String userId) {
        String sql = "INSERT INTO score (id, created_at, lastmodified, deleted, user_id) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, score.getId());
            ps.setDate(2, new java.sql.Date(score.getCreateAt().getTime()));
            ps.setDate(3, new java.sql.Date(score.getLastmodified().getTime()));
            ps.setBoolean(4, score.isDeleted());
            ps.setString(5, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Score score) {
        String sql = "UPDATE score SET lastmodified = ?, deleted = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(score.getLastmodified().getTime()));
            ps.setBoolean(2, score.isDeleted());
            ps.setString(3, score.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        String sql = "UPDATE score SET deleted = 1 WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
