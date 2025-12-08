package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;


public class MainActivity extends AppCompatActivity {

    ListView listView;

    //creez in string.xml un array cu ce dorim sa apara in listview. Acesta va fi definit ca mai jos de tipul String
    String country[];

    //pentru ListViw neaparat creat un adapter
    ArrayAdapter<String> adapter;

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

        listView= findViewById(R.id.listView);
        country =getResources().getStringArray(R.array.country);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,country);
        listView.setAdapter(adapter);
        // afisare mesaj pe ecran dupa ce dai click pe element
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country_name =parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"You selected => " + country_name,Toast.LENGTH_LONG).show();
            }
        });
    }
}