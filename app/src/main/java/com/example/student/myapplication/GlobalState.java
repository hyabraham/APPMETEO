package com.example.student.myapplication;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by student on 16/06/2016.
 */
public class GlobalState extends Application {
    private String maVar="salut";

    public String getMaVar() {
        return maVar;
    }

    public void setMaVar(String maVar) {
        this.maVar = maVar;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
