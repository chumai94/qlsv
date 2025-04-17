package com.example.model;

public class Login {
    private String id;
    private String username;
    private String password;
    private boolean deleted;
    private Users users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Login(String id, String username, String password, boolean deleted, Users users) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.deleted = deleted;
        this.users = users;
    }

    public Login() {
    }
}
