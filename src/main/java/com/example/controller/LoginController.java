package com.example.controller;

import com.example.dao.LoginDAO;
import com.example.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        LoginDAO loginDAO = new LoginDAO();
        Users users = loginDAO.login(username,password);
        if (users != null){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("id",users.getId());
            httpSession.setAttribute("name",users.getName());
            httpSession.setAttribute("type",users.getType());
            httpSession.setAttribute("typeposition",users.getTypePosition());
            if (users.getType().equals("giaovien")){
                resp.sendRedirect("/qlsv/teacher");
            } else if (users.getType().equals("sinhvien")) {
                resp.sendRedirect("/qlsv/student");
            }else {
                resp.sendRedirect("/qlsv/list-user");
            }
        }else {
            req.setAttribute("error","Tên đăng nhập hoặc mật khẩu ko đúng");
            req.getRequestDispatcher("/view/login.jsp").forward(req,resp);
        }
    }
}
