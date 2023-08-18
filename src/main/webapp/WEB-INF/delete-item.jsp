<!DOCTYPE html>
<html>
<head>
    <title>Delete Item</title>
</head>
<body>
    <h1>Delete Item</h1>
    <p>Are you sure you want to delete the following item?</p>
    <p><strong>Category:</strong> ${item.category}</p>
    <p><strong>Name:</strong> ${item.itemName}</p>
    <p><strong>Price:</strong> ${item.price}</p>

    <form action="delete-item" method="post">
        <input type="hidden" name="itemId" value="${item.itemId}">
        <input type="submit" value="Delete">
    </form>

    <a href="view-inventory">Cancel</a>
</body>
</html>
