package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpecialDashboard extends AppCompatActivity {

    Button back;
    CardView quiz, music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_dashboard);

        back = findViewById(R.id.BackButton);
        quiz = findViewById(R.id.Quiz);
        music = findViewById(R.id.MMP);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(SpecialDashboard.this,MagicalPlayer.class);
                startActivity(k);
                finish();
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(SpecialDashboard.this,Quiz.class);
                startActivity(j);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SpecialDashboard.this, Dashboard.class);
                startActivity(i);
                finish();

            }
        });

    }

}
