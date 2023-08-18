<!DOCTYPE html>
<html>
<head>
    <title>Edit Item</title>
</head>
<body>
    <h1>Edit Item</h1>
    <form action="update-item" method="post">
        <!-- Display fields for editing the item's details -->
        Category: <input type="text" name="category" value="${item.category}">
        Name: <input type="text" name="itemName" value="${item.itemName}">
        Price: <input type="text" name="price" value="${item.price}">
        <input type="hidden" name="itemId" value="${item.itemId}">
        <input type="submit" value="Save Changes">
    </form>
</body>
</html>
