package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ItemService;

import java.io.IOException;

@WebServlet("/delete-item")
public class DeleteItemServlet extends HttpServlet {



        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int itemId = Integer.parseInt(request.getParameter("id"));

            // Delete the item from the database based on itemId
            ItemService itemService = new ItemService();
            itemService.deleteItem(itemId);

            // Redirect back to the view inventory page
            response.sendRedirect("view-inventory");
        }


}
