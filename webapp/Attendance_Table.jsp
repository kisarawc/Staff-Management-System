<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Attendance</title>
    <link rel="stylesheet" href="CSS/Table.css">
    <link rel="stylesheet" href="CSS/edit.css">
    <script>
        function confirmDelete(aid, id) {
            var r = confirm("Are you sure you want to delete this record?");
            if (r == true) {
                window.location.href = 'DeleteAttendanceServlet?aid=' + aid + '&id=' + id;
            }
        }
    </script>
</head>
<body>
<jsp:include page="staffDashbord.jsp" />
    <div class="TB" >
        <center>
            <h1>Attendance History</h1>
            <table>
                <thead>
                    <tr>
                        <th>Attendance ID</th>
                        <th>Staff ID</th>
                        <th>Date</th>
                        <th>Clock In</th>
                        <th>Clock Out</th>
                        <th>Total Hours</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="staff" items="${staffDe}">
                        <c:set var="aid" value="${staff.AID}"/>
                        <c:set var="id" value="${staff.ID}"/>
                        <c:set var="date" value="${staff.date}"/>
                        <c:set var="clockin" value="${staff.clockin}"/>
                        <c:set var="clockout" value="${staff.clockout}"/>
                        <c:set var="thour" value="${staff.thour}"/>
                        <tr>
                            <td>${staff.AID}</td>
                            <td>${staff.ID}</td>
                            <td>${staff.date}</td>
                            <td>${staff.clockin}</td>
                            <td>${staff.clockout}</td>
                            <td>${staff.thour}</td>
                            
                            <td>
                                <c:url value="Update_Attend.jsp" var="updateLink">
                                    <c:param name="aid" value="${staff.AID}" />
                                    <c:param name="id" value="${staff.ID}" />
                                    <c:param name="date" value="${staff.date}" />
                                    <c:param name="clockin" value="${staff.clockin}" />
                                    <c:param name="clockout" value="${staff.clockout}" />
                                    <c:param name="thour" value="${staff.thour}" />
                                </c:url>
                               <center> <a href="${updateLink}" class="link-style"><span>Edit</span></a></center>
                            </td>
                            <td>
                                <center><a href="javascript:void(0);" onclick="confirmDelete('${staff.AID}', '${staff.ID}')" class="link"><span>Delete</span></a></center>
                            </td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </center>
    </div>
</body>
</html>