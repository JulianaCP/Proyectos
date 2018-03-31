package com.example.pruebas.practicacertificado4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class agregar extends AppCompatActivity {

    EditText id,nombre;
    DBHelper myDB;
    Button buttonAceptar;
    RadioButton radioButtonMujer,radioButtonHombre;
    String idVar,nombreVar,sexoVar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        myDB = new DBHelper(this);

        id = (EditText)findViewById(R.id.editTextAgregarId);
        nombre = (EditText)findViewById(R.id.editTextNombreAgregar);

        buttonAceptar=(Button)findViewById(R.id.buttonAgregar);
        radioButtonHombre=(RadioButton)findViewById(R.id.radioButtonHombre);
        radioButtonMujer=(RadioButton)findViewById(R.id.radioButtonMujer);



        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                idVar = id.getText().toString();
                nombreVar=nombre.getText().toString();
                if(radioButtonMujer.isChecked()){
                    sexoVar = "mujer";
                }
                else{
                    sexoVar = "hombre";
                }
                myDB.insertar(idVar,nombreVar,sexoVar);
                finish();
            }
        });

    }
}
