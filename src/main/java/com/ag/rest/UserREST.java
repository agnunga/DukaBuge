/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.rest;

import com.xag.util.RestUtil;
import com.ag.beanI.UserBeanI;
import com.ag.model.Book;
import com.ag.model.Catalog;
import com.ag.model.Order;
import com.ag.model.Payment;
import com.ag.model.Shipment;
import com.ag.model.User;
import com.xag.util.ResponseObject;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author agunga
 */
@Path("/user")
public class UserREST {

    @EJB
    UserBeanI beanI;

    private ResponseObject responseObject = null;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User entity) {
        responseObject = (beanI.add(entity) != null) ? RestUtil.setResponseObject(true, entity) : RestUtil.setResponseObject(false, entity);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(User entity) {
        responseObject = (beanI.update(entity) != null) ? RestUtil.setResponseObject(true, entity) : RestUtil.setResponseObject(false, entity);
        return Response.status(Response.Status.OK).entity(responseObject).build();

    }

    @DELETE
    @Path("/remove")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(User entity) {
        responseObject = (beanI.delete(entity)) ? RestUtil.setResponseObject(true, null) : RestUtil.setResponseObject(false, null);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @DELETE
    @Path("/remove/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") long id) {
        responseObject = (beanI.delete(id) > 0) ? RestUtil.setResponseObject(true, null) : RestUtil.setResponseObject(false, null);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/find/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") long id) {
        responseObject = (beanI.findById(id) != null) ? RestUtil.setResponseObject(true, beanI.findById(id)) : RestUtil.setResponseObject(false, null);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        responseObject = RestUtil.setResponseObject(true, beanI.findAll());
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/authenticate/{username}/{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(@PathParam("username") String username, @PathParam("password") String password) {
        User user = beanI.authenticate(username, password);
        responseObject = (user != null) ? RestUtil.setResponseObject(true, user) : RestUtil.setResponseObject(false, null);
        return Response.status(Response.Status.OK).entity(responseObject).build();

    }

    @POST
    @Path("/changePassword/{username}/{password}/{newPassword}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response changePassword(@PathParam("username") String username, @PathParam("password") String password, @PathParam("newPassword") String newPassword) {
        responseObject = beanI.changePassword(username, password, newPassword) ? RestUtil.setResponseObject(true, true) : RestUtil.setResponseObject(false, false);
        return Response.status(Response.Status.OK).entity(responseObject).build();

    }

    @GET
    @Path("/findCatalogById/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCatalogById(@PathParam("id") long id) {
        Catalog catalog1 = beanI.findCatalogById(id);
        responseObject = catalog1 != null ? RestUtil.setResponseObject(true, catalog1) : RestUtil.setResponseObject(false, catalog1);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findCatalogAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCatalogAll() {
        List<Catalog> catalogs = beanI.findCatalogAll();
        responseObject = catalogs != null ? RestUtil.setResponseObject(true, catalogs) : RestUtil.setResponseObject(false, catalogs);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/addCatalog")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCatalog(Catalog catalog) {
        Catalog catalog1 = beanI.addCatalog(catalog);
        responseObject = catalog1 != null ? RestUtil.setResponseObject(true, catalog1) : RestUtil.setResponseObject(false, catalog1);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/addBook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(Book book) {
        Book book2 = beanI.addBook(book);
        responseObject = book2 != null ? RestUtil.setResponseObject(true, book2) : RestUtil.setResponseObject(false, book2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findBookAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findBookAll() {
        List<Book> books = beanI.findBookAll();
        responseObject = books != null ? RestUtil.setResponseObject(true, books) : RestUtil.setResponseObject(false, books);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @DELETE
    @Path("/deleteBook/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") long id) {
        responseObject = beanI.deleteBook(id) > 0 ? RestUtil.setResponseObject(true, true) : RestUtil.setResponseObject(false, false);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findAvailableBooks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAvailableBooks() {
        List<Book> books = beanI.findAvailableBooks();
        responseObject = books != null ? RestUtil.setResponseObject(true, books) : RestUtil.setResponseObject(false, books);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findSoldBooks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findSoldBooks() {
        List<Book> books = beanI.findSoldBooks();
        responseObject = books != null ? RestUtil.setResponseObject(true, books) : RestUtil.setResponseObject(false, books);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findBookById/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findBookById(@PathParam("id") long id) {
        Book book = beanI.findBookById(id);
        responseObject = book != null ? RestUtil.setResponseObject(true, book) : RestUtil.setResponseObject(false, book);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findOrderAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOrderAll() {
        responseObject = beanI.findOrderAll() != null ? RestUtil.setResponseObject(true, true) : RestUtil.setResponseObject(false, false);
        List<Order> orders = beanI.findOrderAll();
        RestUtil.setResponseObject(true, orders);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/placeOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response placeOrder(Order order, List<Book> books) {
        boolean order2 = beanI.placeOrder(order, books);
        responseObject = order2 ? RestUtil.setResponseObject(true, order2) : RestUtil.setResponseObject(false, order2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/updateOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrder(Order order) {
        Order order2 = beanI.updateOrder(order);
        responseObject = order2 != null ? RestUtil.setResponseObject(true, order2) : RestUtil.setResponseObject(false, order2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findOrderById/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOrderById(@PathParam("id") long id) {
        Order order2 = beanI.findOrderById(id);
        responseObject = order2 != null ? RestUtil.setResponseObject(true, order2) : RestUtil.setResponseObject(false, order2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/approveOrder/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response approveOrder(@PathParam("id") long id) {
        Order order2 = beanI.approveOrder(id);
        responseObject = order2 != null ? RestUtil.setResponseObject(true, order2) : RestUtil.setResponseObject(false, order2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/placeOrder2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response placeOrder(Order order) {
        Order order2 = beanI.placeOrder(order);
        responseObject = order2 != null ? RestUtil.setResponseObject(true, order2) : RestUtil.setResponseObject(false, order2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/cancelOrder/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelOrder(@PathParam("id") long id) {
        Order order2 = beanI.cancelOrder(id);
        responseObject = order2 != null ? RestUtil.setResponseObject(true, order2) : RestUtil.setResponseObject(false, order2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/pendOrder/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response pendOrder(@PathParam("id") long id) {
        Order order2 = beanI.pendOrder(id);
        responseObject = order2 != null ? RestUtil.setResponseObject(true, order2) : RestUtil.setResponseObject(false, order2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/approvePayment/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response approvePayment(@PathParam("id") long id) {
        Payment payment2 = beanI.approvePayment(id);
        responseObject = payment2 != null ? RestUtil.setResponseObject(true, payment2) : RestUtil.setResponseObject(false, payment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/cancelPayment/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelPayment(@PathParam("id") long id) {
        Payment payment2 = beanI.cancelPayment(id);
        responseObject = payment2 != null ? RestUtil.setResponseObject(true, payment2) : RestUtil.setResponseObject(false, payment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/pendPayment/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response pendPayment(@PathParam("id") long id) {
        Payment payment2 = beanI.pendPayment(id);
        responseObject = payment2 != null ? RestUtil.setResponseObject(true, payment2) : RestUtil.setResponseObject(false, payment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findOPaymentById/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOPaymentById(@PathParam("id") long id) {
        Payment payment2 = beanI.findOPaymentById(id);
        responseObject = payment2 != null ? RestUtil.setResponseObject(true, payment2) : RestUtil.setResponseObject(false, payment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/updatePayment/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePayment(@PathParam("id") long id) {
        Payment payment2 = beanI.updatePayment(id);
        responseObject = payment2 != null ? RestUtil.setResponseObject(true, payment2) : RestUtil.setResponseObject(false, payment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/confirmPayment/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirmPayment(@PathParam("id") long id) {
        Payment payment2 = beanI.confirmPayment(id);
        responseObject = payment2 != null ? RestUtil.setResponseObject(true, payment2) : RestUtil.setResponseObject(false, payment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/addPayment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPayment(Payment payment) {
        Payment payment2 = beanI.addPayment(payment);
        responseObject = payment2 != null ? RestUtil.setResponseObject(true, payment2) : RestUtil.setResponseObject(false, payment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/findPaymentByOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPaymentByOrder(Order order) {
        Payment payment2 = beanI.findPaymentByOrder(order);
        responseObject = payment2 != null ? RestUtil.setResponseObject(true, payment2) : RestUtil.setResponseObject(false, payment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/findShipmentByOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findShipmentByOrder(Order order) {
        Shipment shipment2 = beanI.findShipmentByOrder(order);
        responseObject = shipment2 != null ? RestUtil.setResponseObject(true, shipment2) : RestUtil.setResponseObject(false, shipment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/deliverShipment/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deliverShipment(@PathParam("id") long id) {
        Shipment shipment2 = beanI.deliverShipment(id);
        responseObject = shipment2 != null ? RestUtil.setResponseObject(true, shipment2) : RestUtil.setResponseObject(false, shipment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/addShipment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addShipment(Shipment shipment) {
        Shipment shipment2 = beanI.addShipment(shipment);
        responseObject = shipment2 != null ? RestUtil.setResponseObject(true, shipment2) : RestUtil.setResponseObject(false, shipment2);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/transitShipment/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response transitShipment(@PathParam("id") long id) {
        Shipment shipment = beanI.transitShipment(id);
        responseObject = shipment != null ? RestUtil.setResponseObject(true, shipment) : RestUtil.setResponseObject(false, shipment);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/processShipment/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response processShipment(@PathParam("id") long id) {
        Shipment shipment = beanI.processShipment(id);
        responseObject = shipment != null ? RestUtil.setResponseObject(true, shipment) : RestUtil.setResponseObject(false, shipment);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findShipmentById/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findShipmentById(@PathParam("id") long id) {
        Shipment shipment = beanI.findShipmentById(id);
        responseObject = shipment != null ? RestUtil.setResponseObject(true, shipment) : RestUtil.setResponseObject(false, shipment);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }
}
