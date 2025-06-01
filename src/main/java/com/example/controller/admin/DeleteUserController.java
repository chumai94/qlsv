package com.example.controller.admin;

import com.example.dao.UserDAO;
import com.example.model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/delete-user")
public class DeleteUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserDAO userDAO = new UserDAO();
        Teacher users = userDAO.findById(id);
        if (users.getType().equals("giaovien")){
            userDAO.deleteUser(id);
            req.getSession().setAttribute("successMessage", "Xóa người dùng thành công!");
            resp.sendRedirect("/qlsv/list-user");
        }else{
            userDAO.deleteUser(id);
            req.getSession().setAttribute("successMessage", "Xóa người dùng thành công!");
            resp.sendRedirect("/qlsv/admin/sinhvien");
        }
    }
}
