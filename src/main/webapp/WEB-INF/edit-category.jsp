<!DOCTYPE html>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
    <h1>Edit Category</h1>
    <form action="update-category" method="post">
        ID: <input type="text" name="categoryId" value="${category.categoryId}" readonly><br>
        Name: <input type="text" name="categoryName" value="${category.categoryName}"><br>
        <input type="submit" value="Save Changes">
    </form>
</body>
</html>
