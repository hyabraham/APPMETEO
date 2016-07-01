package com.example.student.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 21/06/2016.
 */
public class DatabaseDAO implements IUserDAO {

    DatabaseManager dbManager;
    Context context;

    public static final String TABLE_USER ="USERS";
    public static final String KEY_USER_ID = "ID";
    public static final String KEY_USER_LOGIN = "LOGIN";
    public static final String KEY_USER_PWD = "PWD";




    public static java.lang.String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS "+
                    TABLE_USER + " ("
                        + KEY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                        + KEY_USER_LOGIN + " text UNIQUE,"
                        + KEY_USER_PWD + " text"
                        +  " )";


    public static final java.lang.String UPDATE_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;



    public DatabaseDAO(Context context) {
        this.context = context;
        this.dbManager = new DatabaseManager(context);
    }




    @Override
    public long addUser(User user) {
        SQLiteDatabase db = dbManager.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_LOGIN, user.getLogin());
        values.put(KEY_USER_PWD, user.getPwd());

        long entry = db.insert(TABLE_USER, null, values);

        db.close();

        return entry;
    }

    @Override
    public User getUser(int id) {
        SQLiteDatabase db = dbManager.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, new String[] { KEY_USER_ID,
                        KEY_USER_LOGIN, KEY_USER_PWD }, KEY_USER_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(
                cursor.getString(1),
                cursor.getString(2)
                );

        cursor.close();
        db.close();

        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<User>();

        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = dbManager.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User contact = new User();
                contact.setLogin(cursor.getString(1));
                contact.setPwd(cursor.getString(1));

                userList.add(contact);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return userList;

    }

    @Override
    public void deleteUser(int id) {
        SQLiteDatabase db = dbManager.getWritableDatabase();
        db.delete(TABLE_USER, KEY_USER_ID + " = ?",
                new String[] {  String.valueOf(id) });
        db.close();
    }

    @Override
    public int updateUser(User user) {
        SQLiteDatabase db = dbManager.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, user.getLogin());
        values.put(KEY_USER_PWD, user.getPwd());

        return db.update(TABLE_USER, values, KEY_USER_LOGIN + " = ?",
                new String[] { user.getLogin() });
    }
}
