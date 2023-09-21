package com.example.bounceproductsapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("products")
    Call<ProductsResponse> getProducts();
}
