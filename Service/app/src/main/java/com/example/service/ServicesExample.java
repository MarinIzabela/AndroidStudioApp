package com.example.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.Provider;

public class ServicesExample extends IntentService {


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public ServicesExample() {
        super("name");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service", "Service is created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service", "Service is started");

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("service", "Service is stop");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("service", "On handle intent method worked");
    }
}
