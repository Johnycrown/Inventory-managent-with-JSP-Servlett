package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin")
public class AdminHomeServlet extends HttpServlet {



        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            // Forward to the admin homepage JSP
            request.getRequestDispatcher("WEB-INF/admin-home.jsp").forward(request, response);
        }


}
