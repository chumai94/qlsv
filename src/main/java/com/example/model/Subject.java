package com.example.model;

import java.sql.Date;

public class Subject {
    private String id;
    private String name;
    private String description;
    private Date createAt;
    private Date lastmodified;
    private boolean deleted;
    private boolean status;
    private Cycle cycle;

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Subject(String id, String name, String description, Date createAt, Date lastmodified, boolean deleted, boolean status, Cycle cycle) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createAt = createAt;
        this.lastmodified = lastmodified;
        this.deleted = deleted;
        this.status = status;
        this.cycle = cycle;
    }

    public Subject() {
    }
}
