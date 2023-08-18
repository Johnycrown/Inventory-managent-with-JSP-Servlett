<%@ page import="models.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
</head>
<body>
    <h1>Main Page</h1>

    <% // Check if user is logged in
       User user = (User) session.getAttribute("user");
       if (user != null) { %>
        <p>Welcome, <%= user.getFirstName() %> <%= user.getLastName() %>!</p>
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Logout">
        </form>
    <% } else { %>
        <p>Please <a href="http://localhost:8080/mavenproject3/login">login</a> to access this page.</p>
        <p>Please <a href="http://localhost:8080/mavenproject3/users">SignUp </a> here if you a new user</p>
    <% } %>
</body>
</html>
