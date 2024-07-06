package com.example.travelcompanion;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;


public class homepage extends AppCompatActivity {

    LinearLayout cover;
    Button setuse;
    public boolean isMenuOpen = false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        cover =findViewById(R.id.covermenu);
        Button helpcenter = findViewById(R.id.helpcenter);
      Button open = findViewById(R.id.openmenu);
      setuse =findViewById(R.id.setuse);

      helpcenter.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent =new Intent(homepage.this, help.class);
              startActivity(intent);
              finish();
          }
      });
      open.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              toggle();
          }
      });

      setuse.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent =new Intent(homepage.this, settings.class);
              startActivity(intent);
              finish();
          }
      });

    }

    public void toggle(){
        Animation slideinleft = AnimationUtils.loadAnimation(this,R.anim.slideinleft);
        Animation slideinright = AnimationUtils.loadAnimation(this,R.anim.slideoutleft);

        if(isMenuOpen==false){
            cover.startAnimation(slideinleft);
            cover.setVisibility(View.VISIBLE);
            isMenuOpen=true;
        }else{
            cover.startAnimation(slideinright);
            cover.setVisibility(View.GONE);
            isMenuOpen=false;
        }


    }





    }

