package com.example.applicationlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button1;
    Button button2;

    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter+1;
                textView.setText(""+ counter);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent este pentru a deschide SecondActivity
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(i);
            }
        });

        Log.d("Message", "First Activity onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Message", "First Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message", "First Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Message", "First Activity onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Message", "First Activity onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message", "First Activity onDrstroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Message", "First Activity onRestart");
    }
}