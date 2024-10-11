package Attend.Report;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateAttendanceServlet")
public class UpdateAttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        String clockin = request.getParameter("clockin");
        String clockout = request.getParameter("clockout");
        String thour = request.getParameter("thour");
        
        boolean success = AttendanceModel.updateAttendance(id, date, clockin, clockout, thour );

        if (success) {
            response.sendRedirect("Success_Insert_Atend.jsp");
        } else {
            // Handle errors, you can redirect to an error page or show a message.
            response.sendRedirect("ErrorPage.jsp");
        }
    }
}