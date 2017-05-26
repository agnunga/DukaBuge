/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.controller;

import com.ag.beanI.ShipmentBeanI;
import com.ag.beanI.UserBeanI;
import com.ag.model.Shipment;
import com.ag.type.ShipmentStatus;
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
@WebServlet(name = "AddShipment", urlPatterns = {"/a/add_shipment"})
public class AddShipment extends HttpServlet {

    @EJB
    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/addShipment.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Shipment shipment = new Shipment();
//        shipment.setDeliveryDateTime(request.getParameter("deliveryDateTime"));
        shipment.setDestination(request.getParameter("destination"));
//        shipment.setOrder(request.getParameter("order"));
        shipment.setOrigin(request.getParameter("origin"));
        shipment.setShipmentCost(Utility1.ParseDouble(request.getParameter("shipmentCost")));
//        shipment.setShipmentDateTime(request.getParameter("shipmentDateTime"));
        shipment.setStatus(ShipmentStatus.PROCESSED);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/addShipment.jsp");
        request.setAttribute("message", ((beanI.addShipment(shipment) != null) ? "Success! " : "Failed! ") + " ");
        dispatcher.forward(request, response);
    }

}
