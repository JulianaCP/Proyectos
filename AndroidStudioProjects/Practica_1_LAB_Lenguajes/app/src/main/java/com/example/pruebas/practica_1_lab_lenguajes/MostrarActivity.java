package com.example.pruebas.practica_1_lab_lenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarActivity extends AppCompatActivity {

    String[]opciones={"poblacion","nombre","descripcion"};
    ArrayAdapter<String> adapter;
    Spinner spinner;
    String dato;
    int posicion;

    TextView informacion;
    Button buttonAceptar,buttonCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        informacion=(TextView)findViewById(R.id.textViewInformacion);
        buttonAceptar=(Button)findViewById(R.id.buttonAceptar);
        buttonCancelar=(Button)findViewById(R.id.buttonCancelar);
        Bundle bundle = getIntent().getExtras();
        posicion = Integer.parseInt(bundle.getString("posicion"));
        spinner=(Spinner)findViewById(R.id.spinner);


        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Global.selecciono = adapterView.getItemAtPosition(i).toString();
                if (Global.selecciono.equals("poblacion")) {
                    dato = Global.lista.get(posicion).getPoblacion();
                    informacion.setText(dato);
                } else if (Global.selecciono.equals("nombre")) {
                    dato = Global.lista.get(posicion).getNombre();
                    informacion.setText(dato);
                } else {
                    dato = Global.lista.get(posicion).getDescripcion();
                    informacion.setText(dato);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"presiono cancelar",Toast.LENGTH_LONG).show();
            }
        });
        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
