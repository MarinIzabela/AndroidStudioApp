package com.example.applicationlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =   new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });


        Log.d("Message", "Second Activity onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Message", "Second Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message", "Second Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Message", "Second Activity onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Message", "Second Activity onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message", "Second Activity onDrstroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Message", "Second Activity onRestart");
    }


}