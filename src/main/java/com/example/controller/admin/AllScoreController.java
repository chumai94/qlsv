package com.example.controller.admin;

import com.example.dao.ScoreSubjectDAO;
import com.example.model.ScoreSubject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/all-score-student")
public class AllScoreController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("id");
        try {
            List<ScoreSubject> scoreSubjects = new ScoreSubjectDAO().findScoresByStudentId(studentId);
            req.setAttribute("ss",scoreSubjects);
            req.setAttribute("activePage", "sinhvien");
            req.getRequestDispatcher("/view/admin/all-score.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
