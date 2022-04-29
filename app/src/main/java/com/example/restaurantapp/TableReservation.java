package com.example.restaurantapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class TableReservation extends AppCompatActivity {

    EditText mGuest, mDate, mTime;
    Button mGo;
    FirebaseFirestore firestore;
    FirebaseAuth Auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_table_reservation);

        mGuest = findViewById(R.id.editTextNumber);
        mDate = findViewById(R.id.editTextDate);
        mTime = findViewById(R.id.editTextTime);
        mGo = findViewById(R.id.button2);
        firestore = FirebaseFirestore.getInstance();
        Auth = FirebaseAuth.getInstance();
        
        
        mGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tablereservation();
            }
        });

//        mGo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                new TableReservation();
//            }
//        });
//    }
//        private void TableReservation(){
//            String Guest = mGuest.getText().toString();
//            String Date = mDate.getText().toString();
//            String Time = mTime.getText().toString();
//
//            Map<String, Object> x = new HashMap<>();
//
//            x.put("Guests", Guest);
//            x.put("Date", Date);
//            x.put("Time", Time);
//
//            firestore.collection("Table Reservation").document(Auth.getCurrentUser().getUid())
//                    .collection("User").add(x).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                @Override
//                public void onComplete(@NonNull Task<DocumentReference> task) {
//                    Toast.makeText(TableReservation.this, "Table Reserved", Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//            });
//                FirebaseFirestore.getInstance().collection("Table Reservation").add(x).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                    @Override
//
//                    public void onComplete(@NonNull Task<DocumentReference> task) {
//                        Toast.makeText( TableReservation.this,"Table Reserved",Toast.LENGTH_SHORT).show();
//                      System.out.println("Under toast");
//                    }
//                });


//            }
//        });


        }

    private void Tablereservation() {
        final HashMap<String,Object> cartMap = new HashMap<>();
        cartMap.put("Guest",mGuest.getText().toString());
        cartMap.put("Date",mDate.getText().toString());
        cartMap.put("Time",mTime.getText().toString());
        firestore.collection("Table Reservation").document(Auth.getCurrentUser().getUid())
                .collection("User").add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(TableReservation.this,"Table Reserved",Toast.LENGTH_SHORT).show();finish();
            }
        });


    }

}

