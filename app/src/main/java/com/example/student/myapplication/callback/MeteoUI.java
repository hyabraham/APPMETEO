package com.example.student.myapplication.callback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.student.myapplication.R;

public class MeteoUI extends AppCompatActivity implements IDisplayable {

    MeteoRetrieverAsync retriever;
    TextView meteo_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo_ui);

        meteo_view = (TextView) findViewById(R.id.meteo_view2);

        retriever = new MeteoRetrieverAsync(this);
        retriever.execute("Paris");
    }

    @Override
    public void display(String str) {
        meteo_view.setText(str);
    }
}
