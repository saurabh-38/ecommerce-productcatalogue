package com.saurabh.ecomerce.auth.product;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCCT")

public class Product {
    @Id
    @Column( name = "ID")
    public int id;
    @Column( name = "TITLE")
    public String title;
    @Column( name = "PRICE")
    public double price;
    @Column( name = "DESCRIPTION")
    public String description;
    @Column( name = "CATEGORY")
    public String category;
    @Column( name = "IMAGE")
    public String image;
    @Embedded
    public Rating rating;

    // Getters and Setters
    @Embeddable  // Marks Rating as an embeddable object
    @Data
    public static class Rating {
        @Column(name = "RATE")
        public double rate;
        @Column(name = "COUNT")
        public int count;

        // Getters and Setters
    }

    // Constructors, getters, setters, etc.
}
