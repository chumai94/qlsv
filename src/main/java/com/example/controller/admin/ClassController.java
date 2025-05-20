package com.example.controller.admin;

import com.example.dao.ClassDAO;
import com.example.model.Class;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/lop-hoc")
public class ClassController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        if (keyword == null) keyword = "";
        List<Class> classList = new ClassDAO().searchByName(keyword);
        req.setAttribute("cl", classList);
        req.setAttribute("keyword", keyword);
        req.setAttribute("activePage", "lophoc");
        req.getRequestDispatcher("/view/admin/lop-hoc.jsp").forward(req, resp);
    }
}
