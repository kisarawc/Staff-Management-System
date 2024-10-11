<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   
    <meta charset="UTF-8">
    <title>Delete Staff Information</title>
    <link rel="stylesheet" type="text/css" href="CSS/deleteStaff.css">
</head>

</head>
<body>
	<jsp:include page="staffDashbord.jsp" />
    <%
   		String staffid = request.getParameter("staffid");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
    %>

    <form action="staffDelete" method="post" class="form-container">
    <div class="form-header">
        <h2>Account Delete</h2>
    </div>
    <div class="form-field">
       Staff ID <input type="text" name="staffID" value="<%= staffid %>" readonly>
   
   
        First Name <input type="text" name="fname" value="<%= fname %>" readonly>
    
        Last Name <input type="text" name="lname" value="<%= lname %>" readonly>

        Contact Number <input type="text" name="number" value="<%= number %>" readonly>
    
        Address <input type="text" name="address" value="<%= address %>" readonly>
   
        Email <input type="text" name="email" value="<%= email %>" readonly>
   
        Date Of Birth <input type="text" name="dob" value="<%= dob %>" readonly>
    </div>
    <div class="form-submit">
        <input type="submit" name="submit" class="form-button" value="Delete My Account">
    </div>
</form>

</body>
</html>