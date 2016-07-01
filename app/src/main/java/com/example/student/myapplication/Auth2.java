package com.example.student.myapplication;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class Auth2 extends AppCompatActivity implements Observer {

    private LoginTask loginTask;

    EditText auth_password;
    EditText auth_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth2);
        auth_login = (EditText) findViewById(R.id.auth_login);
        auth_password = (EditText) findViewById(R.id.auth_password);
    }

    public void login(View view){
        loginTask = new LoginTask(auth_login.getText().toString(), auth_password.getText().toString());
        loginTask.addObserver(this);
        loginTask.login();
    }

    public void cancel(View view){
        View parentLayout = findViewById(android.R.id.content);
        Snackbar.make(parentLayout,"saisie Annulée", Snackbar.LENGTH_INDEFINITE)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setActionTextColor(Color.GREEN).show();
    }

    @Override
    public void update(Observable observable, Object data) {
        Toast.makeText(this, "Reception d'une connection" ,
                Toast.LENGTH_SHORT).show();
    }
}
