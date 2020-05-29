package com.example.featurepack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText name,email,password,city,phone;
    Button register,loginback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.inputName);
        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        city = findViewById(R.id.inputCity);
        phone = findViewById(R.id.inputPhone);
        register = findViewById(R.id.signup);
        loginback = findViewById(R.id.inputlogin);

        loginback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signup.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = name.getText().toString();
                String s2 = email.getText().toString();
                String s3 = password.getText().toString();
                String s4 = city.getText().toString();
                String s5 = phone.getText().toString();

                if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals(""))
                {
                    Toast.makeText(Signup.this, "Please fill all field", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase database = openOrCreateDatabase("users",MODE_PRIVATE,null);
                    database.execSQL("CREATE TABLE IF NOT EXISTS usersData (name varchar,email varchar,password varchar,city varchar,phone varchar)");

                    String registerQuery = "SELECT * FROM usersData WHERE email = '"+s2+"'";
                    Cursor cursor = database.rawQuery(registerQuery,null);

                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(Signup.this, "User exists", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        database.execSQL("insert into usersData values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
                        Toast.makeText(Signup.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(Signup.this,MainActivity.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });

    }
}
