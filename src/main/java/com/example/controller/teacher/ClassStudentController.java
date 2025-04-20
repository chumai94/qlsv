package com.example.controller.teacher;

import com.example.dao.ClassUserDAO;
import com.example.model.Class_User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teacher/thongtin-lop")
public class ClassStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getSession().getAttribute("id");
        List<Class_User> classUsers = new ArrayList<>();
        ClassUserDAO classUserDAO = new ClassUserDAO();
        classUsers = classUserDAO.getStudentsByTeacher(id);
        req.setAttribute("c",classUsers);
        req.getRequestDispatcher("/view/teacher/class-sinhvien.jsp").forward(req,resp);
    }
}
