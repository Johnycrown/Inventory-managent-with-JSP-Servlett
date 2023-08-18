package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Item;
import service.ItemService;

import java.io.IOException;

@WebServlet("/edit-item")
public class EditItemServlet extends HttpServlet {



        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int itemId = Integer.parseInt(request.getParameter("id"));

            // Fetch the item from the database based on itemId
            ItemService itemService = new ItemService();
            Item item = itemService.findItem(itemId);
            // Store the item in a request attribute
            request.setAttribute("item", item);

            // Forward to the JSP page for editing item
            request.getRequestDispatcher("/edit-item.jsp").forward(request, response);
        }


}
