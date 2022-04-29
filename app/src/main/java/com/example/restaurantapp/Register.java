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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Register extends AppCompatActivity
{
    EditText mEmail,mFullName,mPassword,mPhone;
    Button mSignInBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;






    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.editTextTextPersonName2);
        mEmail = findViewById(R.id.editTextTextPersonName4);
        mPassword = findViewById(R.id.editTextTextPersonName5);
        mPhone = findViewById(R.id.editTextTextPersonName3);
        mSignInBtn = findViewById(R.id.button8);
        fAuth = FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();

//        if(fAuth.getCurrentUser() !=null)
//        {
//            startActivity(new Intent(getApplicationContext(),Login.class));
//
//
//        }

        mSignInBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(@NonNull View v)
            {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String fullName = mFullName.getText().toString();
                String phone = mPhone.getText().toString();
                if (TextUtils.isEmpty(email))
                {
                    mEmail.setError("Enter your Email");
                    return;
                }
                if (TextUtils.isEmpty(password))
                {
                    mPassword.setError("Enter your Password");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText( Register.this,"User Created",Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fullName",fullName);
                            user.put("phone",phone);
                            user.put("email",email);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG,"On success:User profile is created for"+userID);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),Login.class));
                        }
                        else
                        {
                            Toast.makeText( Register.this,"Error!!!!"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    };
};