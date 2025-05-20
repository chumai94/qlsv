package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    protected static Connection conn = null;
    public DBConnect(){
        try {
            String url = "jdbc:mysql://localhost:3306/qlsv";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        if (conn == null) {
            new DBConnect();
        }
        return conn;
    }
}
