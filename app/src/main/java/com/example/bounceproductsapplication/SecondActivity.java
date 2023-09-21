package com.example.bounceproductsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    ProductDetailsFragment productDetailsFragment;
    ProductDTO product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /**will the intent be destructed at the same time as the activity?*/
        Intent intent = getIntent();
        product = (ProductDTO) intent.getSerializableExtra(MainActivity.PRODUCT);
        /**should i handle changing orientation here? even if i used static fragment.*/
        fragmentManager = getSupportFragmentManager();
        productDetailsFragment = (ProductDetailsFragment) fragmentManager.findFragmentById(R.id.productDetailsFragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        productDetailsFragment.setProduct(product);
    }
}