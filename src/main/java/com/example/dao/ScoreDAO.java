package com.example.dao;

import com.example.model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO extends DBConnect{

    public double getScoreByCycleId(String studentId, String cycleId) {
        String sql = "SELECT AVG(ss.score_average) AS average_score " +
                "FROM score s " +
                "JOIN score_subject ss ON s.id = ss.score_id " +
                "JOIN subject sub ON ss.subject_id = sub.id " +
                "JOIN cycle c ON sub.cycle_id = c.id " +
                "JOIN users u ON s.user_id = u.id " +
                "WHERE c.id = ? AND u.id = ? AND s.deleted = 0 AND sub.deleted = 0 " +
                "GROUP BY u.id, c.id";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cycleId);
            ps.setString(2, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("average_score");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0.0;
    }
    public double getAverageScoreAllCourse(String studentId) {
        String sql = "SELECT AVG(ss.score_average) AS average_score " +
                "FROM score s " +
                "JOIN score_subject ss ON s.id = ss.score_id " +
                "WHERE s.user_id = ? AND s.deleted = 0";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("average_score");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0.0;
    }
//    public List<Score> getTopStudentsByCycle(String cycleId) {
//        List<Score> scores = new ArrayList<>();
//        String sql = "SELECT s.user_id AS student_id, u.name AS student_name, AVG(ss.score_average) AS average_score "
//                + "FROM score s "
//                + "LEFT JOIN score_subject ss ON s.id = ss.score_id "
//                + "LEFT JOIN subject sub ON ss.subject_id = sub.id "
//                + "LEFT JOIN cycle c ON sub.cycle_id = c.id "
//                + "LEFT JOIN users u ON s.user_id = u.id "
//                + "WHERE s.deleted = 0 "
//                + "AND u.type = 'sinhvien' ";
//        if (!"all".equals(cycleId)) {
//            sql += "AND c.id = ? ";
//        }
//        sql += "GROUP BY s.user_id, u.name "
//                + "ORDER BY average_score DESC "
//                + "LIMIT 5";
//        try (PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            if (!"all".equals(cycleId)) {
//                ps.setString(1, cycleId);
//            }
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String studentId = rs.getString("student_id");
//                String studentName = rs.getString("student_name");
//                double averageScore = rs.getDouble("average_score");
//                Teacher user = new Teacher(rs.getString("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"), rs.getString("address"), rs.getDate("date_of_birth"), rs.getString("type"), rs.getDate("starttime"), rs.getDate("endtime"), rs.getDate("create_at"), rs.getDate("lastmodified"), rs.getBoolean("deleted"), rs.getBoolean("lock_status"));
//                user.setId(studentId);
//                user.setName(studentName);
//                Score score = new Score();
//                score.setUsers(user);
//                score.setScoreAverage(averageScore);
//                scores.add(score);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return scores;
//    }

}

