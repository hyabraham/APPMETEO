package com.example.student.myapplication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class Main3Activity extends AppCompatActivity {

    EditText editPassword;
    EditText editPassword2;
    EditText editLogin;
    Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("inscription");

        editLogin = (EditText) findViewById(R.id.inscr_edit_login);
        editPassword = (EditText) findViewById(R.id.inscr_edit_password);
        editPassword2 = (EditText) findViewById(R.id.inscr_edit_password2);
        button_login = (Button) findViewById(R.id.button_login);


        button_login.setClickable(false);

        editLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                checkState();
            }
        });

        editPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                checkState();
            }
        });

        editPassword2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                checkState();
            }
        });
    }


    public void inscription(View view){

        Log.d("testChamp","pw1 =" + editPassword.getText() + " & pw2 =" + editPassword2.getText());

        if(editPassword.getText().toString().equals(editPassword2.getText().toString())){
            Toast.makeText(this, "inscription de "+ editLogin.getText() +" avec le pwd "+ editPassword.getText() ,
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "les pwd sont !=" ,
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void checkState(){
        if( editLogin.getText().toString().trim().length() > 0 && editPassword.getText().toString().trim().length() > 0  && editPassword2.getText().toString().trim().length() > 0){
            Log.d("button","activated");
            button_login.setClickable(true);
            button_login .getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        }else{
            button_login.setClickable(false);
            Log.d("button","deactivated");
            button_login .getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }


}
