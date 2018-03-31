package com.example.pruebas.segundoproyecto;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button go;
    EditText nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre=(EditText)findViewById(R.id.name);
        go=(Button)findViewById(R.id.buttonNext);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                   //segundo nombre de la ventana a ir

                Intent nuevaClase = new Intent(getApplicationContext(),segundo.class); //pasar de una clase a otra

                Bundle bolsa = new Bundle();//crea clase para meterle informacion
                bolsa.putString("clave",nombre.getText().toString());//intorducir datos
                nuevaClase.putExtras(bolsa); //le mete los stributos


                startActivity(nuevaClase);//llama a la otra ventana y envia datos
            }
        });
    }
}
