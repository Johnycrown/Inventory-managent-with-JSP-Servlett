package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import service.UserService;

import java.io.IOException;

@WebServlet("/admin-add-user")
public class AddUserServlet extends HttpServlet {




        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Forward to the JSP page for adding a new user
            request.getRequestDispatcher("WEB-INF/add-user.jsp").forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            UserService userService = new UserService();
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String password = request.getParameter("password");

            User newUser = new User();
            newUser.setEmail(email);
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setPassword(password);
            newUser.setActive(true);

            // Create a new user in the database

            userService.registerUser(email,true,firstName,lastName,password,2);



            // Redirect back to the user management page
            response.sendRedirect("user-management");
        }


}
