package com.example.model;

public class Class_User {
    private Users users;
    private Class aClass;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Class_User(Users users, Class aClass) {
        this.users = users;
        this.aClass = aClass;
    }

    public Class_User() {
    }
}
