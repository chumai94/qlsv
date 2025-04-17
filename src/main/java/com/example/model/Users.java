package com.example.model;

import java.sql.Date;

public class Users {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Date dateOfBirth;
    private String type;
    private String typePosition;
    private Date startTime;
    private Date endTime;
    private Date createAt;
    private Date lastmodified;
    private boolean deleted;
    private boolean lockStatus;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public boolean isLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(boolean lockStatus) {
        this.lockStatus = lockStatus;
    }

    

    public Users(String id, String name, String phone, String email, String address, Date dateOfBirth, String type,
			String typePosition, Date startTime, Date endTime, Date createAt, Date lastmodified, boolean deleted,
			boolean lockStatus) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.type = type;
		this.typePosition = typePosition;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createAt = createAt;
		this.lastmodified = lastmodified;
		this.deleted = deleted;
		this.lockStatus = lockStatus;
	}

	public String getTypePosition() {
		return typePosition;
	}

	public void setTypePosition(String typePosition) {
		this.typePosition = typePosition;
	}

	public Users() {
    }
}
