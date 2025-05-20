package com.example.controller.admin;

import com.example.dao.UserDAO;
import com.example.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/lock-user")
public class LockUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserDAO userDAO = new UserDAO();
        Users users = userDAO.findById(id);
        if (users.getType().equals("giaovien")){
            userDAO.lockUser(id);
            req.getSession().setAttribute("successMessage", "Khóa người dùng thành công!");
            resp.sendRedirect("/qlsv/admin/list-user");
        }else{
            userDAO.lockUser(id);
            req.getSession().setAttribute("successMessage", "Khóa người dùng thành công!");
            resp.sendRedirect("/qlsv/admin/sinhvien");
        }

    }
}
