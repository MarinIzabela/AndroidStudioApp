package com.example.broadastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcasExample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        boolean isPlaneMode = intent.getBooleanExtra("state", false);

        if(isPlaneMode==true){
            Toast.makeText(context,"Device is in airplain mode", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context,"Device is not in airplain mode", Toast.LENGTH_LONG).show();
        }


    }
}
