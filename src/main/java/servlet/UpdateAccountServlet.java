package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import service.UserService;

import java.io.IOException;

@WebServlet("/update-account")
public class UpdateAccountServlet extends HttpServlet {



        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            UserService userService = new UserService();
            User user = new User();
           user.setFirstName(firstName);
           user.setLastName(lastName);

            // Update the user's account information in the database
            userService.updateUser(user);


            // Redirect back to the account page with a success message
            response.sendRedirect("account");
        }


}
