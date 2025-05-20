package com.example.model;

import java.sql.Date;

public class Score {
    private String id;
    private Date createAt;
    private Date lastmodified;
    private boolean deleted;
    private Users users;
    private double scoreAverage;

    public Score(String id, Date createAt, Date lastmodified, boolean deleted, Users users, double scoreAverage) {
        this.id = id;
        this.createAt = createAt;
        this.lastmodified = lastmodified;
        this.deleted = deleted;
        this.users = users;
        this.scoreAverage = scoreAverage;
    }

    public double getScoreAverage() {
        return scoreAverage;
    }

    public void setScoreAverage(double scoreAverage) {
        this.scoreAverage = scoreAverage;
    }

    public Score(String id, Date createAt, Date lastmodified, boolean deleted, Users users) {
        this.id = id;
        this.createAt = createAt;
        this.lastmodified = lastmodified;
        this.deleted = deleted;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Score() {
    }
}
