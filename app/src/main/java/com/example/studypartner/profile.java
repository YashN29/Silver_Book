package com.example.studypartner;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

public class profile extends Fragment {

    EditText show_fullname;
    TextView show_email;
    MaterialButton btn_update,btn_logout;

    String fullname;
    Cursor c;
    MyShared mysp;

    HashMap hm;
    MyDatabase mydb;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile,container,false);

        mysp = new MyShared(getContext());
        hm = mysp.getdata();
        fullname = (String) hm.get(MyShared.KEY_ID);
        show_fullname = v.findViewById(R.id.show_fullname);
        show_email = v.findViewById(R.id.show_email);
        btn_update = v.findViewById(R.id.btn_update);
        btn_logout = v.findViewById(R.id.btn_logout);

        mydb = new MyDatabase(getContext());
        c = mydb.getSpecificdatabyId(fullname);

        if(c.moveToNext())
        {
            show_fullname.setText(c.getString(1));
            show_email.setText(c.getString(2));
        }

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydb.updatedata(show_fullname.getText().toString(),fullname);
                Toast.makeText(getContext(), "Data Updated", Toast.LENGTH_SHORT).show();
            }
        });

        show_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Email Can't Be Update!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Logout Successfully", Toast.LENGTH_SHORT).show();
                mysp.cleardata();
                Intent i = new Intent(getContext(),LoginActivity.class);
                startActivity(i);
            }
        });

        return v;
    }
}