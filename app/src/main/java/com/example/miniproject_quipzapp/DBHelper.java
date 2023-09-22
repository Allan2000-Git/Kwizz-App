package com.example.miniproject_quipzapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{
    public DBHelper(Context context) {
        //Give the database name
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        //Creating tables
        myDB.execSQL("create Table users(username Text primary key, password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists users");
        onCreate(myDB);
    }

    public boolean insertData(String username,String password)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        //contentValues.put("mailadd",mailadd);
        contentValues.put("password",password);
        long result = myDB.insert("users",null,contentValues);

        if(result==-1)
        {
            return false;
        }
        else
        {
            //if registration successfull
            return true;
        }
    }

    public boolean checkUsername(String username)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?",new String[] {username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            //then we can register with that name
            return false;
        }
    }

    public boolean checkUsernamePassword(String username, String password)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?",new String[] {username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            //then we can register with that name
            return false;
        }
    }

}
