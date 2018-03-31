package com.example.pruebas.practicacertificado2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class agregar extends AppCompatActivity {

    RadioButton radioButtonMujer,radioButtonHombre;
    EditText id,nombre;
    Button buttonAgregar;
    String idString,nombreString,sexoString;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        radioButtonMujer=(RadioButton)findViewById(R.id.radioButtonMujer);
        radioButtonHombre=(RadioButton)findViewById(R.id.radioButtonHombre);
        id=(EditText)findViewById(R.id.editTextAgregarId);
        nombre=(EditText)findViewById(R.id.editTextAgregarNombre);
        buttonAgregar=(Button)findViewById(R.id.buttonAgregarAceptar);
        myDB=new DBHelper(this);

        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButtonMujer.isChecked()){
                    sexoString="mujer";
                }
                else{
                    sexoString="hombre";
                }
                idString=id.getText().toString();
                nombreString = nombre.getText().toString();
                myDB.insertar(idString,nombreString,sexoString);
                finish();
            }
        });
    }
}
