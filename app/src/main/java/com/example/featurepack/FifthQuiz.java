package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FifthQuiz extends AppCompatActivity {
    Button back;
    TextView t1;
    Button facebook,twitter,netcamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_quiz);
        facebook = findViewById(R.id.face);
        twitter = findViewById(R.id.twit);
        netcamp = findViewById(R.id.camp);
        back = findViewById(R.id.button2);
        t1 = findViewById(R.id.textView6);
        t1.setText("Your Score is " +Quiz.score);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FifthQuiz.this,SpecialDashboard.class);
                startActivity(i);
                finish();
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = "https://www.facebook.com";
                SocialMedia.url = s1;
                Intent a = new Intent(FifthQuiz.this,SocialMedia.class);
                startActivity(a);
                finish();
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s2 = "https://www.twitter.com";
                SocialMedia.url = s2;
                Intent b = new Intent(FifthQuiz.this,SocialMedia.class);
                startActivity(b);
                finish();
            }
        });

        netcamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s3 = "https://www.netcamp.in";
                SocialMedia.url = s3;
                Intent c = new Intent(FifthQuiz.this,SocialMedia.class);
                startActivity(c);
                finish();
            }
        });
    }
}
