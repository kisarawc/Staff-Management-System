package com.StaffManagement.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginModel {
    public static boolean authenticateUser(String username, String password, HttpServletRequest request) {
        String url = "jdbc:mysql://localhost:3306/StaffManagementSystem";
        String dbUsername = "root";
        String dbPassword = "chathu123";

        try {
            Class.forName("com.mysql.jdbc.Driver"); //check version
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            String query = "SELECT * FROM Users WHERE Username=? AND Password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean userExists = resultSet.next();

            if (userExists) {
                // Get the user role and StaffID from the result set
                String userRole = resultSet.getString("Role");
                @SuppressWarnings("unused")
				String staffID = resultSet.getString("StaffID");
                
                // Store user role and StaffID in the session
                HttpSession session = request.getSession();
                session.setAttribute("userRole", userRole);
                session.setAttribute("StaffID", staffID);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return userExists;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}