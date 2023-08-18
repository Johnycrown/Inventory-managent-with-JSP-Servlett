package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Category;
import service.CategoryService;
import java.io.IOException;
import java.util.List;

@WebServlet("/category-management")
public class CategoryManagementServlet extends HttpServlet {




        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Fetch the list of all categories from the database
            CategoryService category = new CategoryService();
            List<Category> categoryList = category.getAllCategory();
            // Forward to the JSP page for displaying categories
            request.setAttribute("categoryList", categoryList);
            request.getRequestDispatcher("WEB-INF/category-management.jsp").forward(request, response);
        }


}
