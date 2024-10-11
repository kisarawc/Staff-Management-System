<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String staffID = (String) session.getAttribute("StaffID");
    if (session.getAttribute("userRole") == null && staffID == null) {
        response.sendRedirect("login.jsp");
    }
    // Prevent caching 
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attendance Submit Form</title>
<link rel="stylesheet" href="CSS/Insert_Form.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	
	<div class="H">
	
	<h1> Attendance Form </h1> </div>

<form action ="Staff_Insert" method = "post" class="inp" onsubmit="return validateForm()">
			<input type="hidden" name="id" value="<%= staffID %>">
			Date <input type = "Date"  id="date" name = "date"><span id="dateError" style="color: red;"></span><br><br>
			Clock IN <input type = "Time" name ="itime"><br><br>
			Clock OUT <input type ="Time" name = "otime"><br><br>
			Total Hours <input type ="text" name = "ttime"><br>
			<input type="submit" name = "submit" value = "Submit">
		</form>



<script>
function validateForm() {
    var inputDate = document.getElementById("date").value;
    var currentDate = new Date();
    var selectedDate = new Date(inputDate);

    if (selectedDate > currentDate) {
        document.getElementById("dateError").innerText = "Date cannot be in the future!";
        return false; // Prevent form submission
    } else {
        document.getElementById("dateError").innerText = "";
        return true; // Allow form submission
    }
}
</script>

</body>
</html>