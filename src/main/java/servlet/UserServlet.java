package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Item;
import models.User;
import service.ItemService;
import service.UserService;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("USER doget SERVLET IS CALLED UPON \n\n\n ");

        UserService userService = new UserService();

        try {
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");

            List<Item>  itemList = userService.getAllItems("cprg352+anne@gmail.com");
            itemList.forEach(item -> System.out.println(item));
            ItemService itemService = new ItemService();
          // List<Item>  itemList=    itemService.getAllItemByEmailUsingJDBC("cprg352+anne@gmail.com");
            System.out.println("list of items gotten \n\n\n"+itemList  );
            request.setAttribute("items",itemList);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }

        String action = request.getParameter("action");
        if (action != null && action.equals("view")) {
            try {
                int id = Integer.parseInt(request.getParameter("userId"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
      //  request.getRequestDispatcher()
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email1 = (String) session.getAttribute("email");
        UserService userService = new UserService();





        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        boolean active = "true".equals(request.getParameter("active"));
        int roleId = Integer.parseInt(request.getParameter("role"));

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPassword(password);
        newUser.setActive(active);


        userService.registerUser(email,active,firstName,lastName,password,roleId);


        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
