/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author agunga
 */
@WebServlet(name = "AddUser", urlPatterns = {"/a/add_user"})
public class AddUser extends HttpServlet {

    @EJB
    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/addUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setRole(UserRole.ADMIN);
        user.setUsername(request.getParameter("userame"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/addUser.jsp");
        request.setAttribute("message", ((beanI.add(user) != null) ? "Success! " : "Failed! ") + " ");
        dispatcher.forward(request, response);
    }

}
