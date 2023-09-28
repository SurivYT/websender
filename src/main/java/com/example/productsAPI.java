package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/products")
public class productsAPI {

    @GET
    @Path("/allproducts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PanacheEntityBase> getProducts() {
        System.out.println("received allProduct request");
        return Products.listAll();
    }

    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PanacheEntityBase getProduct(@PathParam("id") Long id) {
        System.out.println("received single product request");
        return Products.findById(id);
    }
}
