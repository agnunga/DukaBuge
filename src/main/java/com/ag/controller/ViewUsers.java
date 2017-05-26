/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.controller;

import com.ag.beanI.UserBeanI;
import com.ag.model.User;
import com.xag.util.Utility1;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ViewUsers", urlPatterns = {"/a/view_users"})
public class ViewUsers extends HttpServlet {

    @EJB
    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = beanI.findAll();
        request.setAttribute("data", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/viewUsers.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Utility1.ParseLong(request.getParameter("id"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/viewUsers.jsp");
        request.setAttribute("message", "Failed");
        if (beanI.delete(id) > 0) {
            request.setAttribute("message", "Success");
        }
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = beanI.findById(Utility1.ParseLong(request.getParameter("id")));
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("pwd"));
        user.setUsername(request.getParameter("username"));
        //user.setRole(request.getParameter("role"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/viewUsers.jsp");

        request.setAttribute("message", (beanI.update(user) != null ? "Success! Updated." : "Failed! Not Updated.") + " ");

        dispatcher.forward(request, response);

    }

}
