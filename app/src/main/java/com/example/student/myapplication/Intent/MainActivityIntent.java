package com.example.student.myapplication.Intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.myapplication.R;

public class MainActivityIntent extends AppCompatActivity {

    Button ok;
    EditText intent_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_intent);

        ok = (Button) findViewById(R.id.button_ok);
        intent_value = (EditText) findViewById(R.id.intent_value);
    }
    public void launchtItent(View view){
        Intent intent = new Intent(this, IntentActivity.class);
        intent.putExtra("text",intent_value.getText().toString());
        //startActivity(intent);
        startActivityForResult(intent,123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("retour","salut");
    }

}
