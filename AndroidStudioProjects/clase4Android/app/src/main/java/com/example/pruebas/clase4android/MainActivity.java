package com.example.pruebas.clase4android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button buttonEnviar;
    EditText editTextNumeroSalario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextNumeroSalario=(EditText)findViewById(R.id.editTextSalario);
        buttonEnviar=(Button)findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ventana = new Intent(getApplicationContext(),ventanaMostrar.class);


                Bundle guardar = new Bundle();
                guardar.putString("numero",editTextNumeroSalario.getText().toString());
                ventana.putExtras(guardar);
                startActivity(ventana);
            }
        });

    }
}
