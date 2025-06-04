package com.example.controller.teacher;

import com.example.dao.ScoreSubjectDAO;
import com.example.model.ScoreSubject;
import com.example.model.Subject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/teacher/diem-sinhvien")
public class ScoreStudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = (String) req.getSession().getAttribute("id");
        String studentId = req.getParameter("studentId");

        //List<ScoreSubject> scoreSubjects = new ScoreSubjectDAO().getScoreSubjectByTeacherAndStudent(teacherId, studentId);
       // req.setAttribute("ss", scoreSubjects);
        req.setAttribute("activePage", "lophoc");
        req.getRequestDispatcher("/view/teacher/score-sinhvien.jsp").forward(req, resp);
    }
}
