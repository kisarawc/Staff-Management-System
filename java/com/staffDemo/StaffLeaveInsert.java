package com.staffDemo;




import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StaffLeaveInsert")
public class StaffLeaveInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffID = request.getParameter("staffID");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		String reason = request.getParameter("reason");
		String status = request.getParameter("status");
		String id = request.getParameter("id");
		String appliedDate = request.getParameter("appliedDate");
		
		 
		Boolean isTrue;
		
		isTrue = StaffLeaveDbUtil.insertLeave(staffID,fromDate, toDate, reason, status,id, appliedDate);
		
		if(isTrue == true) {
			 String alertMessage = "Request send Successfully!";
	         request.setAttribute("alertMessage", alertMessage);
	            
			RequestDispatcher dis = request.getRequestDispatcher("staffLog.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unSuccessInsertLeave.jsp");
			dis2.forward(request, response);
		}
	
	}

}
