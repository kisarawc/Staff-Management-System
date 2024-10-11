package com.staffDemo;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/deleteStaffServlet")
public class deleteStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffid = request.getParameter("staffID");
        boolean isTrue;
       isTrue = staffDBUtil.deleteStaff(staffid);

        if (isTrue) {
        	String alertMessage = "Account Deleted Successfully!";
            request.setAttribute("alertMessage", alertMessage);
            
        	RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
    		dis.forward(request, response);
    		
        } else {
        	
        	
        	RequestDispatcher dis = request.getRequestDispatcher("unSuccessInsertLeave.jsp");
    		dis.forward(request, response);
	}

}
}