<!DOCTYPE html>
<html>
<head>
    <title>Account Information</title>
</head>
<body>
    <h1>Account Information</h1>
    <form action="update-account" method="post">
        Email: <input type="email" name="email" value="${user.email}" readonly><br>
        First Name: <input type="text" name="firstName" value="${user.firstName}"><br>
        Last Name: <input type="text" name="lastName" value="${user.lastName}"><br>
        <input type="submit" value="Save Changes">
    </form>
</body>
</html>
