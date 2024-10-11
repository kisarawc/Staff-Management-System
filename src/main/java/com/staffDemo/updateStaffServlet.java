package com.staffDemo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staffDemo.staffDBUtil.StaffDBUtil;

@WebServlet("/updateStaffServlet")
public class updateStaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffid = request.getParameter("staffID");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");

        boolean isSuccessful = StaffDBUtil.updateStaff(staffid, fname, lname, number, address, email, dob);

        if (isSuccessful) {
        	
            String alertMessage = "Update Successful!";
            request.setAttribute("alertMessage", alertMessage);
            
        	List<staffMember> staffDetail = staffDBUtil.getStaffMembersDetails(staffid);
        	request.setAttribute("staffDe", staffDetail);
        	
        	RequestDispatcher dis = request.getRequestDispatcher("staffDetails.jsp");
    		dis.forward(request, response);
        } else {
        	
            String alertMessage = "Update Unsuccessful!";
            request.setAttribute("alertMessage", alertMessage);
            
        	List<staffMember> staffDetail = staffDBUtil.getStaffMembersDetails(staffid);
        	request.setAttribute("staffDe", staffDetail);
        	
        	RequestDispatcher dis = request.getRequestDispatcher("staffDetails.jsp");
    		dis.forward(request, response);
            
        }
    }
}
