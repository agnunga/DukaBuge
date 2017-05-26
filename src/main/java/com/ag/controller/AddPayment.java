/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.controller;

import com.ag.beanI.PaymentBeanI;
import com.ag.beanI.UserBeanI;
import com.ag.model.Payment;
import com.xag.util.Utility1;
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
@WebServlet(name = "AddPayment", urlPatterns = {"/add_payment"})
public class AddPayment extends HttpServlet {

    @EJB
    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addPayment.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Payment payment = new Payment();
        payment.setAmount(Utility1.ParseDouble(request.getParameter("amount")));
        payment.setOrder(null);
//        payment.setPaymentDatetime(request.getParameter("paymentDatetime"));
//        payment.setPaymentMode(request.getParameter("paymentMode")); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addPayment.jsp");
        request.setAttribute("message", ((beanI.addPayment(payment) != null) ? "Success! " : "Failed! ") + " ");
        dispatcher.forward(request, response);
    }

}
