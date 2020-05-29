package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MagicalPlayer extends AppCompatActivity implements SensorEventListener {
    Button back;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magical_player);
        mp = MediaPlayer.create(this,R.raw.tum);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        s  = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        back = findViewById(R.id.button3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                Intent i = new Intent(MagicalPlayer.this,SpecialDashboard.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]>1)
        {
            mp.start();
        }
        else
        {
            mp.pause();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
