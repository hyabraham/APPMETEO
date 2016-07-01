package com.example.student.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Student on 21/06/2016.
 */
public class DatabaseManager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="myDBNmae.db";
    public static final int DB_VERSION = 1;



    public DatabaseManager(Context context) {
        super(context,DATABASE_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseDAO.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseDAO.UPDATE_TABLE);
        onCreate(db);
    }
}
