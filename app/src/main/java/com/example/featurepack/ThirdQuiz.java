package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class ThirdQuiz extends AppCompatActivity {
    Button next;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_quiz);
        next = findViewById(R.id.inputNext);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        r4 = findViewById(R.id.radioButton4);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked())
                {
                    ++Quiz.score;
                }
                else
                {
                    --Quiz.score;
                }

                Intent i = new Intent(ThirdQuiz.this,ForthQuiz.class);
                startActivity(i);
                finish();
            }
        });
    }
}
