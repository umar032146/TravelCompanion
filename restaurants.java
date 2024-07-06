package com.example.travelcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class restaurants extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants);
        Button backbtnres=findViewById(R.id.backbtnres);
        backbtnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(restaurants.this, homepageadmin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
