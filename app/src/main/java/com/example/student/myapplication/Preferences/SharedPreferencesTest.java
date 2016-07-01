package com.example.student.myapplication.Preferences;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.content.SharedPreferences;

import com.example.student.myapplication.PersistenceData.FileGestion;
import com.example.student.myapplication.R;

public class SharedPreferencesTest extends AppCompatActivity {

    EditText pref_mail;
    EditText pref_password;
    CheckBox pref_check;

    SharedPreferences sharedpreferences;

    FileGestion fileGestion;

    public static final String PREF_LOGIN_USER = "PrefLoginUser" ;
    public static final String USER_LOGIN = "user_login";
    public static final String USER_PASSWORD = "user_password";
    public static final String USER_REMEMBER = "user_remember";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        pref_mail = (EditText) findViewById(R.id.pref_mail);
        pref_password = (EditText) findViewById(R.id.pref_password);
        pref_check = (CheckBox) findViewById(R.id.pref_check);

        sharedpreferences = getSharedPreferences(PREF_LOGIN_USER, Context.MODE_PRIVATE);

        fileGestion = new FileGestion(this,"User_login",false);

    }

    public void shareLogin(View view){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_LOGIN, pref_mail.getText().toString());
        editor.putString(USER_PASSWORD, pref_password.getText().toString());
        editor.putBoolean(USER_REMEMBER, pref_check.isChecked());
        editor.commit();

        StringBuilder sb = new StringBuilder();
        sb.append(USER_LOGIN+"="+pref_mail.getText().toString()+"\n");
        sb.append(USER_PASSWORD+"="+pref_password.getText().toString()+"\n");
        sb.append(USER_REMEMBER+"="+pref_mail.getText().toString()+"\n");


        try {
            fileGestion.saveToFile(
                sb.toString()
            );
        }catch (Exception ex){

        }
    }

    public void restoreLogin(View view){
        pref_mail.setText(sharedpreferences.getString(USER_LOGIN, ""));
        pref_password.setText(sharedpreferences.getString(USER_PASSWORD, ""));
        pref_check.setChecked(sharedpreferences.getBoolean(USER_REMEMBER, false));
    }

    public void logFromFile(View view){

    }
}
