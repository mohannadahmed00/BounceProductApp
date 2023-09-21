package com.example.bounceproductsapplication;

import java.util.List;

public class ProductsResponse {
    /**can I not use this class when calling GET request in ApiServices and use List<ProductDTO> directly instead?*/
    public List<ProductDTO> products;

    public ProductsResponse(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }
}
