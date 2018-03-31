package com.example.pruebas.practicaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editTextNombre;
    EditText editTextContraseña;
    Button buttonAceptar;


    String user = "AAA";
    String password = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextNombre=(EditText)findViewById(R.id.editTextNombre);

        editTextContraseña=(EditText)findViewById(R.id.editTextContraseña);

        buttonAceptar = (Button)findViewById(R.id.buttonAceptar);

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuarioLogin = editTextNombre.getText().toString();
                String contraseñaLogin = editTextContraseña.getText().toString();

                if(usuarioLogin.equals(user) && contraseñaLogin.equals(password)){
                    Intent ventanaNueva = new Intent(getApplicationContext(),ventanaVehiculos.class);
                    startActivity(ventanaNueva);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
