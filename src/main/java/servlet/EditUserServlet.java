package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import service.UserService;

import java.io.IOException;

@WebServlet("/edit-user")
public class EditUserServlet extends HttpServlet {


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String email = request.getParameter("email");
            UserService userService = new UserService();
            // Fetch the user account from the database based on email
            User user = userService.findUserByEmail(email);
            // Forward to the JSP page for editing user account
            request.setAttribute("user", user);
            request.getRequestDispatcher("WEB-INF/edit-user.jsp").forward(request, response);
        }


}
