/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.controller;

import com.ag.beanI.BookBeanI;
import com.ag.beanI.CatalogBeanI;
import com.ag.beanI.UserBeanI;
import com.ag.model.Book;
import com.ag.model.Catalog;
import com.ag.type.BookStatus;
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
@WebServlet(name = "AddBook", urlPatterns = {"/a/add_book"})
public class AddBook extends HttpServlet {

    @EJB
    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catalog> catalogs = beanI.findCatalogAll();
        request.setAttribute("catalogs", catalogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/addBook.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        book.setAuthor(request.getParameter("author"));
        book.setCatalog(beanI.findCatalogById(Utility1.ParseLong(request.getParameter("catalog"))));
        book.setDescription(request.getParameter("description"));
        book.setEdition(request.getParameter("edition"));
        book.setISBN(request.getParameter("isbn"));
        book.setPrice(Utility1.ParseDouble(request.getParameter("price")));
        book.setPublisher(request.getParameter("publisher"));
        book.setStatus(BookStatus.AVAILABLE);
        book.setTitle(request.getParameter("title"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/addBook.jsp");
        request.setAttribute("message", ((beanI.addBook(book) != null) ? "Success! " : "Failed! ") + " ");
        dispatcher.forward(request, response);
    }

}
