package Attend.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendanceModel {
    public static boolean updateAttendance(String id, String date, String clockin, String clockout, String thour) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB_Connect.getConnection();
            String updateSQL = "UPDATE attendance SET ClockIn = ?, ClockOut = ?, TotalHours = ?, Date = ? WHERE StaffID = ? AND Date = ?";
            preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, clockin);
            preparedStatement.setString(2, clockout);
            preparedStatement.setString(3, thour);
            preparedStatement.setString(4, date);
            preparedStatement.setString(5, id);
            preparedStatement.setString(6, date);
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors (e.g., log the error)
            return false;
        } finally {
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