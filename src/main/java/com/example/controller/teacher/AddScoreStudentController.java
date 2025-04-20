package com.example.controller.teacher;

import com.example.dao.ScoreDAO;
import com.example.dao.SubjectDAO;
import com.example.model.Score;
import com.example.model.Subject;
import com.example.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/teacher/add-score")
public class AddScoreController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        Users users = new Users();
        users.setId(studentId);
        Score score = new Score();
        score.setId(UUID.randomUUID().toString().substring(0,16));
        score.setCreateAt(new Date(System.currentTimeMillis()));
        score.setLastmodified(new Date(System.currentTimeMillis()));
        score.setDeleted(false);
        score.setUsers(users);
        ScoreDAO scoreDAO = new ScoreDAO();
        scoreDAO.add(score);
        String teacherId = (String) req.getSession().getAttribute("id");
        List<Subject> subjects = new ArrayList<>();
        SubjectDAO subjectDAO = new SubjectDAO();
        subjects = subjectDAO.getSubjectsByTeacherId(teacherId);
        req.setAttribute("ss",subjects);
        req.setAttribute("scoreId",score.getId());
        req.getRequestDispatcher("/view/teacher/add-score.jsp").forward(req,resp);
    }
}
