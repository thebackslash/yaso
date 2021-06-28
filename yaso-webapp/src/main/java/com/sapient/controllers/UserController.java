package com.sapient.controllers;

import com.sapient.entities.JasoUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {

        HttpSession session;

        //IUser userService = new UserService();

       /* boolean validateCredentials = userService.validateCredentials(req.getParameter("email"),
                req.getParameter("password"));
*/
        if (req.getParameter("email").equals("averdhen123@gmail.com") && req.getParameter("password").equals("aarsh")) {
            session = req.getSession();
            //User user = userService.getUser(req.getParameter("email"));

            JasoUser user = new JasoUser();
            user.setUserName("aarsh");
            user.setEmail("averdhen123@gmail.com");
            user.setPassword("aarsh");
            user.setId("101");
            session.setAttribute("user", user);
            
            resp.sendRedirect(req.getContextPath() + "/dashboard");

            // #TODO: Add uri to Dispatch to homepage or dashboard
            // req.getRequestDispatcher(URI).forward(req,resp);

        } else {
            resp.getWriter().println("<h2 style='coloe:red'>Invalid Credentials. Please Try Again</h2>");
            req.getRequestDispatcher("WEB-INF/views/login.jsp").include(req, resp);
        }

    }
}
