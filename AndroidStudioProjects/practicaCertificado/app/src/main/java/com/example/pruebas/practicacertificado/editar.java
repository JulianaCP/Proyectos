package com.example.pruebas.practicacertificado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editar extends AppCompatActivity {

    EditText placa,modelo,color;
    Bundle bundle;
    String opcionSeleccionada;

    String placaC,modeloC,colorC;
    BDHelper myDB;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        placa = (EditText)findViewById(R.id.editTextPlaca);
        modelo = (EditText)findViewById(R.id.editTextModelo);
        color = (EditText)findViewById(R.id.editTextColor);

        myDB = new BDHelper(this);
        bundle = getIntent().getExtras();
        opcionSeleccionada = bundle.getString("placa");


        placa.setText(Global.listaVehiculos.get(Integer.parseInt(opcionSeleccionada)).getPlaca());
        modelo.setText(Global.listaVehiculos.get(Integer.parseInt(opcionSeleccionada)).getModelo());
        color.setText(Global.listaVehiculos.get(Integer.parseInt(opcionSeleccionada)).getColor());

        button=(Button)findViewById(R.id.buttonAceptar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placaC = placa.getText().toString();
                modeloC=modelo.getText().toString();
                colorC=color.getText().toString();
                opcionSeleccionada = Global.listaVehiculos.get(Integer.parseInt(opcionSeleccionada)).getPlaca();
                myDB.editar(opcionSeleccionada,placaC,modeloC,colorC);
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_editar_cancelar){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
