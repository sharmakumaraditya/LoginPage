package com.example.adityakumarsharma.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by Aditya on 7/26/2017.
 */

public class Database_Help extends SQLiteOpenHelper {
    public static final String database_name = "login_page.db";
    public static final String table_name = "REGISTER";
    public static final String col_1 = "ID";
    public static final String col_2 = "NAME";
    public static final String col_3 = "USER_NAME";
    public static final String col_4 = "PASSWORD";
    SQLiteDatabase db;

    public Database_Help(Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + table_name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT , USER_NAME VARCHAR2 (20) , PASSWORD VARCHAR2 (20)) ");
        ContentValues cv = new ContentValues();
        cv.put(col_2, "abc");
        cv.put(col_3, "user");
        cv.put(col_4, "qwerty");
        db.insert(table_name, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean insertData(String name, String username, String passw)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_2, name);
        cv.put(col_3, username);
        cv.put(col_4, passw);
        long result = db.insert(table_name, null, cv);
        if (result == -1)
            return false;
        else
            return true;


    }

    public String list(String username)
    {
        db= this.getReadableDatabase();
        Cursor cr=db.rawQuery("select "+col_3+","+ col_4+"  from "+ table_name,null);
        String a,b;
        b="not found";
        if (cr.moveToFirst())
        {
            do{
                a= cr.getString(0);
                if (a.equals(username))
                {
                    b=cr.getString(1);
                    break;

                }
            }while (cr.moveToNext());

        }
        return b;
    }
   /* public Cursor listed() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from"+table_name,null);
        return res;*/}