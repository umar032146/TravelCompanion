package com.example.travelcompanion;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class messages extends AppCompatActivity {
    private FirebaseFirestore db;
    private TextView messagesTextView;
    private ListView messagesListView;
    private MessageAdapter adapter;
    private List<Message> messageList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages);
        Button mesback=findViewById(R.id.mesback);
        db = FirebaseFirestore.getInstance();
//        messagesTextView = findViewById(R.id.messagesTextView);
        messagesListView = findViewById(R.id.messagesListView);
        messageList = new ArrayList<>();
        adapter = new MessageAdapter(this, messageList);
        messagesListView.setAdapter(adapter);
        mesback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(messages.this, homepageadmin.class);
                startActivity(inte);
                finish();
            }
        });
        db.collection("messages")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    if (e != null) {
                        return;
                    }

                    messageList.clear();
                    for (DocumentSnapshot document : queryDocumentSnapshots.getDocuments()) {
                        String username = document.getString("username");
                        String message = document.getString("message");
                        messageList.add(new Message(username, message));
                    }
                    adapter.notifyDataSetChanged();
                });
    }
}
