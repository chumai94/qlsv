package com.example.controller.admin;

import com.example.dao.ClassUserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/delete-sinhvien-lop")
public class DeleteCLassStudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String classId = req.getParameter("classId");
        ClassUserDAO classUserDAO = new ClassUserDAO();
        try {
            classUserDAO.delete(classId,studentId);
            resp.sendRedirect(req.getContextPath() + "/admin/lop-student?id=" + classId + "&msg=deleted");
        }catch (Exception e){
            resp.sendRedirect(req.getContextPath() + "/admin/lop-student?id=" + classId);
        }

    }
}
