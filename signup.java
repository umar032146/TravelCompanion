package com.example.travelcompanion;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class signup extends AppCompatActivity {

    Button signup;
    EditText pass;
    EditText email;

    EditText uname;
    FirebaseAuth auth;
    FirebaseFirestore fstore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signup= findViewById(R.id.reg);
        pass=findViewById(R.id.passs);
        email=findViewById(R.id.emails);
        uname = findViewById(R.id.uname);
        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passst , emailstr , unamestr;
                passst = pass.getText().toString().trim();
                emailstr = email.getText().toString().trim();
                unamestr = uname.getText().toString().trim();
                if (passst.isEmpty()){
                    pass.setError("Enter Password");
                }else if (emailstr.isEmpty()){
                    email.setError("Enter Username");
                } else if (unamestr.isEmpty()) {
                    uname.setError("Enterusername");
                } else{
                  auth.createUserWithEmailAndPassword(emailstr, passst).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task){
                      if (task.isComplete()){
                          FirebaseUser user = auth.getCurrentUser();
                          DocumentReference dr = fstore.collection("users").document(user.getUid());
                          Map<String,Object> userinfo = new HashMap<>();
                          userinfo.put("Username", unamestr);
                          userinfo.put("Email", emailstr);
                          userinfo.put("Password", passst);
                          dr.set(userinfo);
                          Toast.makeText(com.example.travelcompanion.signup.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                      }else{
                          Toast.makeText(com.example.travelcompanion.signup.this, "Signup Unsuccessful", Toast.LENGTH_SHORT).show();
                      }
                      }
                  });
                  }
            }
        });
}

}
