package com.example.restaurantapp;

import static java.sql.DriverManager.println;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {
   Context context;
   List<MyCartModel> list;
   int totalAmount =0;

   public MyCartAdapter(Context context, List<MyCartModel> list){
       this.context = context;
       this.list = list;
   }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items, parent));
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartAdapter.ViewHolder holder, int position) {

       holder.name.setText(list.get(position).getProductName());
       holder.price.setText(list.get(position).getProductPrice());
       holder.totalPrice.setText(String.valueOf(list.get(position).getTotalPrice()));

       totalAmount=totalAmount+list.get(position).getTotalPrice();
        Intent intent=new Intent("MyTotalAmount");
        intent.putExtra("totalAmount",totalAmount);

        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       TextView name,price,totalPrice;

    public ViewHolder(@NonNull View itemView){
       super(itemView);
       name=itemView.findViewById(R.id.product_name);
       price=itemView.findViewById(R.id.product_price);
       totalPrice=itemView.findViewById(R.id.Total_Price);

   }
   }
}
