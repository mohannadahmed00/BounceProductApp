package com.example.bounceproductsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {
    public final static String PRODUCT = "PRODUCT";
    /*public final static String TITLE = "TITLE";
    public final static String PRICE = "PRICE";
    public final static String BRAND = "BRAND";
    public final static String DESCRIPTION = "DESCRIPTION";
    public final static String IMAGE = "IMAGE";
    public final static String RATING = "RATING";*/
    ProductDTO product;
    FragmentManager fragmentManager;
    ProductDetailsFragment productDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            this.product = (ProductDTO) savedInstanceState.get(PRODUCT);
            fragmentManager = getSupportFragmentManager();
            productDetailsFragment = (ProductDetailsFragment) fragmentManager.findFragmentById(R.id.productDetailsFragment);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (product != null && productDetailsFragment != null) {
            productDetailsFragment.setProduct(this.product);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(PRODUCT, product);
    }

    @Override
    public void sendProduct(ProductDTO product) {
        this.product = product;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentManager = getSupportFragmentManager();
            productDetailsFragment = (ProductDetailsFragment) fragmentManager.findFragmentById(R.id.productDetailsFragment);
            productDetailsFragment.setProduct(product);
        } else {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(PRODUCT, product);//i used serializable here
            /*intent.putExtra(TITLE,productDTO.getTitle());
            intent.putExtra(PRICE,productDTO.getPrice());
            intent.putExtra(BRAND,productDTO.getBrand());
            intent.putExtra(DESCRIPTION,productDTO.getDescription());
            intent.putExtra(IMAGE,productDTO.getThumbnail());
            intent.putExtra(RATING,productDTO.getRating());*/
            startActivity(intent);
        }
    }
}