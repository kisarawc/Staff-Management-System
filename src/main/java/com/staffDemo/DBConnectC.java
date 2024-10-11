package com.staffDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectC {
    private static String url = "jdbc:mysql://localhost:3306/staffmanagementsystem";
    private static String user = "root";
    private static String pass = "chathu123";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection not successful!!");
        }
        return con;
    }
}
