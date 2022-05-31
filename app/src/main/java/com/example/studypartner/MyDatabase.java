package com.example.studypartner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase(@Nullable Context context) {
        super(context, "mydb", null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table student (id integer primary key autoincrement , fullname varchar(20) , email varchar(20) , password varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public  void insertData(String fullname , String email , String password)
    {
        ContentValues cv = new ContentValues();
        cv.put("fullname",fullname);
        cv.put("email",email);
        cv.put("password",password);

        SQLiteDatabase sd = this.getWritableDatabase();

        sd.insert("student",null,cv);

        Log.d("mydata","Data Inserted!");
    }

    public Cursor getdata()
    {
        {
         SQLiteDatabase sd = this.getReadableDatabase();
         Cursor c = sd.rawQuery("select * from student" ,null);
         return c;
        }
    }

    public Cursor getSpecificdata(String email,String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from student where email=? and password=?", new String[]{email,password});
        return c;
    }

    public Cursor getSpecificdatabyId(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from student where email=?", new String[]{email});
        return c;
    }

    public void updatedata(String fullname ,String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("fullname",fullname);

        db.update("student",cv,"email=?",new String[]{email});
    }
}
