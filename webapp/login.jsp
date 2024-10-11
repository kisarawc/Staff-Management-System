<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <script src="JS/LoginErrorPopup.js" type="text/javascript"></script>
    <link href="CSS/login.css" rel="stylesheet" type="text/css">
    <title>Login</title>
        <% String alertMessage = (String) request.getAttribute("alertMessage"); %>
<% if (alertMessage != null) { %>
    <script>
        alert("<%= alertMessage %>");
    </script>
<% } %>
   
</head>
<body>
    <div class="error">
        <% String errorMessage = (String) request.getAttribute("errorMessage");
           if (errorMessage != null) { out.print(errorMessage); }
        %>
    </div>
    <form action="LoginServlet" method="post">
        UserName: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>