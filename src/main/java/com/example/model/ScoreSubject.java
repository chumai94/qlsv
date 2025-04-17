package com.example.model;

public class ScoreSubject {
    private String id;
    private double scoreLaborious;
    private double scoreCheck;
    private double scoreTest;
    private double percentScoreTest;
    private int numberTest;
    private double scoreFinal;

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

    public double getScoreTest() {
        return scoreTest;
    }

    public void setScoreTest(double scoreTest) {
        this.scoreTest = scoreTest;
    }

    public double getPercentScoreTest() {
        return percentScoreTest;
    }

    public void setPercentScoreTest(double percentScoreTest) {
        this.percentScoreTest = percentScoreTest;
    }

    public int getNumberTest() {
        return numberTest;
    }

    public void setNumberTest(int numberTest) {
        this.numberTest = numberTest;
    }

    public double getScoreFinal() {
        return scoreFinal;
    }

    public void setScoreFinal(double scoreFinal) {
        this.scoreFinal = scoreFinal;
    }

    public ScoreSubject(String id, double scoreLaborious, double scoreCheck, double scoreTest, double percentScoreTest, int numberTest, double scoreFinal) {
        this.id = id;
        this.scoreLaborious = scoreLaborious;
        this.scoreCheck = scoreCheck;
        this.scoreTest = scoreTest;
        this.percentScoreTest = percentScoreTest;
        this.numberTest = numberTest;
        this.scoreFinal = scoreFinal;
    }

    public ScoreSubject() {
    }
}
