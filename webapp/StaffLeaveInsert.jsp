<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <meta charset="UTF-8">
    <title>Leave Request Form</title>
    <link rel="stylesheet" type="text/css" href="CSS/staffLeave.css">
</head>
<body>

<jsp:include page="staffDashbord.jsp" />

<div class="container">
    <div class="form-container">
        <h1>Leave Request Form</h1>
        <form action="leaveInsert" method="post" onsubmit="return validateForm()">
            <label for="fromDate">From Date:</label>
            <input type="date" id="fromDate" name="fromDate" required>

            <label for="toDate">To Date:</label>
            <input type="date" id="toDate" name="toDate" required>

            <label for="reason">Reason:</label>
            <textarea id="reason" name="reason" rows="4" required></textarea>

            <input type="hidden" name="status" value="Pending">
            <input type="hidden" name="staffID" value="<%= staffID %>">

            <%
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String currentDate = sdf.format(new java.util.Date());
            %>
            <input type="hidden" name="appliedDate" value="<%= currentDate %>">
            <input type="submit" value="Submit">
        </form>
    </div>
</div>

<script type="text/javascript">
    function validateForm() {
        var fromDate = document.getElementById("fromDate").value;
        var toDate = document.getElementById("toDate").value;
        var reason = document.getElementById("reason").value;

        // Check if the fromDate is a past date
        var currentDate = new Date();
        var selectedFromDate = new Date(fromDate);
        if (selectedFromDate < currentDate) {
            alert("From Date cannot be a past date.");
            return false;
        }

        // Check if the toDate is a past date compared to the fromDate
        var selectedToDate = new Date(toDate);
        if (selectedToDate < selectedFromDate) {
            alert("To Date cannot be earlier than From Date.");
            return false;
        }

        // Check if the reason is empty
        if (reason.trim() === "") {
            alert("Please provide a reason for your leave request.");
            return false;
        }

        // Form is valid; continue with submission
        return true;
    }
</script>


</body>
</html>
