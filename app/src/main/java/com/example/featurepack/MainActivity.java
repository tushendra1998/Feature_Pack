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

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.inputEmail);
        password = (EditText)findViewById(R.id.inputPassword);
        login = (Button)findViewById(R.id.loginButton);
        register = (Button)findViewById(R.id.signupbtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Signup.class);
                startActivity(i);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = email.getText().toString();
                String s2 = password.getText().toString();

                if(s1.equals("") || s2.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please fii all field", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase database = openOrCreateDatabase("users",MODE_PRIVATE,null);
                    String logQuery = "SELECT * FROM usersData WHERE email= '"+s1+"' AND password= '"+s2+"'";
                    Cursor cursor = database.rawQuery(logQuery,null);

                    if(cursor.getCount()>0){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent k  = new Intent(MainActivity.this,Dashboard.class);
                        startActivity(k);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Incorrect email and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
