package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Category;
import service.CategoryService;

import java.io.IOException;

@WebServlet("/edit-category")
public class EditCategoryServlet extends HttpServlet {


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int categoryId = Integer.parseInt(request.getParameter("id"));

            // Fetch the category from the database based on categoryId
            CategoryService categoryService = new CategoryService();
            Category category = categoryService.getCategoryById(categoryId);

            // Forward to the JSP page for editing category
            request.setAttribute("category", category);
            request.getRequestDispatcher("WEB-INF/edit-category.jsp").forward(request, response);
        }


}
