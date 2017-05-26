    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.controller;

import com.ag.beanI.UserBeanI;
import com.ag.model.Book;
import com.xag.util.Utility1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
@WebServlet(name = "Shop", urlPatterns = {"/shop"})
public class Shop extends HttpServlet {

    @EJB
    UserBeanI beanI;

    List<Book> orderedBooks = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = beanI.findAvailableBooks();
        request.setAttribute("data", books);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("session_cart") == null) {
            session.setAttribute("session_cart", orderedBooks);
        }

        orderedBooks = (List) session.getAttribute("session_cart");

        Book book = beanI.findBookById(Utility1.ParseLong(request.getParameter("id")));

        request.setAttribute("message", (orderedBooks.add(book) ? "Success! Added to cart." : "Failed! Not added to cart.") + " ");

        List<Book> books = beanI.findAvailableBooks();
        request.setAttribute("data", books);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
