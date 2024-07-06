package com.example.travelcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Handler;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class hotels extends AppCompatActivity {
    LinearLayout hotelContainer;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotels);
        Button backbtnhotel= findViewById(R.id.backbtnhotel);
         hotelContainer = findViewById(R.id.hotel);
        backbtnhotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hotels.this, homepageadmin.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void fetchHotels() {
        OkHttpClient client = new OkHttpClient();
        String url = "http://10.0.2.2:3000/hotels";  // Use '10.0.2.2' to access 'localhost' from an Android emulator

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("MainActivity", "Error fetching data", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<Hotel>>() {}.getType();
                    List<Hotel> hotels = gson.fromJson(responseData, listType);

                    // Update UI on the main thread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            displayHotels(hotels);
                        }
                    });
                }
            }
        });
    }
    private void displayHotels(List<Hotel> hotels) {
        for (Hotel hotel : hotels) {
            TextView textView = new TextView(this);
            textView.setText(hotel.getName() + " - " + hotel.getLocation());
            textView.setTextSize(18);
            textView.setPadding(0, 10, 0, 10);
            hotelContainer.addView(textView);
        }
    }
}
class Hotel {
    private int id;
    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
