<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>
    <form action="update-user" method="post">
        Email: <input type="email" name="email" value="${user.email}" readonly><br>
        First Name: <input type="text" name="firstName" value="${user.firstName}"><br>
        Last Name: <input type="text" name="lastName" value="${user.lastName}"><br>
        <input type="submit" value="Save Changes">
    </form>
</body>
</html>
