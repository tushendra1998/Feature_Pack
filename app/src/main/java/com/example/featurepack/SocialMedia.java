package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class SocialMedia extends AppCompatActivity {
    Button back;
    WebView w1;
    static String url=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
        back = findViewById(R.id.backWeb);
        w1 = findViewById(R.id.WebView);
        w1.loadUrl(url);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SocialMedia.this,FifthQuiz.class);
                startActivity(i);
                finish();
                url=null;
            }
        });
    }
}
