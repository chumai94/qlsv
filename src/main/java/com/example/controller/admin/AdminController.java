package com.example.controller.admin;

import com.example.dao.UserDAO;
import com.example.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = {"/list-user"})
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> usersList = new ArrayList<Users>();
        UserDAO userDAO = new UserDAO();
        usersList = userDAO.getAll();
        req.setAttribute("usersList",usersList);
        req.getRequestDispatcher("/view/admin/index.jsp").forward(req,resp);
    }
}
