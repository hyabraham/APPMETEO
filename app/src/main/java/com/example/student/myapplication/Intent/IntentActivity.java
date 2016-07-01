package com.example.student.myapplication.Intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.myapplication.R;

public class IntentActivity extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        textview = (TextView) findViewById(R.id.intent_text);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        textview.setText(text);

        // Bundle extra = this.getIntent().getExtra();
        // String data = extra.getString();

        Log.d("valeur du text recu",text);
    }
}
