package com.example.controller.admin;

import com.example.dao.ScoreSubjectDAO;
import com.example.model.ScoreSubject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/diem-student")
public class ScoreStudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classId = req.getParameter("id");
        String studentId = req.getParameter("studentId");
        List<ScoreSubject> scoreSubjects = new ScoreSubjectDAO().getScoreSubjectByClassAndStudent(classId,studentId);
        req.setAttribute("classId",classId);
        req.setAttribute("ss", scoreSubjects);
        req.setAttribute("activePage", "lophoc");
        req.getRequestDispatcher("/view/admin/score-sinhvien.jsp").forward(req,resp);
    }
}
