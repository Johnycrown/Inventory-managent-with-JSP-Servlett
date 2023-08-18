package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {



        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Invalidate the session to log out the user
            request.getSession().invalidate();

            // Redirect to the login page or another appropriate page
            response.sendRedirect("login"); // Change "login" to your actual login page URL
        }


}
