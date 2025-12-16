package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText userMessage;
    Button counter;

    CheckBox remember;

    int count = 0;
    String name;
    String message;
    boolean isChecked;

    SharedPreferences sharedPreferences;


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


        userName = findViewById(R.id.editTextText);
        userMessage = findViewById(R.id.editTextTextMultiLine);
        counter = findViewById(R.id.button);
        remember = findViewById(R.id.checkBox);


        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count+1;
                counter.setText(""+count);
            }
        });

        retrieveData();
    }


    @Override
    protected void onPause() {

        saveDate();
        super.onPause();
    }

    public void saveDate(){
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        name = userName.getText().toString();
        message = userMessage.getText().toString();
        if(remember.isChecked()){
            isChecked=true;
        }else{
            isChecked=false;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key name", name);
        editor.putString("key message" , message);
        editor.putInt(" key count", count);
        editor.putBoolean("key remember" , isChecked);
        editor.commit();
        Toast.makeText(getApplicationContext(), "Your data is saved!", Toast.LENGTH_LONG).show();

    }


    public void retrieveData(){
        sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE);
        name = sharedPreferences.getString("key name", null);
        message = sharedPreferences.getString("key message" , null);
        count = sharedPreferences.getInt("key count", 0);
        isChecked = sharedPreferences.getBoolean("key remember", false);

        userName.setText(name);
        userMessage.setText(message);
        counter.setText(""+count);

        if(isChecked){
            remember.setChecked(true);
        }else{
            remember.setChecked(false);
        }
    }
}