package com.example.pruebas.pruebas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    Button y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.editTextPP);


        nombre.setText("sddd");

        y = (Button)findViewById(R.id.buttonPPP);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss = nombre.getText().toString();
                Toast.makeText(getApplicationContext(),"mensaje",Toast.LENGTH_LONG).show();
            }
        });
    }
}
