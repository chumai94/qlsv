package com.example.model;

import java.sql.Date;

public class ScoreSubject {
    private String id;
    private double scoreLaborious;
    private double scoreCheck;
    private double scoreFinal;
    private double score_average;
    private Score score;
    private Subject subject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getScoreLaborious() {
        return scoreLaborious;
    }

    public void setScoreLaborious(double scoreLaborious) {
        this.scoreLaborious = scoreLaborious;
    }

    public double getScoreCheck() {
        return scoreCheck;
    }

    public void setScoreCheck(double scoreCheck) {
        this.scoreCheck = scoreCheck;
    }

    public double getScoreFinal() {
        return scoreFinal;
    }

    public void setScoreFinal(double scoreFinal) {
        this.scoreFinal = scoreFinal;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getScore_average() {
        return score_average;
    }

    public void setScore_average(double score_average) {
        this.score_average = score_average;
    }

    public ScoreSubject(String id, double scoreLaborious, double scoreCheck, double scoreFinal, double score_average, Score score, Subject subject) {
        this.id = id;
        this.scoreLaborious = scoreLaborious;
        this.scoreCheck = scoreCheck;
        this.scoreFinal = scoreFinal;
        this.score_average = score_average;
        this.score = score;
        this.subject = subject;
    }

    public ScoreSubject() {
    }
}
