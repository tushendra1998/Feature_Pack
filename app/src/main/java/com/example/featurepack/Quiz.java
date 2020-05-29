package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {
    Button back,next;
    RadioButton r1,r2;
    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        next = findViewById(R.id.inputNext);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                if(r2.isChecked())
                {
                    ++score;
                }
                else
                {
                    --score;
                }
                Intent j = new Intent(Quiz.this,SecondQuiz.class);
                startActivity(j);
                finish();
            }
        });
        back = findViewById(R.id.backQuiz);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Quiz.this,SpecialDashboard.class);
                startActivity(i);
                finish();
            }
        });
    }
}
