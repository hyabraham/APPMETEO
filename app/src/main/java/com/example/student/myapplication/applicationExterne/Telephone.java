package com.example.student.myapplication.applicationExterne;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.student.myapplication.R;

public class Telephone extends AppCompatActivity {

    EditText number;
    public final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 2456;
    private static String[] PERMISSIONS_CALL = {Manifest.permission.CALL_PHONE};
    private View parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone);
        number = (EditText) findViewById(R.id.telephone_num);
        parentLayout = findViewById(android.R.id.content);;
    }

    public void call(View view){

        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                &&
                ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            if
                    (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.CALL_PHONE)) {

                Snackbar.make(parentLayout, "request Permission",
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ActivityCompat.requestPermissions(Telephone.this,
                                        new String[]   {Manifest.permission.CALL_PHONE},
                                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
                            }
                        })
                        .show();
            } else {
                Snackbar.make(parentLayout, "request Permission ?",
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ActivityCompat.requestPermissions(Telephone.this,
                                        new String[]   {Manifest.permission.CALL_PHONE},
                                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
                            }
                        })
                        .show();
            }
        }else{
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number.getText().toString()));
            startActivity(intent);
        }
    }
}
