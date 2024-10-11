package Attend.Report;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Staff_Insert")
public class Staff_Insert extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

 
    public Staff_Insert() {
        super();
      
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String date = request.getParameter("date");
		String itime = request.getParameter("itime");
		String otime = request.getParameter("otime");
		String ttime = request.getParameter("ttime");
		 
		Boolean isTrue;
		

		isTrue = Staff_Emp_DButil.insertAttend(id, date, itime, otime, ttime);
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("Success_Insert_Atend.jsp");
			dis.forward(request, response);
			
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess_Insert_Atend.jsp");
			dis2.forward(request, response);
			
		}
	
	}

}