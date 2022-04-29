package com.example.restaurantapp;

import static java.sql.DriverManager.println;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {

    TextView overAllAmount;
    int overAllTotal;
    RecyclerView recyclerView;
    List<MyCartModel> cartModelList;
    MyCartAdapter cartAdapter;
    FirebaseAuth auth;
    FirebaseFirestore firestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

    auth = FirebaseAuth.getInstance();
    firestore = FirebaseFirestore.getInstance();


    LocalBroadcastManager.getInstance(this)
            .registerReceiver(mMessageReceiver,new IntentFilter("MyTotalAmount"));

    overAllAmount=findViewById(R.id.textView3);
    recyclerView = findViewById(R.id.rec);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    cartModelList=new ArrayList<>();
    cartAdapter= new MyCartAdapter(this,cartModelList);
    recyclerView.setAdapter(cartAdapter);
    firestore.collection("AddToCart").document(auth.getCurrentUser().getUid())
            .collection("User").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if(task.isSuccessful()){
                for(DocumentSnapshot doc :task.getResult().getDocuments()){
                    MyCartModel myCartModel=doc.toObject(MyCartModel.class);
                    cartModelList.add(myCartModel);
                    cartAdapter.notifyDataSetChanged();
                    println("A");
                }
            }
        }
    });


    }

    public BroadcastReceiver mMessageReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int totalBill =intent.getIntExtra("totalAmount",0);
            overAllAmount.setText("Total Amount:"+totalBill+"Rs");

        }
    };
}