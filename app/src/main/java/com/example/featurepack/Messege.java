package com.example.featurepack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Messege extends AppCompatActivity {
    Button back;
    EditText phone,Messege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messege);
        phone = findViewById(R.id.inputNumber);
        Messege = findViewById(R.id.inputMessege);
        back = findViewById(R.id.backMess);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Messege.this,Dashboard.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void btn_send(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS);
        if(permissionCheck == PackageManager.PERMISSION_GRANTED)
        {
            MyMessege();
        }
        else
        {
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SEND_SMS},0);
        }
    }

    private void MyMessege() {
        String s1 = phone.getText().toString().trim();
        String s2 = Messege.getText().toString().trim();
        if(!s1.equals("") || !s2.equals(""))
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(s1,null,s2,null,null);

            Toast.makeText(this, "Messege Sent", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode)
        {
            case 0:
            {
                if(grantResults.length>=0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    MyMessege();
                }

                else
                {
                    Toast.makeText(this, "You don't have permission", Toast.LENGTH_SHORT).show();
                }

                break;
            }

        }
    }
}
