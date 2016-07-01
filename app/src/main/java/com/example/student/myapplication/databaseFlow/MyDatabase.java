package com.example.student.myapplication.databaseFlow;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by rome03 on 21/06/2016.
 */
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {
    public static final String NAME = "DatabaseLib";

    public static final int VERSION = 1;
}
