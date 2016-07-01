package com.example.student.myapplication.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.student.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DatabaseInscriptionActivity extends AppCompatActivity {

    DatabaseDAO dbdao;

    @BindView(R.id.database_login)
    EditText database_login;

    @BindView(R.id.database_pwd)
    EditText database_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_inscription);

        ButterKnife.bind(this);

        dbdao = new DatabaseDAO(this);
    }

    public void subscribeUser(View view){
        User user = new User(database_login.getText().toString(),database_pwd.getText().toString());
        long x = dbdao.addUser(user);
        System.out.println(x);
        User usr2 = dbdao.getUser((int)x);
        System.out.println(usr2);
    }
}
