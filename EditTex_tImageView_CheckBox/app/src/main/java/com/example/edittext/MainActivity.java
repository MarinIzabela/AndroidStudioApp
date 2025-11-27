package com.example.edittext;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button ok;
    TextView result;
    String userName; // variable to save the user input

    ImageView image;

    CheckBox male;
    CheckBox female;

    RadioGroup radioGroup;
    RadioButton green;
    RadioButton red;
    RadioButton yellow;

    LinearLayout layout; // added for RadioButton to change background color

    ToggleButton toggleButton;

    Spinner spinner;
    ArrayAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.linear), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name=findViewById(R.id.editText);
        ok=findViewById(R.id.buttonOk);
        result = findViewById(R.id.textViewResult);
        image = findViewById(R.id.imageExample);
        male= findViewById(R.id.checkBoxMale);
        female = findViewById(R.id.checkBoxFemale);
        radioGroup =findViewById(R.id.group);
        green = findViewById(R.id.radioButtonGreen);
        red = findViewById(R.id.radioButtonRed);
        yellow = findViewById(R.id.radioButtonYellow);
        layout=findViewById(R.id.linear);
        toggleButton = findViewById(R.id.toggleButtonShow);
        spinner = findViewById(R.id.spinnerCountry);
        adapter = ArrayAdapter.createFromResource(this,R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);//assign spinner to the adaptor

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"This is a toast message!!",Toast.LENGTH_LONG).show();
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//checkBox
                if (male.isChecked()){
                    result.setText("Male");
                    female.setChecked(false);
                }else{
                    result.setText("What is your gender?");
                }
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//checkBox
                if (female.isChecked()){
                    result.setText("Female");
                    male.setChecked(false);
                }else{
                    result.setText("What is your gender?");
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //userName = name.getText().toString();//take the user input textView
                //result.setText(userName);//we display on the textView

                //image.setImageResource(R.drawable.b);//image to change

                if (green.isChecked()) {//radioButton
                    layout.setBackgroundColor(Color.GREEN);
                } else if (red.isChecked()) {
                    layout.setBackgroundColor(Color.RED);
                } else if (yellow.isChecked()) {
                    layout.setBackgroundColor(Color.YELLOW);
                }
                // Toast message
               // Toast.makeText(getApplicationContext(),"This is a toast message!!",Toast.LENGTH_LONG).show();
                //SnackBarMessge
                Snackbar.make(layout, "This is a SnackBar message!" , Snackbar.LENGTH_INDEFINITE).setAction(" Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    image.setVisibility(View.INVISIBLE);
                    result.setText("Image is hidden");
                }else{
                    image.setVisibility(View.VISIBLE);
                    result.setText("Image is visible");
                }

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                result.setText(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}