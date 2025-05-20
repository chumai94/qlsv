package com.example.controller.admin;

import com.example.dao.ScoreSubjectDAO;
import com.example.model.ScoreSubject;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/get-student-scores")
public class GetStudentScoreController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classId = req.getParameter("classId");
        String studentId = req.getParameter("studentId");

        if (classId == null || studentId == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"error\": \"Thiếu tham số classId hoặc studentId\"}");
            return;
        }

        ScoreSubject scoreSubject = new ScoreSubjectDAO().getScoreByClassAndStudent(classId, studentId);

        if (scoreSubject == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("{\"error\": \"Không tìm thấy thông tin điểm của sinh viên\"}");
            return;
        }
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(scoreSubject);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
    }
}
