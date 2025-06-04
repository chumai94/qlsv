package com.example.controller.admin;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.dao.UserDAO;
import com.example.model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/admin/update-user")
public class UpdateUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserDAO userDAO = new UserDAO();
        Teacher users = new Teacher();
        users = userDAO.findById(id);
//        if (users.getType().equals("giaovien")){
//            req.setAttribute("activePage", "giaovien");
//        }else {
//            req.setAttribute("activePage", "sinhvien");
//        }
//        req.setAttribute("users", users);
        req.getRequestDispatcher("/view/admin/update-user.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("ten");
        String phone = req.getParameter("sdt");
        String email = req.getParameter("email");
        String address = req.getParameter("diachi");
        String dateOfBirth = req.getParameter("ngaysinh");
        String startTime = req.getParameter("starttime");
        String endTime = req.getParameter("endtime");
        String chucVu = req.getParameter("chucVu");
        String loaiChucVu = req.getParameter("loaiChucVu");


        String hashedPassword = BCrypt.withDefaults().hashToString(12,dateOfBirth.toCharArray());
        Teacher user = new Teacher();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);

        user.setDateOfBirth(Date.valueOf(dateOfBirth));

        user.setType(0);

        user.setLastmodified(new java.sql.Date(System.currentTimeMillis()));
        user.setDeleted(false);




        UserDAO userDAO = new UserDAO();


        try {
            userDAO.updateUser(user);

//            if (user.getType().equals("giaovien")){
//                req.getSession().setAttribute("successMessage", "Sửa người dùng thành công!");
//                resp.sendRedirect("/qlsv/admin/list-user");
//            }else {
//                req.getSession().setAttribute("successMessage", "Sửa người dùng thành công!");
//                resp.sendRedirect("/qlsv/admin/sinhvien");
//            }

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Có lỗi xảy ra khi thêm người dùng.");
            req.getRequestDispatcher("/view/admin/update-user.jsp").forward(req, resp);
        }
    }
}
