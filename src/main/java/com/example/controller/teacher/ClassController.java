package com.example.controller.teacher;

import com.example.dao.ClassDAO;
import com.example.model.Class;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/thongtin-lop")
public class ClassController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getSession().getAttribute("id");
        List<Class> classes = new ClassDAO().getClassByTeacher(id);
        req.setAttribute("c",classes);
        req.setAttribute("activePage", "lophoc");
        req.getRequestDispatcher("/view/teacher/class.jsp").forward(req,resp);
    }
}
