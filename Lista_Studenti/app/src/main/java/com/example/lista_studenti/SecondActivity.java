package com.example.lista_studenti;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    TextView textView1 ;
    TextView textView2 ;
    TextView textView3 ;

    TextView facultate;

    Spinner spinner;
    TextView fi;

    RadioGroup radioGroup;
    RadioButton radioButtonIF;
    RadioButton radioButtonID;

    Button buttonAS;

    public static final String ADD_STUDENT = "addStudent";

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

        Intent intent = getIntent();

        textView1=findViewById(R.id.editTextNume);
        textView2=findViewById(R.id.editTextData);
        textView3 = findViewById(R.id.editTextMedia);
        facultate=findViewById(R.id.textViewFaculate);
        radioGroup = findViewById(R.id.radioGrup);
        radioButtonIF = findViewById(R.id.radioButtonIF);
        radioButtonID = findViewById(R.id.radioButtonID);
        buttonAS = findViewById(R.id.buttonAS);
        spinner = findViewById(R.id.spinner);
        String[] facultati = {"CSIE", "REI", "FABIZ", "MRK"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, facultati);
        spinner.setAdapter(adapter);



        buttonAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView1.getText().toString().isEmpty())
                    textView1.setError("Introduceti numele studentului");
                else if (textView2.getText().toString().isEmpty())
                    textView2.setError("Introduceti data nasterii!");
                else if (textView3.getText().toString().isEmpty())
                    textView3.setError("Introduceti media!");
                else{
                    //Creează un “parser” care se așteaptă ca data să fie de forma:
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
                    sdf.setLenient(false);
                    try{
                        //Încerci să parsezi data introdusă. Dacă formatul nu e corect, aruncă ParseException și sari în catch.
                        String dataText = textView2.getText().toString().trim();
                        Date dataNasterii = sdf.parse(dataText);

                        String nume = textView1.getText().toString();
                        float medie = Float.parseFloat(textView3.getText().toString());
                        String facultate = spinner.getSelectedItem().toString();
                        int checkedId = radioGroup.getCheckedRadioButtonId();
                        if (checkedId == -1) {
                            Toast.makeText(getApplicationContext(),
                                    "Selecteaza forma de invatamant (IF/ID)!",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }

                        RadioButton radioButton = findViewById(checkedId);
                        String formaInvatamant = radioButton.getText().toString();
                        Student student = new Student(nume, dataNasterii, medie,facultate, formaInvatamant);
                        //Atașezi studentul la un Intent sub cheia ADD_STUDENT
                        intent.putExtra(ADD_STUDENT, student);
                        //Spui: „SecondActivity s-a terminat cu succes și acesta este rezultatul”.
                        setResult(RESULT_OK, intent);
                        //Închide ecranul curent și te întorci la MainActivity
                        finish();


                    }catch (ParseException e){
                        textView2.setError("Data invalida. Format: MM/dd/yyyy");
                        Toast.makeText(getApplicationContext(), "Data invalida", Toast.LENGTH_LONG).show();

                    }catch(Exception ex){

                        Log.e("Second activity", "eroare la introducere student");
                        Toast.makeText(getApplicationContext(), "Eroare introducere date", Toast.LENGTH_LONG).show();
                    }






                }

            }
        });


    }
}