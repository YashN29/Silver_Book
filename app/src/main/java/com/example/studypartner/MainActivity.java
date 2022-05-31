package com.example.studypartner;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton btn;
    EditText ed_fullname,ed_emailid,ed_password;
    ImageView eye;
    int count = 0;

    MyDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_fullname = findViewById(R.id.ed_fullname);
        ed_emailid  = findViewById(R.id.ed_emailid);
        ed_password = findViewById(R.id.ed_password);
        btn = findViewById(R.id.btn);
        eye = findViewById(R.id.eye);

        database = new MyDatabase(MainActivity.this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ed_fullname.getText().toString().length() <= 6)
                {
                    ed_fullname.setError("Full Name Must be Greater Than 6 Characters!");
                }
                else if (ed_password.getText().toString().length() <= 7)
                {
                    ed_password.setError("Password Must Contain At-least 7 Characters or Numbers");
                }

                else
                    {
                        database.insertData(ed_fullname.getText().toString(),ed_emailid.getText().toString(),ed_password.getText().toString());
                        Intent i = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(i);
                        ed_fullname.getText().clear(); ed_emailid.getText().clear(); ed_password.getText().clear();
                        Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                if (count % 2==0)
                {
                    ed_password.setTransformationMethod(null);
                }
                else
                    {
                        ed_password.setTransformationMethod(new PasswordTransformationMethod());
                    }
            }
        });

    }
}