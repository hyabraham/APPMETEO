package com.example.student.myapplication.List_eleve;

/**
 * Created by Student on 17/06/2016.
 */
public class Single {
    private static Single ourInstance = new Single();

    public static Single getInstance() {
        return ourInstance;
    }

    private Single() {
    }
}
