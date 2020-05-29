package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Calculator extends AppCompatActivity {
    EditText firstNumber,secondNumber;

    Button back,add,sub,multiply,divide;
    TextView result;
    TextToSpeech speech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        firstNumber = findViewById(R.id.inputNumber1);
        secondNumber = findViewById(R.id.inputNumber2);
        add = findViewById(R.id.addButton);
        sub= findViewById(R.id.subButton);
        multiply = findViewById(R.id.mulButton);
        divide = findViewById(R.id.divideButton);
        result = findViewById(R.id.viewResult);

        speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                speech.setLanguage(Locale.ENGLISH);
                speech.setSpeechRate(0.9f);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = firstNumber.getText().toString();
                String s2  = secondNumber.getText().toString();
                Float first = Float.parseFloat(s1);
                Float second = Float.parseFloat(s2);
                Float totel = first+second;
                String s3=Float.toString(totel);
                result.setText(s3);
                speech.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = firstNumber.getText().toString();
                String s2  = secondNumber.getText().toString();
                Float first = Float.parseFloat(s1);
                Float second = Float.parseFloat(s2);
                Float totel = first-second;
                String s3=Float.toString(totel);
                result.setText(s3);
                speech.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = firstNumber.getText().toString();
                String s2  = secondNumber.getText().toString();
                Float first = Float.parseFloat(s1);
                Float second = Float.parseFloat(s2);
                Float totel = first*second;
                String s3=Float.toString(totel);
                result.setText(s3);
                speech.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = firstNumber.getText().toString();
                String s2  = secondNumber.getText().toString();
                Float first = Float.parseFloat(s1);
                Float second = Float.parseFloat(s2);
                Float totel = first/second;
                String s3=Float.toString(totel);
                result.setText(s3);
                speech.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        back = findViewById(R.id.againBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Calculator.this,Dashboard.class);
                startActivity(i);
                finish();
            }
        });
    }
}
