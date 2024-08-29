package com.saurabh.ecomerce.auth.product;

public class product {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    // Getters and Setters

    public static class Rating {
        private double rate;
        private int count;

        // Getters and Setters
    }

    // Constructors, getters, setters, etc.
}
