package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;
import service.UserService;

import java.io.IOException;

@WebServlet("/update-user")
public class UpdateUserServlet extends HttpServlet {



        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            HttpSession session = request.getSession();
            String email1 = (String) session.getAttribute("email");
            // Update the user's account information in the database
            User user = new User();
            user.setLastName(lastName);
            user.setFirstName(firstName);
            user.setEmail(email);
            UserService userService = new UserService();
            userService.updateUser(user);

            // Redirect back to the user management page
            response.sendRedirect("WEB-INF/user-management");
        }


}
