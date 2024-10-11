<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <meta charset="UTF-8">
    <title>Your Dashboard</title>
    <link rel="stylesheet" type="text/css" href="CSS/staffDetails.css">
    <% String alertMessage = (String) request.getAttribute("alertMessage"); %>
<% if (alertMessage != null) { %>
    <script>
        alert("<%= alertMessage %>");
    </script>
<% } %>
    
</head>
<body>
   
   <jsp:include page="staffDashbord.jsp" />
   
   <div class="dashboard-container">
        <c:forEach var="staff" items="${staffDe}">
        	<c:set var="staffid" value="${staff.staffId}"/>
            <c:set var="fname" value="${staff.fname}"/>
            <c:set var="lname" value="${staff.lname}"/>
            <c:set var="number" value="${staff.number}"/>
            <c:set var="address" value="${staff.address}"/>
            <c:set var="email" value="${staff.email}"/>
            <c:set var="dob" value="${staff.dob}"/>
            
            <div class="staff-info">
                <h2>Staff Information</h2>
                <p><strong>Staff ID:</strong> ${staff.staffId}</p>
                <p><strong>First Name:</strong> ${staff.fname}</p>
                <p><strong>Last Name:</strong> ${staff.lname}</p>
                <p><strong>Phone Number:</strong> ${staff.number}</p>
                <p><strong>Position:</strong> ${staff.position}</p>
                <p><strong>Address:</strong> ${staff.address}</p>
                <p><strong>Registration Date:</strong> ${staff.regDate}</p>
                <p><strong>Email:</strong> ${staff.email}</p>
                <p><strong>Date of Birth:</strong> ${staff.dob}</p>
            </div>
        </c:forEach>

        <c:url value="updateStaff.jsp" var="staffUpdate">
        	<c:param name="staffid" value="${staffid}"/>
            <c:param name="fname" value="${fname}"/>
            <c:param name="lname" value="${lname}"/>
            <c:param name="number" value="${number}"/>
            <c:param name="address" value="${address}"/>
            <c:param name="email" value="${email}"/>
            <c:param name="dob" value="${dob}"/>
        </c:url>

    <a href="${staffUpdate}">
   		 <input type="button" name="update" class="button-style" value="Update My Data">
	</a>
	
	<c:url value="deleteStaff.jsp" var="staffDelete">
        	<c:param name="staffid" value="${staffid}"/>
            <c:param name="fname" value="${fname}"/>
            <c:param name="lname" value="${lname}"/>
            <c:param name="number" value="${number}"/>
            <c:param name="address" value="${address}"/>
            <c:param name="email" value="${email}"/>
            <c:param name="dob" value="${dob}"/>
        </c:url>
	<a href="${staffDelete}">
   		 <input type="button" name="delete" class="button-style" value="Delete My Account">
	</a>

    </div>
</body>
</html>
