package com.example.student.myapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editLogin;
    EditText editPassword;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editLogin = (EditText) findViewById(R.id.edit_login);
        editPassword = (EditText) findViewById(R.id.edit_password);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void login(View view){

        Toast.makeText(this, "Connection avec id ="+ editLogin.getText() + " et pwd = "+ editPassword.getText() + ")" ,
                Toast.LENGTH_SHORT).show();
        Log.d("debug","Connection avec id ="+ editLogin.getText() + " et pwd = "+ editPassword.getText() + ")");
    }
}
