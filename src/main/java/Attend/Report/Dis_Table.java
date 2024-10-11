package Attend.Report;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Dis_Table")
public class Dis_Table extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String staffID = (String) session.getAttribute("StaffID");
		
		 System.out.println("Received staffID from JSP: " + staffID);
	try {
		
		List<staffMember> sta = Table_DButil.retrieve_Staff_Attend_Details(staffID);
		
		request.setAttribute("staffDe", sta);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("Attendance_Table.jsp");
		dis.forward(request, response);
		
	}

}