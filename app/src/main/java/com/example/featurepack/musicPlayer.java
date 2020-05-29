package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class musicPlayer extends AppCompatActivity {
    Button play,pause,back;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        play = findViewById(R.id.inputPlay);
        pause = findViewById(R.id.inputPause);
        back = findViewById(R.id.inputback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                Intent i = new Intent(musicPlayer.this,Dashboard.class);
                startActivity(i);
                finish();
            }
        });
        mp = MediaPlayer.create(this,R.raw.tum);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
    }
}
