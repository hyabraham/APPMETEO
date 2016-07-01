package com.example.student.myapplication.databaseFlow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.student.myapplication.R;
import com.example.student.myapplication.database.User;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DBFlowActivity extends AppCompatActivity {

    @BindView(R.id.dbflow_login)
    EditText dbflow_login;

    @BindView(R.id.dbflow_pwd)
    EditText dbflow_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbflow);

        ButterKnife.bind(this);
    }

    public void dbflowSubscribe(View view){
        User2 user = new User2(dbflow_login.getText().toString(),dbflow_pwd.getText().toString());
        user.save();
        user.delete();


        List<User2> user2List = new Select().from(User2.class).queryList();
        for (User2 myUser : user2List ) {
            System.out.println(myUser);
            user.delete();
        }
    }
}
