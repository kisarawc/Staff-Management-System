package Attend.Report;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connect {

	private static String url = "jdbc:mysql://localhost:3306/staffmanagementsystem";
	private static String user = "root";
	private static String pass = "chathu123";
	private static Connection con;
	


	public static Connection getConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");	
			con = DriverManager.getConnection(url, user, pass);
			
		}catch(Exception e) {
			System.out.println("Database connection not success!!");
		}
		
		return con;
	}

	
}