package com.example.dao;

import com.example.model.ScoreSubject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreSubjectDAO extends DBConnect{
    public List<ScoreSubject> getAll() {
        List<ScoreSubject> list = new ArrayList<>();
        String sql = "SELECT * FROM score_subject";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ScoreSubject ss = new ScoreSubject();
                ss.setId(rs.getString("id"));
                ss.setScoreLaborious(rs.getDouble("score_laborious"));
                ss.setScoreCheck(rs.getDouble("score_check"));
                ss.setScoreTest(rs.getDouble("score_test"));
                ss.setPercentScoreTest(rs.getDouble("percent_score_test"));
                ss.setNumberTest(rs.getInt("number_test"));
                ss.setScoreFinal(rs.getDouble("score_final"));
                list.add(ss);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public ScoreSubject findById(String id) {
        String sql = "SELECT * FROM score_subject WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ScoreSubject ss = new ScoreSubject();
                ss.setId(rs.getString("id"));
                ss.setScoreLaborious(rs.getDouble("score_laborious"));
                ss.setScoreCheck(rs.getDouble("score_check"));
                ss.setScoreTest(rs.getDouble("score_test"));
                ss.setPercentScoreTest(rs.getDouble("percent_score_test"));
                ss.setNumberTest(rs.getInt("number_test"));
                ss.setScoreFinal(rs.getDouble("score_final"));
                return ss;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void add(ScoreSubject ss, String scoreId, String subjectId) {
        String sql = "INSERT INTO score_subject (id, score_laborious, score_check, score_test, percent_score_test, number_test, score_final, score_id, subject_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ss.getId());
            ps.setDouble(2, ss.getScoreLaborious());
            ps.setDouble(3, ss.getScoreCheck());
            ps.setDouble(4, ss.getScoreTest());
            ps.setDouble(5, ss.getPercentScoreTest());
            ps.setInt(6, ss.getNumberTest());
            ps.setDouble(7, ss.getScoreFinal());
            ps.setString(8, scoreId);
            ps.setString(9, subjectId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ScoreSubject ss) {
        String sql = "UPDATE score_subject SET score_laborious = ?, score_check = ?, score_test = ?, percent_score_test = ?, number_test = ?, score_final = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, ss.getScoreLaborious());
            ps.setDouble(2, ss.getScoreCheck());
            ps.setDouble(3, ss.getScoreTest());
            ps.setDouble(4, ss.getPercentScoreTest());
            ps.setInt(5, ss.getNumberTest());
            ps.setDouble(6, ss.getScoreFinal());
            ps.setString(7, ss.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        String sql = "DELETE FROM score_subject WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
