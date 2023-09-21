package com.example.bounceproductsapplication;

import java.io.Serializable;


public class ProductDTO implements Serializable {
    private final int id;
    private final String title;
    private final String description;
    private final int price;
    private final double rating;
    private final String brand;
    private final String thumbnail;

    public ProductDTO(int id, String title, String description, int price ,double rating, String brand, String thumbnail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.brand = brand;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getBrand() {
        return brand;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}

