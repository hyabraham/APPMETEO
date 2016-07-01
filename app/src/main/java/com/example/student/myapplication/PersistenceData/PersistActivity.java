package com.example.student.myapplication.PersistenceData;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.myapplication.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersistActivity extends AppCompatActivity {

    @BindView(R.id.persist_text)
    EditText persist_text;

    @BindView(R.id.persist_button_save)
    Button persist_save;

    @BindView(R.id.persist_button_load)
    Button persist_load;

    @BindView(R.id.persist_button_delete)
    Button persist_delete;

    FileGestion fileGestion;


    public static final String FILE_NAME = "maFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persist);
        ButterKnife.bind(this);

        fileGestion = new FileGestion(this,FILE_NAME,true);
    }

    public void save(View view){
        try {
            fileGestion.saveToFile(persist_text.getText().toString());
        }catch (Exception ex){
            Log.d("Save",ex.getMessage());
        }
    }

    public void load(View view){
           try {
            persist_text.setText(fileGestion.readFromFile());
        } catch (Exception e) {
            Log.d("load","IOException");
            persist_text.setText("");
        }
    }

    public void delete(View view){
        boolean deleted = fileGestion.deleteFile();
        Log.d("delete","deleted? " + deleted);
    }
}
