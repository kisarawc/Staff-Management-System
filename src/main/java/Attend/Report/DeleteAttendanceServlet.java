package Attend.Report;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteAttendanceServlet")
public class DeleteAttendanceServlet extends HttpServlet {
   
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the URL
        String attendanceId = request.getParameter("aid");
        String staffId = request.getParameter("id");

        // Database connection and SQL delete
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB_Connect.getConnection(); // Assuming you have a DB_Connect class
            String deleteSQL = "DELETE FROM attendance WHERE AttendanceID = ? AND StaffID = ?";
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, attendanceId);
            preparedStatement.setString(2, staffId);
            
            int rowsDeleted = preparedStatement.executeUpdate();
            
            if (rowsDeleted > 0) {
                // Deletion was successful, redirect to the success page
                response.sendRedirect("Success_Insert_Atend.jsp"); // Replace with the actual URL of your success page
            } else {
                // Deletion was not successful, redirect to an error page
                response.sendRedirect("ErrorPage.jsp"); // Replace with the actual URL of your error page
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
            // You can also redirect to an error page in case of a database error
            response.sendRedirect("Error_Page.jsp"); // Replace with the actual URL of your error page
        } finally {
            // Close the resources (connection, statement, etc.)
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}