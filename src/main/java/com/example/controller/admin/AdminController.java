package com.example.controller.admin;

import com.example.dao.ClassDAO;
import com.example.dao.CycleDAO;
import com.example.dao.UserDAO;
import com.example.model.Cycle;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        int countTeacher = userDAO.countTeachers();
        int countStudent = userDAO.countStudents();
        int countClass = new ClassDAO().countClasses();
        req.setAttribute("teacher",countTeacher);
        req.setAttribute("student",countStudent);
        req.setAttribute("clazz",countClass);
        List<Cycle> cycles = new CycleDAO().getAll();
        req.setAttribute("cycles",cycles);
        req.setAttribute("activePage", "home");
        req.getRequestDispatcher("/view/admin/admin.jsp").forward(req,resp);
    }
}
