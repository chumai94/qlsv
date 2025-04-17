package com.example.model;

import java.sql.Date;

public class Activity {
    private String id;
    private String activity;
    private String description;
    private String ip;
    private Date createAt;
    private Date lasrmodified;
    private boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLasrmodified() {
        return lasrmodified;
    }

    public void setLasrmodified(Date lasrmodified) {
        this.lasrmodified = lasrmodified;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Activity(String id, String activity, String description, String ip, Date createAt, Date lasrmodified, boolean deleted) {
        this.id = id;
        this.activity = activity;
        this.description = description;
        this.ip = ip;
        this.createAt = createAt;
        this.lasrmodified = lasrmodified;
        this.deleted = deleted;
    }

    public Activity() {
    }
}
