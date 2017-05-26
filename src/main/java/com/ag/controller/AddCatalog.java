/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.controller;

import com.ag.beanI.CatalogBeanI;
import com.ag.beanI.UserBeanI;
import com.ag.model.Catalog;
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
@WebServlet(name = "AddCatalog", urlPatterns = {"/a/add_catalog"})
public class AddCatalog extends HttpServlet {

    @EJB
    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/addCatalog.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Catalog catalog = new Catalog();
        catalog.setName(request.getParameter("name"));
        catalog.setQuantity(Utility1.ParseInt(request.getParameter("quantity")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/addCatalog.jsp");
        request.setAttribute("message", ((beanI.addCatalog(catalog) != null) ? "Success! " : "Failed! ") + " ");

        dispatcher.forward(request, response);
    }

}
