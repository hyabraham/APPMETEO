package com.example.student.myapplication.broadcasterReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by rome03 on 21/06/2016.
 */
public class AirplaneStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "switch mode" , Toast.LENGTH_LONG).show();
    }
}
