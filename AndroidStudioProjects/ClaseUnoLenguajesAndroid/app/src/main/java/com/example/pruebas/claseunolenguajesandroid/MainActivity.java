package com.example.pruebas.claseunolenguajesandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewResultado;

    Button buttonSumar;
    EditText editTextPrimerValor;
    EditText editTextSegundoValor;
    int valorUno;
    int valorDos;
    int resultado;

    Button cambiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSumar=(Button)findViewById(R.id.buttonSumar);
        editTextPrimerValor=(EditText)findViewById(R.id.editTextPrimerValor);
        editTextSegundoValor=(EditText)findViewById(R.id.editTextSegundoValor);

        textViewResultado=(TextView)findViewById(R.id.textViewResultado);


        cambiar=(Button)findViewById(R.id.cambiar);

        cambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ListViewActivity.class);
                startActivity(intent);
            }
        });

        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextPrimerValor.getText().toString().equals("") || editTextSegundoValor.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Datos incompletos",Toast.LENGTH_SHORT).show();
                }
                else{
                    try {
                        valorUno = Integer.parseInt(editTextPrimerValor.getText().toString());
                        valorDos=Integer.parseInt(editTextSegundoValor.getText().toString());
                        resultado = valorUno + valorDos;
                        textViewResultado.setText(Integer.toString(resultado));
                        //  Toast.makeText(getApplicationContext(),"Resultado: " + resultado,Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Error en datos.. ",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}


