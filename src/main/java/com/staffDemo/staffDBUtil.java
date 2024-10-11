package com.staffDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class staffDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	@SuppressWarnings("unused")
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static List<staffMember> retrieveStaffDetails(String staffID) {
	    ArrayList<staffMember> sta = new ArrayList<staffMember>();
	    try {
	        con = DBConnectC.getConnection();

	        String sql = "SELECT StaffID, FirstName, LastName, ContactNumber, Position, Address, RegisteredDate, Email, DOB FROM staffdetails WHERE StaffID = ?";
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, staffID); 
	        rs = preparedStatement.executeQuery(); 

	        if (rs.next()) {
	            String staffID1 = rs.getString(1);
	            String fname = rs.getString(2);
	            String lname = rs.getString(3);
	            String number = rs.getString(4);
	            String position = rs.getString(5);
	            String address = rs.getString(6);
	            String regDate = rs.getString(7);
	            String email = rs.getString(8);
	            String dob = rs.getString(9);

	            staffMember c = new staffMember(staffID1, fname, lname, number, position, address, regDate, email, dob);
	            sta.add(c);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return sta;
	}
	
	public class StaffDBUtil {
	    public static boolean updateStaff(String staffid, String fname, String lname, String number, String address, String email, String dob) {
	        Connection con = null;
	        PreparedStatement stmt = null;

	        try {
	            con = DBConnectC.getConnection();
	            String sql = "UPDATE staffdetails SET FirstName=?, LastName=?, ContactNumber=?, Address=?, Email=?, DOB=? WHERE StaffID=?";
	            stmt = con.prepareStatement(sql);

	            stmt.setString(1, fname);
	            stmt.setString(2, lname);
	            stmt.setString(3, number);
	            stmt.setString(4, address);
	            stmt.setString(5, email);
	            stmt.setString(6, dob);
	            stmt.setString(7, staffid);

	            int rowsUpdated = stmt.executeUpdate();

	            return rowsUpdated > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	public static List<staffMember> getStaffMembersDetails(String staffID){
		  ArrayList<staffMember> sta = new ArrayList<staffMember>();
		  
		  	try {
		  		con = DBConnectC.getConnection();
		  	    stmt = con.createStatement();
		  	    
		  	    String sql= "SELECT StaffID, FirstName, LastName, ContactNumber, Position, Address, RegisteredDate, Email, DOB FROM staffdetails WHERE StaffID = ?";
		  	    PreparedStatement preparedStatement = con.prepareStatement(sql);
		        preparedStatement.setString(1, staffID); 
		        rs = preparedStatement.executeQuery(); 
		        if (rs.next()) {
		            String staffID1 = rs.getString(1);
		            String fname = rs.getString(2);
		            String lname = rs.getString(3);
		            String number = rs.getString(4);
		            String position = rs.getString(5);
		            String address = rs.getString(6);
		            String regDate = rs.getString(7);
		            String email = rs.getString(8);
		            String dob = rs.getString(9);

		            staffMember c = new staffMember(staffID1, fname, lname, number, position, address, regDate, email, dob);
		            sta.add(c);
		        }
		  	}catch(Exception e) {
		  		e.printStackTrace();
		  	}
		  
		  return sta;
	
	}
	
	public static boolean deleteStaff(String staffID) {
		PreparedStatement stmt = null;
		try {

			   con = DBConnectC.getConnection();
		        if (con != null) {
		        	 
		            String sql1 = "DELETE FROM staffdetails WHERE StaffID = ?";
		            stmt = con.prepareStatement(sql1);
		            stmt.setString(1, staffID);
		            int rowsAffected1 = stmt.executeUpdate();
		            stmt.close(); 

		        if (rowsAffected1 > 0) {
		            isSuccess = true;
		            con.commit();
		        } else {
		            isSuccess = false;
		        }
		    }
	       
		}catch(Exception e){
			e.printStackTrace();	
		}
		return isSuccess;
	}
	
}



