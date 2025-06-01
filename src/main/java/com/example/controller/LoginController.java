package com.example.controller;

import com.example.dao.LoginDAO;
import com.example.dao.UserDAO;
import com.example.model.Teacher;
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
        HttpSession session = req.getSession();
        Integer failedAttempts = (Integer) session.getAttribute("failedAttempts");
        if (failedAttempts == null) failedAttempts = 0;
        UserDAO userDAO = new UserDAO();
        LoginDAO loginDAO = new LoginDAO();
        Teacher userFromDb = userDAO.findById(username);
        if (userFromDb == null) {
            req.setAttribute("error", "Tài khoản không tồn tại.");
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
            return;
        }
        if (userFromDb.isDeleted()) {
            req.setAttribute("error", "Tài khoản của bạn đã bị xóa.");
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
            return;
        }
        if (userFromDb.isLockStatus()) {
            req.setAttribute("error", "Tài khoản của bạn đã bị khóa.");
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
            return;
        }
        Teacher userLogin = loginDAO.login(username, password);
        if (userLogin != null) {
            session.removeAttribute("failedAttempts");

            session.setAttribute("id", userLogin.getId());
            session.setAttribute("name", userLogin.getName());
            session.setAttribute("type", userLogin.getType());
            session.setAttribute("typeposition", userLogin.getTypePosition());

            if ("giaovien".equals(userLogin.getType())) {
                resp.sendRedirect("/qlsv/teacher");
            } else if ("sinhvien".equals(userLogin.getType())) {
                resp.sendRedirect("/qlsv/student");
            } else  if ("admin".equals(userLogin.getType())){
                resp.sendRedirect("/qlsv/admin");
            }
            return;
        }
        failedAttempts++;
        session.setAttribute("failedAttempts", failedAttempts);
        if (failedAttempts >= 3) {
            userDAO.lockUser(userFromDb.getId());
            req.setAttribute("error", "Tài khoản của bạn đã bị khóa do nhập sai quá 3 lần.");
        } else {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
        }

        req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
    }
}
