package com.example.travelcompanion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class settings extends AppCompatActivity {
//    private ToggleButton toggleButton;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    String uname;
    String password;
    Button chnguser;
    Button changepass;
    EditText userpass;
    EditText username;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Button setbackbtn= findViewById(R.id.setback);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        chnguser = findViewById(androidx.constraintlayout.widget.R.id.square);
        username =findViewById(R.id.changeusername);
        userpass = findViewById(R.id.changepass);
        changepass =findViewById(com.github.ybq.android.spinkit.R.id.Circle);
        chnguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = username.getText().toString().trim();
                if (!uname.isEmpty()){
                    String Uid= mAuth.getCurrentUser().getUid();
                    if (Uid!=null){
                        db.collection("users").document(Uid).update("Username", uname)
                                .addOnSuccessListener(e ->{
                                Toast.makeText(settings.this, "Username Changed successfully", Toast.LENGTH_SHORT).show();
                        }).addOnFailureListener(avoid ->{
                                    Toast.makeText(settings.this, "Username cannot be changed", Toast.LENGTH_SHORT).show();

                                });
                    }
                }else{
                    username.setError("Enter Username");
                }
            }
        });


        setbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(settings.this, homepageadmin.class);
                startActivity(inte);
                finish();
            }
        });

        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = userpass.getText().toString().trim();
                FirebaseUser user = mAuth.getCurrentUser();
                String Uid = user.getUid();
                if (!password.isEmpty()){
                   if (user!=null){
                       user.updatePassword(password);
                       db.collection("users").document(Uid).update("Password", password).addOnSuccessListener(aVoid -> {
                                   // Password updated in Firestore
                                   Toast.makeText(settings.this, "Password Changed successfully", Toast.LENGTH_SHORT).show();

                               })
                               .addOnFailureListener(e -> {
                                   // Handle error
                                   Toast.makeText(settings.this, "password Change unsuccessful", Toast.LENGTH_SHORT).show();

                               });
                   }else{
                       Toast.makeText(settings.this, "password Change unsuccessful", Toast.LENGTH_SHORT).show();
                   }
                }else {
                    userpass.setError("Enter new password");
                }
            }
        });

    }
}
