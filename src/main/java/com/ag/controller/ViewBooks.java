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

/**
 *
 * @author agunga
 */
@WebServlet(name = "ViewBooks", urlPatterns = {"/a/view_books"})
public class ViewBooks extends HttpServlet {

    @EJB
    UserBeanI beanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = beanI.findBookAll();
        request.setAttribute("data", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/viewBooks.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/a/viewBooks.jsp");
        request.setAttribute("message", (beanI.deleteBook(Utility1.ParseLong(request.getParameter("id"))) > 0 ? "Success! Deleted." : "Failed! Nor deleted") + " ");
        dispatcher.forward(request, response);
    }

}
