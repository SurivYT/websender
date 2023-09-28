package com.example;

import jakarta.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Products extends PanacheEntity {
    public String name;
    public Integer price;
    public String description;
    public String image;
}
