package com.example.controller.student;

import com.example.dao.CycleDAO;
import com.example.dao.ScoreDAO;
import com.example.dao.ScoreSubjectDAO;
import com.example.model.Cycle;
import com.example.model.ScoreSubject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student/student-score")
public class StudentScoreController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getSession().getAttribute("id");
        List<Cycle> cycles = new CycleDAO().getCyclesByStudentId(id);
        req.setAttribute("cycle", cycles);
        String maHocKy = req.getParameter("maHocKy");
        double diemTong = new ScoreDAO().getAverageScoreAllCourse(id);
        if (maHocKy == null) {
            maHocKy = "all";
        }
        List<ScoreSubject> scoreSubjects;
        double scoreByCycle = 0;
        if ("all".equals(maHocKy)) {
            //scoreSubjects = new ScoreSubjectDAO().getScoreSubjectByStudentId(id);
        } else {
            scoreByCycle = new ScoreDAO().getScoreByCycleId(id, maHocKy);
            //scoreSubjects = new ScoreSubjectDAO().getScoreSubjectByStudentIdAndCycleId(id, maHocKy);
        }
        req.setAttribute("diemTong",diemTong);
        req.setAttribute("scoreByCycle", scoreByCycle);
       // req.setAttribute("ss", scoreSubjects);
        req.setAttribute("activePage", "tongdiem");
        req.getRequestDispatcher("/view/student/score.jsp").forward(req, resp);
    }
}
