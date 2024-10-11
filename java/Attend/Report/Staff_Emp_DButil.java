package Attend.Report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Staff_Emp_DButil{

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess;
	
	public static boolean insertAttend( String id, String date, String itime, String otime, String ttime) {
		
		
		boolean isSuccess = false;
		
		try {

			con = DB_Connect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into Attendance(StaffID,Date,ClockIn,ClockOut,TotalHours) values('" + id + "', '" + date + "', '" + itime + "', '" + otime + "', '" + ttime + "')";

			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true ;
			} else {
				isSuccess = false;
			}
			
		}catch(Exception e){
			e.printStackTrace();	
		}
		return isSuccess;
	}
	
	//deleteEvent
		public static boolean Delete_Attend(String aid) {
			
			int convID = Integer.parseInt(aid);
			
			try {
				con = DB_Connect.getConnection();
				stmt = con.createStatement();
				String sql = "DELETE FROM attendance where AttendanceID = '"+convID+"'";
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					isSuccess =true;
				}
				else {
					isSuccess = false;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}

}