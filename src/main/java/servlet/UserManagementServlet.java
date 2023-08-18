package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/user-management")
public class UserManagementServlet extends HttpServlet {


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Fetch the list of all user accounts from the database
            UserService userService = new UserService();
            List<User>  userList = userService.findAllUser();

            // Forward to the JSP page for displaying user accounts
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("WEB-INF/user-management.jsp").forward(request, response);
        }


}
