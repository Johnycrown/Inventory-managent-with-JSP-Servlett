package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Item;
import models.User;
import service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/view-inventory")
public class ViewInventoryServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the logged-in user from the session


        UserService userService = new UserService();

        try {
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            // Fetch the user's inventory items from the database
            List<Item> inventoryItems = userService.getAllItems(email);
            System.out.println("the result of the list for the user " + inventoryItems);



            // Store the inventory items in a request attribute
            request.setAttribute("inventoryItems", inventoryItems);

            // Forward to the JSP page for displaying inventory
            request.getRequestDispatcher("WEB-INF/view-inventory.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
