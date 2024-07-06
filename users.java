package com.example.travelcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class users extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> userNames;
    private FirebaseFirestore db;
    Button refresh;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users);
        Button backbtnuser = findViewById(R.id.userback);
        listView=findViewById(R.id.userslist);
        refresh= findViewById(R.id.refreshusers);
        userNames = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.userslistitem, R.id.textViewItem, userNames);
        listView.setAdapter(adapter);
        db = FirebaseFirestore.getInstance();

        backbtnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(users.this, homepageadmin.class);
                startActivity(inte);
                finish();

            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchUsernames();
            }
        });


    }
    private void fetchUsernames() {
        db.collection("users").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                userNames.clear();
                QuerySnapshot querySnapshot = task.getResult();
                if (querySnapshot != null) {
                    for (DocumentSnapshot document : querySnapshot.getDocuments()) {
                        String username = document.getString("Username");
                        if (username != null) {
                            userNames.add(username);
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            } else {
                // Handle the error
                refresh.setError("An error occured");
            }
        });
    }
}