package com.example.travelcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class transport extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transport);
        Button backbtn = findViewById(R.id.backbtntrans);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(transport.this, homepageadmin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
