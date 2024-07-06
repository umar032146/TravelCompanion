package com.example.travelcompanion;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;



import androidx.appcompat.app.AppCompatActivity;

public class homepageadmin extends AppCompatActivity {
    LinearLayout cover;
    Button hotel;
    Button transport;
    Button restaurant;
    Button airline;
    Button attract;
    Button logout;

    Button settings;
    Button users;

    Button help;
    Button message;

    Button open;
    Button roles;
    public boolean isMenuOpen = false;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepageadmin);
        help =findViewById(R.id.helpadmin);
        message = findViewById(R.id.messages);
        cover =findViewById(R.id.covermenuad);
        hotel =findViewById(R.id.hotel);
        transport =findViewById(R.id.transport);
        restaurant =findViewById(R.id.restaurant);
        airline =findViewById(R.id.airline);
        attract =findViewById(R.id.attract);
        logout =findViewById(R.id.out);
         open = findViewById(R.id.openmenuad);
       settings=findViewById(R.id.set);
       users=findViewById(R.id.users);
       roles=findViewById(R.id.roles);


       help.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(homepageadmin.this, help.class);
               startActivity(intent);
               finish();
           }
       });

       message.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(homepageadmin.this, messages.class);
               startActivity(intent);
               finish();
           }
       });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(homepageadmin.this, hotels.class);
               startActivity(intent);
            }
        });

        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepageadmin.this, transport.class);
                startActivity(intent);
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepageadmin.this, restaurants.class);
                startActivity(intent);
            }
        });

        airline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepageadmin.this, attract.class);
                startActivity(intent);
            }
        });

        attract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepageadmin.this, attract.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepageadmin.this, Login.class);
                startActivity(intent);
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(homepageadmin.this, com.example.travelcompanion.settings.class);
                startActivity(intent);
                finish();
            }
        });

        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(homepageadmin.this, com.example.travelcompanion.users.class);
                startActivity(intent);
                finish();
            }
        });
        roles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(homepageadmin.this, com.example.travelcompanion.roles.class);
                startActivity(intent);
                finish();
            }
        });



    }

    public void toggle() {
        Animation slideinleft = AnimationUtils.loadAnimation(this, R.anim.slideinleft);
        Animation slideinright = AnimationUtils.loadAnimation(this, R.anim.slideoutleft);

        if (isMenuOpen == false) {
            cover.startAnimation(slideinleft);
            cover.setVisibility(View.VISIBLE);
            isMenuOpen = true;
        } else {
            cover.startAnimation(slideinright);
            cover.setVisibility(View.GONE);
            isMenuOpen = false;
        }
    }


}
