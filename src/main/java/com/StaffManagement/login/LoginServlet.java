package com.StaffManagement.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Authenticate user using the Model
        boolean userAuthenticated = LoginModel.authenticateUser(username, password, request);

        if (userAuthenticated) {
            HttpSession session = request.getSession();
            String userRole = (String) session.getAttribute("userRole");
            @SuppressWarnings("unused")
			String staffID = (String) session.getAttribute("StaffID");
            
            if (userRole != null) {
                // Redirect to the appropriate view based on the user role
                response.sendRedirect(getRedirectPage(userRole));
            } else {
                request.setAttribute("errorMessage", "Role not found");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private String getRedirectPage(String userRole) {
        switch (userRole) {
            case "Admin":
                return "admin.jsp";
            case "PayrollManager":
                return "payroll_manager.jsp";
            case "AttendanceManager":
                return "attendance_manager.jsp";
            case "Employee":
                return "staffLog.jsp";
            default:
                return "login.jsp"; // Redirect to the login page in case of an unknown user role
        }
    }
}