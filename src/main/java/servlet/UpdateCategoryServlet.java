package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Category;
import service.CategoryService;

import java.io.IOException;

@WebServlet("/update-category")
public class UpdateCategoryServlet extends HttpServlet {


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            String categoryName = request.getParameter("categoryName");

            // Update the category's information in the database
            CategoryService categoryService = new CategoryService();

            categoryService.updateCategory(new Category(categoryId,categoryName));

            // Redirect back to the category management page
            response.sendRedirect("WEB-INF/category-management");
        }


}
