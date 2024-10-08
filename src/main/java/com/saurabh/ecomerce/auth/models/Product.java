package com.saurabh.ecomerce.auth.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
public class Product extends  BaseModel {


    public String title;
    @Column(length = 65555)
    @NotNull
    public String description;
    public String price;
    public String image;
    public String category;

   // public Rating rating;


    // Constructors, getters, setters, etc.
}
