package com.example.pruebas.clase3android_practica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText texviewUsuario;
    EditText textViewContraseña;
    Button buttonIngresar;

    String user = "ABC";
    String password = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        texviewUsuario = (EditText)findViewById(R.id.editTextUser);
        textViewContraseña=(EditText)findViewById(R.id.editTextPassword);

        buttonIngresar=(Button)findViewById(R.id.buttonIngresar);

        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String datoObtenidoUser = texviewUsuario.getText().toString();
                String datoObtenidoContraseña = textViewContraseña.getText().toString();
                if(datoObtenidoUser.equals(user) && datoObtenidoContraseña.equals(password)) {
                    Intent pasarVentana = new Intent(getApplicationContext(), ventanaVehiculos.class);

                    startActivity(pasarVentana);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Datos Incorrectos",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
