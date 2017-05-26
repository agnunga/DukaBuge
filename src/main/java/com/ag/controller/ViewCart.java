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
@WebServlet(name = "ViewCart", urlPatterns = {"/view_cart"})
public class ViewCart extends HttpServlet {

//    @EJB
//    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Book> orderedBooks = (List<Book>) session.getAttribute("session_cart");

        request.setAttribute("data", orderedBooks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewCart.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Book book = beanI.findById(Utility1.ParseLong(request.getParameter("id")));
        int index = Utility1.ParseInt(request.getParameter("index"));
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewCart.jsp");
        List<Book> orderedBooks = (List<Book>) session.getAttribute("session_cart");
        //        orderedBooks.remove(book);

        request.setAttribute("message", (orderedBooks.remove(index) != null ? "Success! Removed " : "Failed to remove") + " " + " from cart.");
        request.setAttribute("data", orderedBooks);
        dispatcher.forward(request, response);
    }

}
