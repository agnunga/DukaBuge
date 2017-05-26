package com.ag.controller;

import com.ag.beanI.UserBeanI;
import com.ag.model.User;
import com.xag.util.MailObject;
import java.io.IOException;
import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/change_password")
public class ChangePwd extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    UserBeanI beanI;

    MailObject mo = null;

    private MailObject getMailObject() {
        return (this.mo == null) ? new MailObject() : mo;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("changePassword.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        long id = (Long) session.getAttribute("user_a");
        User user = beanI.findById(id);
        request.setAttribute("message", "Failed");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("message", (beanI.changePassword(user.getUsername(), request.getParameter("password"), request.getParameter("newPassword")) ? "Success! " : "Failed! ") + " ");
        dispatcher.forward(request, response);
    }
}
