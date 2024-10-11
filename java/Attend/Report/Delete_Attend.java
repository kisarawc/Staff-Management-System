package Attend.Report;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete_Attend")
public class Delete_Attend extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String AttendenceID = request.getParameter("aid");
		
		boolean isTrue ;
		
		isTrue = Staff_Emp_DButil.Delete_Attend(AttendenceID);
		
		if(isTrue == true) 
		{
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("Success_Insert_Atend.jsp");
			dispatcher1.forward(request, response);
		}
		else 
		{	
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("Unsuccess_Insert_Atend.jsp");
			dispatcher2.forward(request, response);
		}
		
	}

}