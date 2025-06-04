package com.example.controller.student;

import com.example.dao.ClassDAO;
import com.example.dao.UserDAO;
import com.example.model.Class;
import com.example.model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/student/profile")
public class ProfileStudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getSession().getAttribute("id");
        Teacher student = new Teacher();
        student = new UserDAO().findById(id);
        Class aClass = new Class();
        aClass = new ClassDAO().getClassByStudentId(id);
        req.setAttribute("cl",aClass);
        req.setAttribute("st",student);
        req.setAttribute("activePage", "profile");
        req.getRequestDispatcher("/view/student/profile.jsp").forward(req,resp);
    }
}
