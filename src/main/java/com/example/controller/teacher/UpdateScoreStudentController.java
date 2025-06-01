package com.example.controller.teacher;

import com.example.dao.ScoreDAO;
import com.example.dao.ScoreSubjectDAO;
import com.example.dao.SubjectDAO;
import com.example.model.ScoreSubject;
import com.example.model.Subject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/teacher/update-score")
public class UpdateScoreStudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("scoreSubjectId");
        String studentId = req.getParameter("studentId");
        ScoreSubjectDAO scoreSubjectDAO = new ScoreSubjectDAO();
        ScoreSubject scoreSubject = scoreSubjectDAO.findById(id);
        String teacherId = (String) req.getSession().getAttribute("id");
        req.setAttribute("ss",scoreSubject);
        req.setAttribute("studentId",studentId);
        req.setAttribute("activePage", "lophoc");
        System.out.println("..."+id);
        req.getRequestDispatcher("/view/teacher/update-score.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("ssid");
        String scoreLaborious = req.getParameter("chuyencan");
        String scoreCheck = req.getParameter("kiemtra");
        String scoreFinal = req.getParameter("thi");
        String scoreId = req.getParameter("scoreId");
        String subjectId = req.getParameter("sid");
        try {
            double laborious = Double.parseDouble(scoreLaborious);
            double check = Double.parseDouble(scoreCheck);
            double sFinal = Double.parseDouble(scoreFinal);
            Score score = new ScoreDAO().findById(scoreId);
            Subject subject  = new SubjectDAO().findById(subjectId);
            ScoreSubject ss = new ScoreSubject();
            ss.setId(id);
            ss.setScoreLaborious(laborious);
            ss.setScoreCheck(check);
            ss.setScoreFinal(sFinal);
            double diem1 = ((laborious+check)/2);
            ss.setScore_average(diem1*subject.getProcessCoefficient()+sFinal*subject.getExamCoefficient());
            ss.setScore(score);
            ss.setSubject(subject);
            ScoreSubjectDAO subjectDAO = new ScoreSubjectDAO();
            subjectDAO.updateScoreSubject(ss);
            req.getSession().setAttribute("successMessage", "Sửa điểm thành công!");
            resp.sendRedirect("/qlsv/teacher/diem-sinhvien?studentId="+ss.getScore().getUsers().getId());
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("error","Đã xảy ra lỗi khi sửa điểm mời sửa lại");
            req.getRequestDispatcher("/view/teacher/update-score.jsp").forward(req,resp);
        }
    }
}
