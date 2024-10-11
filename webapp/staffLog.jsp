<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String staffID = (String) session.getAttribute("StaffID");
    if (session.getAttribute("userRole") == null && session.getAttribute("StaffID") == null) {
        response.sendRedirect("login.jsp");
    }
    // Prevent caching by setting response headers
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Staff Dashboard</title>
    <link rel="stylesheet" type="text/css" href="CSS/staffLog.css">
    <% String alertMessage = (String) request.getAttribute("alertMessage"); %>
<% if (alertMessage != null) { %>
    <script>
        alert("<%= alertMessage %>");
    </script>
<% } %>
   
</head>
<body>
<div class="dashboard-container">
    <h1>Welcome to the Staff Dashboard</h1>
    <p>Please select an option below:</p>

    <div class="button-container">
        <form action="staffMemberServlet" method="post">
            <input type="hidden" name="page" value="details">
            <button type="submit">My Details</button>
        </form>

        <form action="StaffLeaveInsert.jsp" method="post">
            <input type="hidden" name="page" value="requestLeave">
            <button type="submit">Request a Leave</button>
        </form>

        <form action="Dis_Table" method="post">
            <input type="hidden" name="page" value="attendance">
            <button type="submit">View Attendance</button>
        </form>

        <form action="SubmitForm.jsp" method="post">
            <input type="hidden" name="page" value="payroll">
            <button type="submit">Add Attendance</button>
        </form>

        <form action="staffMemberServlet" method="post">
            <input type="hidden" name="page" value="changePassword">
            <button type="submit">Change Password</button>
        </form>

        <form action="LogoutServlet" method="post">
            <input type="hidden" name="page" value="logout">
            <button type="submit" name="logout">Logout</button>
        </form>
    </div>
</div>
</body>
</html>
