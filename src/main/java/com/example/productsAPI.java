package com.example;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.vertx.core.json.Json;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/products")
public class productsAPI {

    @GET
    @Path("/allproducts")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProducts() {
        System.out.println("received allProduct request");
        return "[{\"id\":1,\"name\":\"Product 1\",\"price\":19.99,\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\",\"image\":\"https://placehold.co/1080x1080\"},{\"id\":2,\"name\":\"Product 2\",\"price\":29.99,\"description\":\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.\",\"image\":\"https://placehold.co/1080x1080\"},{\"id\":3,\"name\":\"Product 3\",\"price\":15.99,\"description\":\"Nullam luctus enim ac ex dictum, quis dapibus dolor sollicitudin.\",\"image\":\"https://placehold.co/1080x1080\"},{\"id\":4,\"name\":\"Product 4\",\"price\":9.99,\"description\":\"Suspendisse potenti. Praesent non tellus sit amet risus convallis congue.\",\"image\":\"https://placehold.co/1080x1080\"},{\"id\":5,\"name\":\"Product 5\",\"price\":49.99,\"description\":\"Quisque congue velit vitae nunc elementum, ac scelerisque ligula ullamcorper.\",\"image\":\"https://placehold.co/1080x1080\"}]";
    }
}
