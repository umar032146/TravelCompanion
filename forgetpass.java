package com.example.travelcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;


public class forgetpass extends AppCompatActivity {
    Button reset;
    EditText emailreset;
    FirebaseAuth auth;

    String resetemail;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpassword);
        reset= findViewById(R.id.resetbtn);
        emailreset = findViewById(R.id.resetemail);
        auth = FirebaseAuth.getInstance();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetemail = emailreset.getText().toString().trim();

                if (resetemail.isEmpty()){
                    Toast.makeText(forgetpass.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }else{
                    auth.sendPasswordResetEmail(resetemail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                        if (task.isComplete()){
                            Toast.makeText(forgetpass.this, "Reset Email sent", Toast.LENGTH_SHORT).show();

                            Intent intn = new Intent(forgetpass.this, Login.class);
                            startActivity(intn);
                            finish();
                        }else {
                            Toast.makeText(forgetpass.this, "Error Occured", Toast.LENGTH_SHORT).show();
                        }
                        }
                    });
                }

            }
        });
    }
}
