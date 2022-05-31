package com.example.studypartner;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class MyShared {

    Context context;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    public static final String KEY_ID = "id";

    public MyShared(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("mypref",context.MODE_PRIVATE);
    }

    public void setPreference(String value)
    {
        editor = sp.edit();
        editor.putString(KEY_ID,value);
        editor.commit();
    }

    public void Isloggin(Boolean status)
    {
        editor = sp.edit();
        editor.putBoolean("status",status);
        editor.commit();
    }

    public HashMap<Boolean,Boolean> checkLogin()
    {
        HashMap hm=new HashMap();
        hm.put("status",sp.getBoolean("status",false));
        return  hm;

    }

    public HashMap<String , String> getdata()
    {
        HashMap hm = new HashMap();

        hm.put(KEY_ID,sp.getString(KEY_ID,"DEFAULT"));
        return hm;
    }

    public void cleardata()
    {
        editor = sp.edit();
        editor.clear();
        editor.commit();
    }
}
