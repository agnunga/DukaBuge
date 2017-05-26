/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.rest;

import com.xag.util.RestUtil;
import com.ag.beanI.CatalogBeanI;
import com.ag.beanI.OrderBeanI;
import com.ag.model.Catalog;
import com.xag.util.ResponseObject;
import com.xag.util.NoMatchFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("/catalog")
public class CatalogREST {

    @EJB
    CatalogBeanI beanI;
    @EJB
    OrderBeanI rtbi;

    private ResponseObject responseObject = null;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Catalog entity) {
        Catalog addedCatalog = beanI.add(entity);
        responseObject = (addedCatalog != null) ? RestUtil.setResponseObject(true, addedCatalog) : RestUtil.setResponseObject(false, entity);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Catalog entity) {
        Catalog updatedCatalog = beanI.update(entity);
        responseObject = (updatedCatalog != null) ? RestUtil.setResponseObject(true, updatedCatalog) : RestUtil.setResponseObject(false, entity);
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

    @DELETE
    @Path("/remove")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(Catalog entity) {
        boolean isDeleted = beanI.delete(entity);
        responseObject = (isDeleted) ? RestUtil.setResponseObject(true, isDeleted) : RestUtil.setResponseObject(false, isDeleted);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") long id) {
        Catalog fetchedCatalog = beanI.findById(id);
        responseObject = (fetchedCatalog != null) ? RestUtil.setResponseObject(true, fetchedCatalog) : RestUtil.setResponseObject(false, null);
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
