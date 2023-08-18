package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {



        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Get the logged-in user from the session
            User user = (User) request.getSession().getAttribute("user");

            // Forward to the JSP page for displaying account information
            request.setAttribute("user", user);
            request.getRequestDispatcher("WEB-INF/account.jsp").forward(request, response);
        }


}
