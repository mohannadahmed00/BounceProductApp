package com.example.bounceproductsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProductDetailsFragment extends Fragment {
    ImageView imageView;
    RatingBar ratingBar;
    TextView tvTitle;
    TextView tvPrice;
    TextView tvBrand;
    TextView tvDescription;

    public ProductDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageView);
        ratingBar = view.findViewById(R.id.ratingBar);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvPrice = view.findViewById(R.id.tvPrice);
        tvBrand = view.findViewById(R.id.tvBrand);
        tvDescription = view.findViewById(R.id.tvDescription);
    }

    void setProduct(ProductDTO product) {
        tvTitle.setText(product.getTitle());
        tvPrice.setText(String.valueOf(product.getPrice()).concat(" $"));
        tvBrand.setText(product.getBrand());
        tvDescription.setText(product.getDescription());
        ratingBar.setRating((float) product.getRating());
        Glide.with(this.getContext()).load(product.getThumbnail()).into(imageView);
    }
}