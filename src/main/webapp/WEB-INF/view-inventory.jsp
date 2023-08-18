
<!DOCTYPE html>
<html>
<head>
    <title>View Inventory</title>
</head>
<body>
    <h1>Inventory Items</h1>
    <table border="1">
        <tr>
            <th>Category</th>
            <th>Name</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${inventoryItems}" var="item">
            <tr>
                <td>${item.category}</td>
                <td>${item.itemName}</td>
                <td>${item.price}</td>
                <td>
                    <a href="edit-item?id=${item.itemId}">Edit</a>
                    <a href="delete-item?id=${item.itemId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
