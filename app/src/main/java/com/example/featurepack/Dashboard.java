package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {
    Button logout;
    CardView sf;
    CardView musicPlayer;
    CardView videoPlayer;
    CardView cameraCapture;
    CardView calculator;
    CardView messege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        logout = findViewById(R.id.inputback);
        musicPlayer = findViewById(R.id.music);
        videoPlayer = findViewById(R.id.video);
        cameraCapture = findViewById(R.id.camera);
        calculator = findViewById(R.id.basicCalculator);
        messege = findViewById(R.id.messegeApp);
        messege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(Dashboard.this,Messege.class);
                startActivity(o);
                finish();
            }
        });
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(Dashboard.this,Calculator.class);
                startActivity(n);
                finish();
            }
        });
        cameraCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(Dashboard.this,Camera.class);
                startActivity(m);
                finish();
            }
        });
        videoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(Dashboard.this,VideoPlayer.class);
                startActivity(l);
                finish();
            }
        });
        musicPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Dashboard.this,musicPlayer.class);
                startActivity(k);
                finish();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        sf = findViewById(R.id.specialf);

        sf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Dashboard.this, SpecialDashboard.class);
                startActivity(j);
                finish();
            }
        });

    }
}
