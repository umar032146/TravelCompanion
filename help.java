package com.example.travelcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class help extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private EditText messageEditText;
    private Button sendButton;
    String username;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        Button helpbkbtn= findViewById(R.id.helpback);
        db = FirebaseFirestore.getInstance();
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            db.collection("users").document(currentUser.getUid()).get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                username = document.getString("Username");
                            }
                        }
                    });
        }

        helpbkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(help.this, homepageadmin.class);
                startActivity(inte);
                finish();
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString().trim();
                sendMessage(message);
            }
        });
    }
    private void sendMessage(String message) {
        if (username != null) {
            Map<String, Object> messageData = new HashMap<>();
            messageData.put("username", username);
            messageData.put("message", message);
            messageData.put("timestamp", System.currentTimeMillis());

            db.collection("messages")
                    .add(messageData)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(help.this, "message sent ", Toast.LENGTH_SHORT).show();
                        messageEditText.setText(""); // Clear the input field
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(help.this, "message didnt sent ", Toast.LENGTH_SHORT).show();
                        // Handle failure
                    });
        }
    }

}
