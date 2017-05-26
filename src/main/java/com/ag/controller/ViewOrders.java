/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.controller;
 
import com.ag.beanI.UserBeanI;
import com.ag.model.Order;
import com.ag.type.OrderStatus;
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
@WebServlet(name = "ViewOrders", urlPatterns = {"/view_orders"})
public class ViewOrders extends HttpServlet {

    @EJB
    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        findOrders(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = beanI.findOrderById(Utility1.ParseLong(request.getParameter("id")));
        order.setStatus(OrderStatus.CANCELLED);
        request.setAttribute("message", (beanI.updateOrder(order) != null ? "Success! Cancelled " : "Failed! Not Cancelled") + " " + ".");
        findOrders(request, response);
    }

    protected void findOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = beanI.findOrderAll();
        request.setAttribute("data", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewOrders.jsp");
        dispatcher.forward(request, response);
    }

}
