<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>
    <h1>Create User</h1>
    <form action="UserServlet" method="post">
        <label for="email">Email:</label>
        <input type="email" name="email" required><br>

        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" required><br>

        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" required><br>

        <label for="password">Password:</label>
        <input type="password" name="password" required><br>

        <label for="active">Active:</label>
        <input type="checkbox" name="active" value="true"><br>

        <!-- Additional fields and labels can be added here -->

        <input type="submit" value="Create User">
    </form>
</body>
</html>
