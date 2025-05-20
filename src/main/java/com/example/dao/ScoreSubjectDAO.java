package com.example.dao;

import com.example.model.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ScoreSubjectDAO extends DBConnect {
    public List<ScoreSubject> getScoreSubjectByTeacherAndStudent(String teacherId, String studentId) {
        List<ScoreSubject> scoreSubjects = new ArrayList<>();
        String sql = "SELECT DISTINCT " +
                "    u.id AS student_id, " +
                "    u.name AS student_name, " +
                "    s.id AS subject_id, " +
                "    s.name AS subject_name, " +
                "    s.start_date AS subject_start_date, " +
                "    s.end_date AS subject_end_date, " +
                "    COALESCE(ss.score_laborious, 0.0) AS score_laborious, " +
                "    COALESCE(ss.score_check, 0.0) AS score_check, " +
                "    COALESCE(ss.score_final, 0.0) AS score_final, " +
                "    COALESCE(ss.score_average, 0.0) AS score_average, " +
                "    ss.id AS score_subject_id " +
                "FROM class_user cu " +
                "JOIN users u ON u.id = cu.student_id " +
                "JOIN class c ON c.id = cu.class_id " +
                "JOIN subject s ON s.user_id = c.teacher_id " +
                "LEFT JOIN score_subject ss ON ss.subject_id = s.id AND ss.score_id IN (SELECT id FROM score WHERE user_id = u.id AND deleted = 0) " +
                "LEFT JOIN score sc ON sc.id = ss.score_id AND sc.user_id = u.id " +
                "WHERE u.id = ? " +
                "  AND c.teacher_id = ? " +
                "  AND u.deleted = 0 " +
                "  AND c.deleted = 0 " +
                "  AND s.deleted = 0 ";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, studentId);
            pst.setString(2, teacherId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setId(rs.getString("subject_id"));
                    subject.setName(rs.getString("subject_name"));
                    subject.setStartDate(rs.getDate("subject_start_date"));
                    subject.setEndDate(rs.getDate("subject_end_date"));

                    Users user = new Users();
                    user.setId(rs.getString("student_id"));
                    user.setName(rs.getString("student_name"));

                    Score score = new Score();
                    score.setUsers(user);

                    ScoreSubject scoreSubject = new ScoreSubject();
                    scoreSubject.setId(rs.getString("score_subject_id"));
                    scoreSubject.setScoreLaborious(rs.getDouble("score_laborious"));
                    scoreSubject.setScoreCheck(rs.getDouble("score_check"));
                    scoreSubject.setScoreFinal(rs.getDouble("score_final"));
                    scoreSubject.setScore_average(rs.getDouble("score_average"));
                    scoreSubject.setScore(score);
                    scoreSubject.setSubject(subject);
                    scoreSubjects.add(scoreSubject);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi truy vấn điểm sinh viên theo giáo viên", e);
        }

        return scoreSubjects;
    }

    public ScoreSubject findById(String id) {
        String sql = "select * from score_subject where id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Score score = new Score();
                score.setId(rs.getString("score_id"));
                Subject subject = new Subject();
                subject.setId(rs.getString("subject_id"));
                ScoreSubject scoreSubject = new ScoreSubject(
                        rs.getString("id"),
                        rs.getDouble("score_laborious"),
                        rs.getDouble("score_check"),
                        rs.getDouble("score_final"),
                        rs.getDouble("score_average"),
                        score, subject);
                return scoreSubject;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void addScoreSubject(ScoreSubject scoreSubject) {
        String sql = "INSERT INTO score_subject (id, score_laborious, score_check, score_final,score_average, score_id, subject_id) " +
                "VALUES (?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, scoreSubject.getId());
            pst.setDouble(2, scoreSubject.getScoreLaborious());
            pst.setDouble(3, scoreSubject.getScoreCheck());
            pst.setDouble(4, scoreSubject.getScoreFinal());
            pst.setDouble(5, scoreSubject.getScore_average());
            if (scoreSubject.getScore() != null && scoreSubject.getScore().getId() != null) {
                pst.setString(6, scoreSubject.getScore().getId());
            } else {
                pst.setNull(6, Types.VARCHAR);
            }
            pst.setString(7, scoreSubject.getSubject().getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateScoreSubject(ScoreSubject scoreSubject) {
        String sql = "UPDATE score_subject SET " +
                "score_laborious = ?, " +
                "score_check = ?, " +
                "score_final = ?, " +
                "score_average = ?, " +
                "score_id = ?, " +
                "subject_id = ? " +
                "WHERE id = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setDouble(1, scoreSubject.getScoreLaborious());
            pst.setDouble(2, scoreSubject.getScoreCheck());
            pst.setDouble(3, scoreSubject.getScoreFinal());
            pst.setDouble(4, scoreSubject.getScore_average());
            pst.setString(5, scoreSubject.getScore().getId());
            pst.setString(6, scoreSubject.getSubject().getId());
            pst.setString(7, scoreSubject.getId());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ScoreSubject> getScoreSubjectByStudentId(String id) {
        List<ScoreSubject> list = new ArrayList<>();
        String sql = "SELECT " +
                "subj.name AS subject_name, " +
                "c.name AS semester_name, " +
                "ss.score_laborious, " +
                "ss.score_check, " +
                "ss.score_final, " +
                "subj.process_coefficient, " +
                "subj.exam_coefficient " +
                "FROM score_subject ss " +
                "JOIN subject subj ON ss.subject_id = subj.id " +
                "JOIN cycle c ON subj.cycle_id = c.id " +
                "JOIN score sc ON ss.score_id = sc.id " +
                "WHERE sc.user_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setName(rs.getString("subject_name"));
                subject.setProcessCoefficient(rs.getDouble("process_coefficient"));
                subject.setExamCoefficient(rs.getDouble("exam_coefficient"));

                Cycle cycle = new Cycle();
                cycle.setName(rs.getString("semester_name"));
                subject.setCycle(cycle);

                ScoreSubject ss = new ScoreSubject();
                ss.setScoreLaborious(rs.getDouble("score_laborious"));
                ss.setScoreCheck(rs.getDouble("score_check"));
                ss.setScoreFinal(rs.getDouble("score_final"));
                ss.setSubject(subject);

                list.add(ss);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public List<ScoreSubject> getScoreSubjectByStudentIdAndCycleId(String id, String cycleId) {
        List<ScoreSubject> list = new ArrayList<>();
        String sql = "SELECT " +
                "subj.name AS subject_name, " +
                "c.name AS semester_name, " +
                "ss.score_laborious, " +
                "ss.score_check, " +
                "ss.score_final, " +
                "subj.process_coefficient, " +
                "subj.exam_coefficient " +
                "FROM score_subject ss " +
                "JOIN subject subj ON ss.subject_id = subj.id " +
                "JOIN cycle c ON subj.cycle_id = c.id " +
                "JOIN score sc ON ss.score_id = sc.id " +
                "WHERE sc.user_id = ? and c.id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, cycleId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setName(rs.getString("subject_name"));
                subject.setProcessCoefficient(rs.getDouble("process_coefficient"));
                subject.setExamCoefficient(rs.getDouble("exam_coefficient"));

                Cycle cycle = new Cycle();
                cycle.setName(rs.getString("semester_name"));
                subject.setCycle(cycle);

                ScoreSubject ss = new ScoreSubject();
                ss.setScoreLaborious(rs.getDouble("score_laborious"));
                ss.setScoreCheck(rs.getDouble("score_check"));
                ss.setScoreFinal(rs.getDouble("score_final"));
                ss.setSubject(subject);

                list.add(ss);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public ScoreSubject getScoreByClassAndStudent(String classId, String studentId) {
        String sql = "SELECT " +
                "u.id AS student_id, " +
                "u.name AS student_name, " +
                "s.id AS subject_id, " +
                "s.name AS subject_name, " +
                "s.process_coefficient AS subject_process_coefficient, " +
                "s.exam_coefficient AS subject_exam_coefficient,  " +
                "ss.* " +
                "FROM class_user cu " +
                "JOIN users u ON cu.student_id = u.id " +
                "JOIN class c ON cu.class_id = c.id " +
                "JOIN subject s ON c.subject_id = s.id " +
                "LEFT JOIN score sc ON sc.user_id = u.id " +
                "LEFT JOIN score_subject ss ON ss.score_id = sc.id AND ss.subject_id = s.id " +
                "WHERE cu.class_id = ? AND u.id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, classId);
            ps.setString(2, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getString("subject_id"));
                subject.setName(rs.getString("subject_name"));
                subject.setProcessCoefficient(rs.getDouble("subject_process_coefficient"));
                subject.setExamCoefficient(rs.getDouble("subject_exam_coefficient"));
                Users user = new Users();
                user.setId(rs.getString("student_id"));
                user.setName(rs.getString("student_name"));

                Score score = new Score();
                score.setUsers(user);

                ScoreSubject ss = new ScoreSubject();
                ss.setScoreLaborious(rs.getDouble("score_laborious"));
                ss.setScoreCheck(rs.getDouble("score_check"));
                ss.setScoreFinal(rs.getDouble("score_final"));
                ss.setScore_average(rs.getDouble("score_average"));
                ss.setSubject(subject);
                ss.setScore(score);

                return ss;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi truy vấn điểm sinh viên", e);
        }

        return null;
    }

    public ScoreSubject getScoreSubjectBySubjectId(String subjectId) {
        ScoreSubject scoreSubject = null;
        String sql = "SELECT * FROM score_subject WHERE subject_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, subjectId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Subject subject = new SubjectDAO().findById(rs.getString("subject_id"));
                scoreSubject = new ScoreSubject(
                        rs.getString("id"),
                        rs.getDouble("score_laborious"),
                        rs.getDouble("score_check"),
                        rs.getDouble("score_final"),
                        rs.getDouble("score_average"),
                        null,
                        subject
                );
                return scoreSubject;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getEndDate(String scoreSubjectId) {
        String sql = "SELECT end_date FROM score_subject WHERE id = ?";
        String endDateStr = "";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, scoreSubjectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Date endDate = rs.getDate("end_date");
                if (endDate != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    endDateStr = sdf.format(endDate);
                } else {
                    endDateStr = "Không có thông tin thời gian sửa điểm";
                }
            } else {
                endDateStr = "Không tìm thấy thông tin thời gian sửa điểm";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            endDateStr = "Lỗi khi truy vấn dữ liệu";
        }
        return endDateStr;
    }

    public List<ScoreSubject> getScoreSubjectByClassAndStudent(String classId, String studentId) {
        List<ScoreSubject> scoreSubjects = new ArrayList<>();
        String sql = "SELECT " +
                "    u.id AS student_id, " +
                "    u.name AS student_name, " +
                "    s.id AS subject_id, " +
                "    s.name AS subject_name, " +
                "    s.start_date AS subject_start_date, " +
                "    s.end_date AS subject_end_date, " +
                "    COALESCE(ss.score_laborious, 0.0) AS score_laborious, " +
                "    COALESCE(ss.score_check, 0.0) AS score_check, " +
                "    COALESCE(ss.score_final, 0.0) AS score_final, " +
                "    COALESCE(ss.score_average, 0.0) AS score_average, " +
                "    ss.id AS score_subject_id " +
                "FROM class_user cu " +
                "JOIN users u ON u.id = cu.student_id " +
                "JOIN class c ON c.id = cu.class_id " +
                "JOIN subject s ON s.user_id = c.teacher_id " +
                "LEFT JOIN score_subject ss ON ss.subject_id = s.id AND ss.score_id IN ( " +
                "    SELECT sc.id " +
                "    FROM score sc " +
                "    WHERE sc.user_id = u.id AND sc.deleted = 0 " +
                ") " +
                "WHERE u.id = ? " +
                "  AND c.id = ? " +
                "  AND c.deleted = 0 " +
                "  AND u.deleted = 0 " +
                "  AND s.deleted = 0 ";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, studentId);
            pst.setString(2, classId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setId(rs.getString("subject_id"));
                    subject.setName(rs.getString("subject_name"));
                    subject.setStartDate(rs.getDate("subject_start_date"));
                    subject.setEndDate(rs.getDate("subject_end_date"));

                    Users user = new Users();
                    user.setId(rs.getString("student_id"));
                    user.setName(rs.getString("student_name"));

                    Score score = new Score();
                    score.setUsers(user);

                    ScoreSubject scoreSubject = new ScoreSubject();
                    scoreSubject.setId(rs.getString("score_subject_id"));
                    scoreSubject.setScoreLaborious(rs.getDouble("score_laborious"));
                    scoreSubject.setScoreCheck(rs.getDouble("score_check"));
                    scoreSubject.setScoreFinal(rs.getDouble("score_final"));
                    scoreSubject.setScore_average(rs.getDouble("score_average"));
                    scoreSubject.setScore(score);
                    scoreSubject.setSubject(subject);
                    scoreSubjects.add(scoreSubject);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi truy vấn điểm sinh viên theo giáo viên", e);
        }

        return scoreSubjects;
    }

    public void deleteScoreSubjectById(String id) {
        String sql = "DELETE FROM score_subject WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ScoreSubject> findScoresByStudentId(String studentId) throws SQLException {
        String sql = "SELECT ss.* FROM score_subject ss " +
                "JOIN score sc ON ss.score_id = sc.id " +
                "WHERE sc.user_id = ? AND sc.deleted = 0";

        List<ScoreSubject> scores = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ScoreSubject ss = new ScoreSubject();
                Score score = new ScoreDAO().findById(rs.getString("score_id"));
                Subject subject = new SubjectDAO().findById(rs.getString("subject_id"));
                ss.setId(rs.getString("id"));
                ss.setScoreLaborious(rs.getDouble("score_laborious"));
                ss.setScoreCheck(rs.getDouble("score_check"));
                ss.setScoreFinal(rs.getDouble("score_final"));
                ss.setScore_average(rs.getDouble("score_average"));
                ss.setScore(score);
                ss.setSubject(subject);
                scores.add(ss);
            }
        }
        return scores;
    }
}

