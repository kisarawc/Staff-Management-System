<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String staffID = (String) session.getAttribute("StaffID");
    if (session.getAttribute("userRole") == null && staffID == null) {
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
    <meta charset="UTF-8">
    <title>Update Staff Information</title>
    <link rel="stylesheet" type="text/css" href="CSS/updateStaff.css">
    
    <script type="text/javascript">
        function validateForm() {
            var number = document.getElementById("number").value;
            var email = document.getElementById("email").value;
            var dob = document.getElementById("dob").value;
            

            // Check if the number is exactly 10 digits
            if (!/^\d{10}$/.test(number)) {
                alert("Contact Number must be 10 digits.");
                return false;
            }

         // Check if the email has a valid format
            if (!/^[\w\.-]+@[\w\.-]+\.\w+$/.test(email)) {
                alert("Please enter a valid email address.");
                return false;
            }

         // Check tht date
            var dobDate = new Date(dob.replace(/-/g, "/"));
            var todayDate = new Date();
            var age = todayDate.getFullYear() - dobDate.getFullYear();
            var m = todayDate.getMonth() - dobDate.getMonth();
            if (m < 0 || (m === 0 && todayDate.getDate() < dobDate.getDate())) {
                age--;
            }

            // Check if age is less than 18
            if (age < 18) {
                alert("You must be at least 18 years old.");
                return false;
            }

            // Form is valid; continue with submission
            return true;
        }
    </script>
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

    <form action="staffUpdate" method="post" class="form-container">
        <div class="form-header">
            <h2>Update Staff Information</h2>
        </div>
        <div class="form-field">
            Staff ID <input type="text" name="staffID" value="<%= staffid %>" readonly>
        </div>
        <div class="form-field">
            First Name <input type="text" name="fname" value="<%= fname %>" required>
        </div>
        <div class="form-field">
            Last Name <input type="text" name="lname" value="<%= lname %>"required>
        </div>
        <div class="form-field">
            Contact Number <input type="text" id="number" name="number" value="<%= number %>">
        </div>
        <div class="form-field">
            Address <input type="text" name="address" value="<%= address %>"required>
        </div>
        <div class="form-field">
            Email <input type="text" id="email" name="email" value="<%= email %>">
        </div>
        <div class="form-field">
            Date Of Birth <input type="text" id="dob" name="dob" value="<%= dob %>"required>
        </div>
        <div class="form-submit">
            <input type="submit" name="submit" class="form-button" value="Update My Data" onclick="return validateForm()">
        </div>
    </form>
</body>
</html>
