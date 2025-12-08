package com.example.dialogmessage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

        Button ok;
        TextView result;
        LinearLayout layout;


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


        ok = findViewById(R.id.buttonOk);
        result = findViewById(R.id.result);
        //layout = findViewById(R.id.layout);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogMessage();

            }
        });


    }

    private void showDialogMessage() {

        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete")
                .setMessage("Do you want to delete text?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.setText("");
                    }
                }).show();

        alertDialog.create();
    }
}