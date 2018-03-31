package com.example.pruebas.practicacertificado5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class agregar extends AppCompatActivity {

    Button buttonAceptar,buttonCancelar;
    DBHelper myDB;
    EditText idChart,nombreChart;
    NumberPicker numberPicker;
    String id,nombre,edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        myDB=new DBHelper(this);
        idChart=(EditText)findViewById(R.id.editTextAgregarId);
        nombreChart=(EditText)findViewById(R.id.editTextAgregarNombre);
        numberPicker = (NumberPicker)findViewById(R.id.numberPicker);
        buttonAceptar=(Button)findViewById(R.id.buttonAgregarAceptar);
        buttonCancelar=(Button)findViewById(R.id.buttonAgregaCancelar);

        numberPicker.setMinValue(5);
        numberPicker.setMaxValue(75);



        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id=idChart.getText().toString();
                nombre=nombreChart.getText().toString();
                edad = Integer.toString(numberPicker.getValue());

                myDB.insertar(id,nombre,edad);
                finish();
            }
        });


    }
}
