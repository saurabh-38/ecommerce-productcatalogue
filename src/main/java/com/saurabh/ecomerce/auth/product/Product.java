package com.saurabh.ecomerce.auth.product;

public class Product {

    public int id;
    public String title;
    public double price;
    public String description;
    public String category;
    public String image;
    public Rating rating;

    // Getters and Setters

    public static class Rating {
        public double rate;
        public int count;

        // Getters and Setters
    }

    // Constructors, getters, setters, etc.
}
