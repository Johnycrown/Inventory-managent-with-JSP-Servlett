<!DOCTYPE html>
<html>
<head>
    <title>Category Management</title>
</head>
<body>
    <h1>Category Management</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${categoryList}" var="category">
            <tr>
                <td>${category.categoryId}</td>
                <td>${category.categoryName}</td>
                <td>
                    <a href="edit-category?id=${category.categoryId}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
