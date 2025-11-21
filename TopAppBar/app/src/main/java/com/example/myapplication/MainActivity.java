package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

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

        toolbar = findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(AppCompatResources.getDrawable(this, R.drawable.outline_more_vert_24));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Navigation Icon is clicked", Toast.LENGTH_SHORT).show();
            }
        });


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.share){
                    Toast.makeText(getApplicationContext(), "Share Icon is clicked", Toast.LENGTH_SHORT).show();
                }else if (item.getItemId()==R.id.edit){
                    Toast.makeText(getApplicationContext(), "EDIT Icon is clicked", Toast.LENGTH_SHORT).show();
                }else if (item.getItemId()==R.id.settings){
                    Toast.makeText(getApplicationContext(), "Settings Icon is clicked", Toast.LENGTH_SHORT).show();
                }else if (item.getItemId()==R.id.signOut){
                    Toast.makeText(getApplicationContext(), "SignOut Icon is clicked", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }
}