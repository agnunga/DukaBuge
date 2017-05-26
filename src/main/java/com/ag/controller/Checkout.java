/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.controller;

import com.ag.beanI.OrderBeanI;
import com.ag.beanI.UserBeanI;
import com.ag.model.Book;
import com.ag.model.Order;
import com.ag.model.User;
import com.ag.type.OrderStatus;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "Checkout", urlPatterns = {"/checkout"})
public class Checkout extends HttpServlet {

    @EJB
    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processCheckout(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processCheckout(request, response);
    }

    protected void processCheckout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Book> orderedBooks = (List<Book>) session.getAttribute("session_cart");
        User user = session.getAttribute("user_c") == null ? null : beanI.findById((long) session.getAttribute("user_c"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/checkout.jsp");
        if (user != null) {
            if (orderedBooks != null && orderedBooks.size() > 0) {

                Order order = new Order();
                order.setBooks(orderedBooks);
                order.setAmount(beanI.getTotal(orderedBooks));
                order.setStatus(OrderStatus.NEW);
                order.setUser(user);

                request.setAttribute("data", order);
                request.setAttribute("data_orderedBooks", orderedBooks);

                boolean orderPlaced = beanI.placeOrder(order, orderedBooks);
                request.setAttribute("message", (orderPlaced ? "Success! Order Placed" : "Failed to place order") + ".");
                if (orderPlaced) {
                    orderedBooks.clear();
                }
                session.setAttribute("session_cart", orderedBooks);
            } else {
                request.setAttribute("message", "Failed! You are trying to check out an empty cart.");
            }
        } else {
            response.sendRedirect("login");
        }
        dispatcher.forward(request, response);
    }

}
