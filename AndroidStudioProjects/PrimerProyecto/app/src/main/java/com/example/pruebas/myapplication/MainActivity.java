package com.example.pruebas.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonContinuar;
    EditText editTextPersona;
    EditText editTextContraseña;

    String User = "ABC";
    String Password = "5050";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonContinuar = (Button) findViewById(R.id.buttonContinuar);

        editTextPersona = (EditText)findViewById(R.id.editTextPersona);
        editTextContraseña =(EditText)findViewById(R.id.editTextContraseña);
        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
