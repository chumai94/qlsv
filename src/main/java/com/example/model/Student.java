package com.example.model;

import java.sql.Date;

public class Student {
    private String id;
    private String name;
    private Date startYear;
    private Date endYear;
    private Date dateOfBirth;
    private String address;
    private Integer phone;
    private String email;
    private Integer deleted;
    private Integer status;
    private Date createAt;
    private Date lastmodified;
    private String password;

    public Student() {
    }

    public Student(String id, String name, Date startYear, Date endYear, Date dateOfBirth, String address, Integer phone, String email, Integer deleted, Integer status, Date createAt, Date lastmodified, String password) {
        this.id = id;
        this.name = name;
        this.startYear = startYear;
        this.endYear = endYear;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.deleted = deleted;
        this.status = status;
        this.createAt = createAt;
        this.lastmodified = lastmodified;
        this.password = password;
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

    public Date getStartYear() {
        return startYear;
    }

    public void setStartYear(Date startYear) {
        this.startYear = startYear;
    }

    public Date getEndYear() {
        return endYear;
    }

    public void setEndYear(Date endYear) {
        this.endYear = endYear;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
