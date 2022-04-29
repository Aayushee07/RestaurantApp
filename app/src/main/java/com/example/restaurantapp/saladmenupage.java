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

public class saladmenupage extends AppCompatActivity {

    ImageView fibre,earthy,jain;
    Button Addtocart1,Addtocart2,Addtocart3;
    TextView name1,price1,name2,price2,name3,price3,tprice1,tprice2,tprice3;

    FirebaseFirestore firestore;
    FirebaseAuth Auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_saladmenupage);

        fibre=findViewById(R.id.imageView10);
        earthy = findViewById(R.id.imageView11);
        jain=findViewById(R.id.imageView13);
        Addtocart1=findViewById(R.id.button9);
        Addtocart2=findViewById(R.id.button10);
        Addtocart3=findViewById(R.id.button12);
        name1=findViewById(R.id.textView18);
        price1=findViewById(R.id.textView19);
        name2=findViewById(R.id.textView21);
        price2=findViewById(R.id.textView22);
        name3=findViewById(R.id.textView29);
        price3=findViewById(R.id.textView30);
        tprice1=findViewById(R.id.textView19);
        tprice2=findViewById(R.id.textView22);
        tprice3=findViewById(R.id.textView30);
        firestore=FirebaseFirestore.getInstance();
        Auth=FirebaseAuth.getInstance();

        fibre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),fibre_info.class));
            }
        });

        earthy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),earthy_info.class));
            }
        });

        jain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),jain_info.class));
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
                Toast.makeText(saladmenupage.this,"Added to cart",Toast.LENGTH_SHORT).show();finish();
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
                Toast.makeText(saladmenupage.this,"Added to cart",Toast.LENGTH_SHORT).show();finish();
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
                Toast.makeText(saladmenupage.this,"Added to cart",Toast.LENGTH_SHORT).show();finish();
            }
        });

    }
}
