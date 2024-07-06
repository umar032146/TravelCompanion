package com.example.travelcompanion;

import static com.example.travelcompanion.R.*;
import static com.example.travelcompanion.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layout.loadingscreen);
        ProgressBar progressBar;
        progressBar = findViewById(progress);
        Sprite doubleBounce = new Wave();
        progressBar.setIndeterminateDrawable(doubleBounce);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                setContentView(layout.activity_main);
                Button login =findViewById(id.login);
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Login.class);
                        startActivity(intent);
                    }
                });
               Button signup = findViewById(id.sign);
               signup.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent1 = new Intent(MainActivity.this, signup.class);
                       startActivity(intent1);
                   }
               });

            }
        },2500);



    }
}