package com.example.controller.teacher;

import com.example.dao.SubjectDAO;
import com.example.model.Subject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teacher/mon-hoc")
public class SubjectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getSession().getAttribute("id");
        List<Subject> subjects = new ArrayList<>();
        SubjectDAO subjectDAO = new SubjectDAO();
        subjects = subjectDAO.getSubjectsByTeacherId(id);
        req.setAttribute("subject",subjects);
        req.getRequestDispatcher("/view/teacher/subject.jsp").forward(req,resp);
    }
}
