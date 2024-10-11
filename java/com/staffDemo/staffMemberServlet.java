package com.staffDemo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/staffMemberServlet")
public class staffMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String staffID = (String) session.getAttribute("StaffID");
			
		try {
		
		List<staffMember> sta = staffDBUtil.retrieveStaffDetails(staffID);
		
		request.setAttribute("staffDe", sta);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("staffDetails.jsp");
		dis.forward(request, response);
		
	}

}
