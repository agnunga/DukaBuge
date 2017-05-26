/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.rest;

import com.xag.util.RestUtil;
import com.ag.beanI.BookBeanI;
import com.ag.model.Book;
import com.xag.util.ResponseObject;
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
@Path("/book")
public class BookREST {

    @EJB
    BookBeanI beanI;

    private ResponseObject responseObject = null;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Book entity) {
        Book addedBook = beanI.add(entity);
        responseObject = (addedBook != null) ? RestUtil.setResponseObject(true, addedBook) : RestUtil.setResponseObject(false, entity);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Book entity) {
        Book updatedBook = beanI.update(entity);
        responseObject = (updatedBook != null) ? RestUtil.setResponseObject(true, updatedBook) : RestUtil.setResponseObject(false, entity);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @DELETE
    @Path("/remove")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(Book entity) {
        boolean idDeleted = beanI.delete(entity);
        responseObject = (idDeleted) ? RestUtil.setResponseObject(true, idDeleted) : RestUtil.setResponseObject(false, idDeleted);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @DELETE
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") long id) {
        int deletedRows = beanI.delete(id);
        responseObject = (deletedRows > 0) ? RestUtil.setResponseObject(true, deletedRows) : RestUtil.setResponseObject(false, deletedRows);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") long id) {
        Book fetchedBook = beanI.findById(id);
        responseObject = (fetchedBook != null) ? RestUtil.setResponseObject(true, fetchedBook) : RestUtil.setResponseObject(false, null);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        responseObject = RestUtil.setResponseObject(true, beanI.findAll());
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

}
