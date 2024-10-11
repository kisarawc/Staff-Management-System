package com.staffDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StaffLeaveDbUtil {

	private static Connection con = null;
	@SuppressWarnings("unused")
	private static Statement stmt = null;
	@SuppressWarnings("unused")
	private static ResultSet rs = null;
  
	
	public static boolean insertLeave(String staffID,String fromDate, String toDate, String reason, String status ,String id, String appliedDate) {
		
		boolean isSuccess = false;
		PreparedStatement preparedStatement = null;
		try {

			con = DBConnectC.getConnection();
			String sql = "INSERT INTO leaves (StaffID, FromDate, ToDate, Reason, Status, ApplyDate) VALUES (?, ?, ?, ?, ?, ?)";
	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, staffID);
	        preparedStatement.setString(2, fromDate);
	        preparedStatement.setString(3, toDate);
	        preparedStatement.setString(4, reason);
	        preparedStatement.setString(5, status);
	        preparedStatement.setString(6, appliedDate);

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            isSuccess = true;
	        } else {
	            isSuccess = false;
	        }
	       
		}catch(Exception e){
			e.printStackTrace();	
		}
		return isSuccess;
	}

}
