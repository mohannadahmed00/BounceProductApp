package com.example.bounceproductsapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ProductViewHolder> {

    static final String TAG = "ProductsRecyclerAdapter";
    Context context;
    List<ProductDTO> products;
    Communicator communicator;

    ProductsRecyclerAdapter(Context context, List<ProductDTO> products, Communicator communicator) {
        this.context = context;
        this.products = products;
        this.communicator = communicator;

    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder");
        ProductDTO product = products.get(position);
        holder.getTvTitle().setText(product.getTitle());
        holder.getTvPrice().setText(String.valueOf(product.getPrice()).concat(" $"));
        holder.getView().setOnClickListener(e -> {
            communicator.sendProduct(product);
            //Toast.makeText(context, "hello:"+product.title, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView tvTitle;
        TextView tvPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }

        public View getView() {
            return view;
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvPrice() {
            return tvPrice;
        }
    }
}
