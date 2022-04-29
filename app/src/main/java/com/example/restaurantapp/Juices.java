package com.example.restaurantapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Juices extends AppCompatActivity {
    ImageView cleanser,enhancer,charger;
    Button Addtocart1,Addtocart2,Addtocart3;
    TextView name1,price1,name2,price2,name3,price3,tprice1,tprice2,tprice3;

    FirebaseFirestore firestore;
    FirebaseAuth Auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_juices);

        cleanser=findViewById(R.id.imageView17);
        enhancer = findViewById(R.id.imageView18);
        charger=findViewById(R.id.imageView19);
        Addtocart1=findViewById(R.id.button4);
        Addtocart2=findViewById(R.id.button5);
        Addtocart3=findViewById(R.id.button6);
        name1=findViewById(R.id.textView51);
        price1=findViewById(R.id.textView52);
        name2=findViewById(R.id.textView55);
        price2=findViewById(R.id.textView56);
        name3=findViewById(R.id.textView58);
        price3=findViewById(R.id.textView59);
        tprice1=findViewById(R.id.textView52);
        tprice2=findViewById(R.id.textView56);
        tprice3=findViewById(R.id.textView59);
        firestore=FirebaseFirestore.getInstance();
        Auth=FirebaseAuth.getInstance();

        cleanser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),cleanser_info.class));
            }
        });

        enhancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),vision_info.class));
            }
        });

        charger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),charger_info.class));
            }
        });

        Addtocart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtocart1();
            }
        });

        Addtocart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtocart2();;
            }
        });

        Addtocart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtocart3();
            }
        });


    }

    private void addtocart3() {
        final HashMap<String,Object> cartMap = new HashMap<>();
        cartMap.put("productName",name3.getText().toString());
        cartMap.put("productPrice",price3.getText().toString());
        cartMap.put("totalPrice",tprice3.getText().toString());

        firestore.collection("AddtoCart").document(Auth.getCurrentUser().getUid())
                .collection("User").add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(Juices.this,"Added to cart",Toast.LENGTH_SHORT).show();finish();
            }
        });
    }

    private void addtocart2() {
        final HashMap<String,Object> cartMap = new HashMap<>();
        cartMap.put("productName",name2.getText().toString());
        cartMap.put("productPrice",price2.getText().toString());
        cartMap.put("totalPrice",tprice2.getText().toString());

        firestore.collection("AddtoCart").document(Auth.getCurrentUser().getUid())
                .collection("User").add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(Juices.this,"Added to cart",Toast.LENGTH_SHORT).show();finish();
            }
        });
    }

    private void addtocart1() {


        final HashMap<String,Object> cartMap = new HashMap<>();
        cartMap.put("productName",name1.getText().toString());
        cartMap.put("productPrice",price1.getText().toString());
        cartMap.put("totalPrice",tprice1.getText().toString());

        firestore.collection("AddtoCart").document(Auth.getCurrentUser().getUid())
                .collection("User").add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(Juices.this,"Added to cart",Toast.LENGTH_SHORT).show();finish();
            }
        });


    }
}
