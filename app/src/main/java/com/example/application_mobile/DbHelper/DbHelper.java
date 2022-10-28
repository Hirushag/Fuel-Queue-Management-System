package com.example.application_mobile.DbHelper;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.application_mobile.model.User;

public class DbHelper extends SQLiteOpenHelper{

    public static final String DBName = "login.db";

    public DbHelper(Context context) {

        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (id INTEGER primary key AUTOINCREMENT ,username TEXT,address TEXT , mobile TEXT , email TEXT,password TEXT,role TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users ");

    }

    public Boolean InsertData(String username ,String address ,String mobile ,String email, String password,String role){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username",username);
        values.put("address",address);
        values.put("password",password);
        values.put("mobile",mobile);
        values.put("email",email);
        values.put("password",password);
        values.put("role",role);

        long result = db.insert("users",null,values);
        if(result ==-1)return false;
        else
            return true;

    }

    public Boolean checkUsername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?",new String[] {username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUsernamePassword(String email,String password){

        System.out.println(email + password);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email =? and password=?"  ,new String[]{email,password});

        System.out.println(cursor);
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    @SuppressLint("Range")
    public User getUserData(String email){
        User user = new User();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email =?"  ,new String[]{email});

        if(cursor.moveToFirst()){
            System.out.println("OBJECTjjjjjjjjjjjjj====================");
            user.setName(cursor.getString(cursor.getColumnIndex("username")));
            user.setId(cursor.getString(cursor.getColumnIndex("id")));
            user.setRole(cursor.getString(cursor.getColumnIndex("role")));
            System.out.println(user);
            return user;
        }
        return user;
    }


}
