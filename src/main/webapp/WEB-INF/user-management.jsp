<!DOCTYPE html>
<html>
<head>
    <title>User Management</title>
</head>
<body>
    <h1>User Management</h1>
    <table border="1">
        <tr>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>
                    <a href="edit-user?email=${user.email}">Edit</a>
                    <a href="delete-user?email=${user.email}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="admin-add-user">Add new user</a>
</body>
</html>
