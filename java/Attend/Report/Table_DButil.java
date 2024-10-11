package Attend.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Table_DButil {
    private static Connection con = null;

    public static List<staffMember> retrieve_Staff_Attend_Details(String staffID) {
        List<staffMember> sta = new ArrayList<staffMember>();
      
        try {
            con = DB_Connect.getConnection();

            String sql = "SELECT AttendanceID, StaffID, Date, ClockIn, ClockOut, TotalHours FROM attendance WHERE StaffID = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, staffID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	String AID = rs.getString("AttendanceID");
                String ID = rs.getString("StaffID");
                String date = rs.getString("Date");
                String clockin = rs.getString("ClockIn");
                String clockout = rs.getString("ClockOut");
                String Thour = rs.getString("TotalHours");

           

                staffMember c = new staffMember(AID ,ID, date, clockin, clockout, Thour);
                sta.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sta;
    }

}