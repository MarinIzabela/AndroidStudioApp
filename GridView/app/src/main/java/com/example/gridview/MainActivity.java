package com.example.gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1.setam numarul de coloane in xml, numColumns="3"
    GridView gridView;

    //2.cream un array pentru numele coloanelor
    ArrayList<String> text = new ArrayList<>();
    //3.cream un array pentru poze
    ArrayList<Integer> image = new ArrayList<>();

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

        gridView = findViewById(R.id.gridView);

        //6chemam metoda in oncreate
        fillArray();

        //7. cream Adapter class GridAdapter si importam si metodele

        //8. am creat un alt layout (click dreapta pe folderul layout new resource file apoi adaug nume gridview_Layout
        //9. am modificat sa fie LinearLayout
        //10.Am adaugat in xml android:orientation="vertical">
        //apoi in designer adaugam o imagine default,
        //la layot setam center horizontaly , padding 8dp
        //11. in clasa  grid view adapter setam context

        //17.Cream un obiect al adaptorului
        GridAdapter adapter = new GridAdapter(this, text, image);
        gridView.setAdapter(adapter);

        //18. Adaugam si un mesaj la click
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You selected: "+ text.get(position)
                ,Toast.LENGTH_SHORT).show();
            }
        });





    }


    //5.adaugam text + poza
    public void fillArray(){
        text.add("Bird");
        text.add("Cat");
        text.add("Dog");
        text.add("Monkey");
        text.add("Fish");
        text.add("Lion");
        text.add("Rabbit");
        text.add("Sheep");
        text.add("Chicken");

        image.add(R.drawable.pic1);
        image.add(R.drawable.pic2);
        image.add(R.drawable.pic3);
        image.add(R.drawable.pic4);
        image.add(R.drawable.pic5);
        image.add(R.drawable.pic6);
        image.add(R.drawable.pic7);
        image.add(R.drawable.pic8);
        image.add(R.drawable.pic9);


    }
}