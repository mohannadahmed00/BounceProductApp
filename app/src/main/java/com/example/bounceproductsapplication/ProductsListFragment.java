package com.example.bounceproductsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsListFragment extends Fragment implements Communicator {
    final static String TAG = "MainActivity";
    final static String URL = "https://dummyjson.com/";
    List<ProductDTO> products;
    RecyclerView recyclerView;
    ProductsRecyclerAdapter adapter;
    LinearLayoutManager layoutManager;

    Communicator communicator;

    public ProductsListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        products = new ArrayList<>();
        adapter = new ProductsRecyclerAdapter(this.getContext(), products, this);
        layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        getProducts();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_products_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator = (Communicator) getActivity();
    }

    void getProducts() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL).build();
        ApiServices apiServices = retrofit.create(ApiServices.class);
        Call<ProductsResponse> call = apiServices.getProducts();
        call.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                Log.i(TAG, "code: " + response.code());
                Log.i(TAG, "list length: " + products.size());
                products.addAll(response.body().getProducts());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Log.i(TAG, t.getMessage());
            }
        });
    }

    @Override
    public void sendProduct(ProductDTO productDTO) {
        this.communicator.sendProduct(productDTO);
    }
}