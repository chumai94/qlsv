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
        Teacher users = new Teacher(rs.getString("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"), rs.getString("address"), rs.getDate("date_of_birth"), rs.getString("type"), rs.getDate("starttime"), rs.getDate("endtime"), rs.getDate("create_at"), rs.getDate("lastmodified"), rs.getBoolean("deleted"), rs.getBoolean("lock_status"));
        users = userDAO.findById(id);
        if (users.getType().equals("giaovien")){
            req.setAttribute("activePage", "giaovien");
        }else {
            req.setAttribute("activePage", "sinhvien");
        }
        req.setAttribute("users", users);
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
        Teacher user = new Teacher(rs.getString("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"), rs.getString("address"), rs.getDate("date_of_birth"), rs.getString("type"), rs.getDate("starttime"), rs.getDate("endtime"), rs.getDate("create_at"), rs.getDate("lastmodified"), rs.getBoolean("deleted"), rs.getBoolean("lock_status"));
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddress(address);
        user.setDateOfBirth(Date.valueOf(dateOfBirth));
        user.setStartTime(Date.valueOf(startTime));
        user.setEndTime(Date.valueOf(endTime));
        user.setType(chucVu);
        user.setTypePosition(loaiChucVu);
        user.setLastmodified(new java.sql.Date(System.currentTimeMillis()));
        user.setDeleted(false);
        user.setLockStatus(false);



        UserDAO userDAO = new UserDAO();


        try {
            userDAO.updateUser(user);

            if (user.getType().equals("giaovien")){
                req.getSession().setAttribute("successMessage", "Sửa người dùng thành công!");
                resp.sendRedirect("/qlsv/admin/list-user");
            }else {
                req.getSession().setAttribute("successMessage", "Sửa người dùng thành công!");
                resp.sendRedirect("/qlsv/admin/sinhvien");
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Có lỗi xảy ra khi thêm người dùng.");
            req.getRequestDispatcher("/view/admin/update-user.jsp").forward(req, resp);
        }
    }
}
