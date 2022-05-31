package com.example.studypartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    TextView tv_reg;
    EditText email,password;
    MaterialButton btn_login;
    ImageView eye;
    int count = 0;

    MyDatabase myDatabase;
    Cursor c;

    MyShared mysp;
    HashMap hm;
    Boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_reg = findViewById(R.id.tv_reg);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        eye = findViewById(R.id.eye);

        myDatabase = new MyDatabase(LoginActivity.this);

        mysp = new MyShared(LoginActivity.this);

        hm = mysp.checkLogin();
        status = (Boolean) hm.get("status");

        if(status)
        {
            Intent i = new Intent(LoginActivity.this,Dashboard.class);
            Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(i);
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c= myDatabase.getSpecificdata(email.getText().toString(),password.getText().toString());
                Log.d("mydata","data"+c.getCount());
                if (c.moveToNext())
                {
                    Log.d("mydata","name="+c.getString(1));
                    Intent i = new Intent(LoginActivity.this,Dashboard.class);
                    mysp.setPreference(c.getString(2).toString());
                    mysp.Isloggin(true);
                    Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Invalid Login!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                if (count % 2==0)
                {
                    password.setTransformationMethod(null);
                }
                else
                {
                    password.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        tv_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(j);
            }
        });
    }
}