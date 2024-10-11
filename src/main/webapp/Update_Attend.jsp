<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Attendance</title>
    <link rel="stylesheet" href="CSS/Insert_Form.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<%
    String id = request.getParameter("id");
    String date = request.getParameter("date");
    String clockin = request.getParameter("clockin");
    String clockout = request.getParameter("clockout");
    String thour = request.getParameter("thour");
%>

<div class="H"><h1>Update Attendance Form</h1></div>


	
		<form action="UpdateAttendanceServlet" method="post">
		    <!-- Pass staff ID as a hidden input to the servlet -->
		    <input type="hidden" name="id" value="<%= id %>">
		    Date: <input type="date" name="date" value="<%= date %>" readonly><br><br>
		    Clock IN: <input type="time" name="clockin" value="<%= clockin %>"><br><br>
		    Clock OUT: <input type="time" name="clockout" value="<%= clockout %>"><br><br>
		    Total Hours: <input type="text" name="thour" value="<%= thour %>"><br>
		    <input type="submit" name="submit" value="Update">
		</form>
	

</body>
</html>