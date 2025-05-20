package com.example.controller.admin;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.dao.LoginDAO;
import com.example.dao.MailDAO;
import com.example.dao.UserDAO;
import com.example.model.Users;
import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/admin/reset-pass")
public class ResetPassController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Users users = new UserDAO().findById(id);
        try {
            String plainPass = new SimpleDateFormat("yyyy-MM-dd").format(users.getDateOfBirth());
            String hashedPass = BCrypt.withDefaults().hashToString(12, plainPass.toCharArray());

            new LoginDAO().updatePassByUserId(id, hashedPass);
            String to = users.getEmail();
            String subject = "Khôi phục mật khẩu";
            String content = "Mật khẩu mới của bạn là: " + plainPass;

            MailDAO.sendEmail(to, subject, content);

            req.getSession().setAttribute("successMessage", "Mật khẩu mới đã được gửi đến email của " + id);
        } catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("successMessage", "Không thể khôi phục mật khẩu cho tài khoản " + id);
        }
        if ("sinhvien".equals(users.getType())) {
            resp.sendRedirect("/qlsv/admin/sinhvien");
        } else {
            resp.sendRedirect("/qlsv/admin/list-user");
        }
    }
}
