package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    VideoView video;
    MediaController media;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        video = findViewById(R.id.videoView);
        back = findViewById(R.id.button);
        media = new MediaController(this);

        video.setVideoPath("android.resource://"+getPackageName()+"/" +R.raw.song);
        media.setAnchorView(video);

        video.setMediaController(media);
        video.start();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VideoPlayer.this,Dashboard.class);
                startActivity(i);
                finish();
            }
        });
    }
}
