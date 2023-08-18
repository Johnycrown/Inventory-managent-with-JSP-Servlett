package servlet;

import dataaccess.CategoryDb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Item;
import service.ItemService;
import service.UserService;

import java.io.IOException;

@WebServlet("/update-item")
public class UpdateItemServlet extends HttpServlet {


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int itemId = Integer.parseInt(request.getParameter("itemId"));
            String category = request.getParameter("category");
            String itemName = request.getParameter("itemName");
            double price = Double.parseDouble(request.getParameter("price"));
            HttpSession session = request.getSession();
            String email1 = (String) session.getAttribute("email");
            ItemService itemService = new ItemService();
            // Update the item's details in the database based on itemId
            Item item = new Item();
            item.setItemId(itemId);
            item.setPrice(price);
            item.setItemName(itemName);
            item.setCategory(new CategoryDb().findCategoryByName(category));
            item.setOwner(new UserService().findUserByEmail(email1));
            itemService.updateItem(item);

            // Redirect back to the view inventory page
            response.sendRedirect("WEB-INF/view-inventory");

        }


}
