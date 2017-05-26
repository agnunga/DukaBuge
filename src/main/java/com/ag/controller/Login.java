package com.ag.controller;

import com.ag.beanI.UserBeanI;
import com.ag.model.User;
import com.xag.util.MailObject;
import com.xag.util.SendMailTLS;
import java.io.IOException;
import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    UserBeanI beanI;

    MailObject mo = null;

    private MailObject getMailObject() {
        return (this.mo == null) ? new MailObject() : mo;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = beanI.authenticate(username, password);

        HttpSession session = request.getSession();
        if (user != null) {
            switch (user.getRole()) {
                case ADMIN: {
                    session.setAttribute("user_c", user.getId());
                    session.setAttribute("user_a", user.getId());
                    response.sendRedirect("a");
                    break;
                }
                case CUSTOMER: {
                    session.setAttribute("user_c", user.getId());
                    response.sendRedirect("shop");
                    break;
                }
                case TRANSPORTER: {
                    session.setAttribute("user_c", user.getId());
                    session.setAttribute("user_t", user.getId());
                    response.sendRedirect("t");
                    break;
                }
                default: {
                    session.setAttribute("usersession", user.getId());
                    response.sendRedirect("shop");
                    break;
                }
            }
        } else {
//            MailObject mo1 = new MailObject();
            MailObject mo1 = getMailObject();
            mo1.setTo(username);
            mo1.setMessageSubject("Login Attempt");
            mo1.setMessageBody("Was this you?");
            request.setAttribute("message", SendMailTLS.sendMail(mo1)
                    ? "Invalid Credentials. Try again or check your email for additional information!"
                    : "Invalid Credentials. Try again"
            );
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}
