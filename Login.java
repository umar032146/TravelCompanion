package com.example.travelcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    String emails , passs;
    EditText emaill;
    EditText passl;
    FirebaseFirestore fstore;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        Button forgot = findViewById(R.id.forgetpass);
        Button login = findViewById(R.id.loginbtn);
         emaill = findViewById(R.id.emall);
         passl = findViewById(R.id.passl);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Login.this, forgetpass.class);
                startActivity(intent1);


            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emails= emaill.getText().toString().trim();
                passs = passl.getText().toString().trim();
                if (passs.isEmpty()){
                    passl.setError("Enter Password");
                }else if (emails.isEmpty()){
                    emaill.setError("Enter Username");
                }else{
                 auth.signInWithEmailAndPassword(emails ,passs ).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                     public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()){
                          if (emails.equals("umar032146@gmail.com")) {
                              FirebaseUser user = auth.getCurrentUser();
                              if (user != null){
                                  updatefirestore(user.getUid());
                              }
                              Intent intn = new Intent(Login.this, homepageadmin.class);
                              startActivity(intn);
                              finish();
                          }else{
                              FirebaseUser user = auth.getCurrentUser();
                              if (user != null){
                                  updatefirestore(user.getUid());
                              }
                              Intent intn = new Intent(Login.this, homepage.class);
                              startActivity(intn);
                              finish();

                          }



                      }else {
                          Toast.makeText(Login.this, "Authentication failed.",
                                  Toast.LENGTH_SHORT).show();

                      }
                     }
                 });



                }
            }
        });
    }
    public  void updatefirestore(String id){
        Map<String, Object> updates = new HashMap<>();
        updates.put("Password", passs);
        fstore.collection("users").document(id).update(updates);
    }
    public void navigayeadmin(){
        Intent intent1 = new Intent(Login.this, homepageadmin.class);
        startActivity(intent1);
        finish();
    }


}
