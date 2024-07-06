package com.example.travelcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class roles extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.roles);
        Button backbtnrole =findViewById(R.id.roleback);
        backbtnrole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(roles.this, homepageadmin.class);
                startActivity(inte);
                finish();
            }
        });
    }
}
