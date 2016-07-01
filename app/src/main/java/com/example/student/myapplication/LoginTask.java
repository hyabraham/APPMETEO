package com.example.student.myapplication;

import android.util.Log;

import java.util.Observable;


/**
 * Created by student on 16/06/2016.
 */
public class LoginTask extends Observable {
    private String id;
    private String password;

    public LoginTask(String id, String password){
        this.id = id;
        this.password = password;
    }

    public void login(){
        ///
        /// Logique de Connexion avec AsyncTask
        ///
        try {
            Thread.sleep(2000);
        }catch (Exception ex){}
        Log.d("dans Login","dans Login");
        setChanged();
        notifyObservers();
    }
}
