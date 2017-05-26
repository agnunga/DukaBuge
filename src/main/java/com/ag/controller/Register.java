package com.ag.controller;

import com.ag.beanI.UserBeanI;
import com.ag.model.User;
import com.ag.type.UserRole;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author agunga
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    @EJB
    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setRole(UserRole.CUSTOMER);
        user.setUsername(request.getParameter("username"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        boolean isRegistered = beanI.add(user) != null;
        if (isRegistered) {
            HttpSession session = request.getSession();
            session.setAttribute("user_c", user.getId());
             response.sendRedirect("shop");
        }
        request.setAttribute("message", (isRegistered ? "Success! " : "Failed! ") + " ");
        dispatcher.forward(request, response);
    }

}
