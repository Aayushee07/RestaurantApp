package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adminlogin extends AppCompatActivity {
    EditText logintext,passtext;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_adminlogin);

        logintext=findViewById(R.id.editTextTextPersonName);
        passtext= findViewById(R.id.editTextTextPassword);

        btnLogin= findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = logintext.getText().toString();
                String password = passtext.getText().toString();

                if(username.equals("Bhargav") && (password.equals("0000")))
                {
                    Toast.makeText(Adminlogin.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                    //Intent intent=new Intent(getApplicationContext(),AdminFunction.class);
                    startActivity(new Intent(getApplicationContext(), AdminFunction.class));
                    //startActivity(intent);

                }
                else
                {
                    Toast.makeText(Adminlogin.this, "Invalid user or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}