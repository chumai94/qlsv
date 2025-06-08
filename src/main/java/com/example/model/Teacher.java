package com.example.model;

import java.sql.Date;

public class Teacher {
    private String id;
    private String name;
    private Integer status;
    private String phone;
    private String mail;
    private Integer deleted;
    private Date createAt;
    private Date lastModified;
    private String password;
    private Integer type;
    private Date dateOfBirth;

    public Teacher(String id, String name, Integer status, String phone, String mail, Integer deleted, Date createAt, Date lastModified, String password, Integer type, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.phone = phone;
        this.mail = mail;
        this.deleted = deleted;
        this.createAt = createAt;
        this.lastModified = lastModified;
        this.password = password;
        this.type = type;
        this.dateOfBirth = dateOfBirth;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
