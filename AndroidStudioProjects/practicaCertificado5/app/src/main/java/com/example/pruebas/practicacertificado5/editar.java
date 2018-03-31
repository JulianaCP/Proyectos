package com.example.pruebas.practicacertificado5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.ArrayList;

public class editar extends AppCompatActivity {

    Button buttonAceptar,buttonCancelar;
    DBHelper myDB;
    EditText idChart,nombreChart;
    NumberPicker numberPicker;
    String id,nombre,edad,posicionSubI,idOld;
    ArrayList<Persona> lista = new ArrayList<>();
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        myDB=new DBHelper(this);
        idChart=(EditText)findViewById(R.id.editTextEditarId);
        nombreChart=(EditText)findViewById(R.id.editTextEditarNombre);
        numberPicker = (NumberPicker)findViewById(R.id.numberPickerEditar);
        buttonAceptar=(Button)findViewById(R.id.buttonEditarAceptar);
        buttonCancelar=(Button)findViewById(R.id.buttonEditarCancelar);

        numberPicker.setMinValue(5);
        numberPicker.setMaxValue(75);

        lista = myDB.getInfo();

        bundle=getIntent().getExtras();
        posicionSubI = bundle.getString("pos");

        idChart.setText(lista.get(Integer.parseInt(posicionSubI)).getId());
        nombreChart.setText(lista.get(Integer.parseInt(posicionSubI)).getNombre());
        edad = lista.get(Integer.parseInt(posicionSubI)).getEdad();
        idOld = lista.get(Integer.parseInt(posicionSubI)).getId();

        numberPicker.setValue(Integer.parseInt(edad));

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
                myDB.editar(idOld,id,nombre,edad);
                finish();
            }
        });
    }
}
