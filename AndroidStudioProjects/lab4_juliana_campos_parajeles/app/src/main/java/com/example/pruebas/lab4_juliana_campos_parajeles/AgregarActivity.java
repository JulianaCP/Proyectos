package com.example.pruebas.lab4_juliana_campos_parajeles;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {

    EditText placa,modelo,marca;
    String placaVar,modeloVar,marcaVar;
    BDHelper MyDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        placa = (EditText)findViewById(R.id.editTextPlaca);
        modelo= (EditText)findViewById(R.id.editTextModelo);
        marca= (EditText)findViewById(R.id.editTextMarca);
        MyDB = new BDHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_agregar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.opcion_guardar){
            agregar();
        }
        else if(item.getItemId() == R.id.opcion_cancelar){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void agregar(){
        placaVar = placa.getText().toString();
        modeloVar = modelo.getText().toString();
        marcaVar = marca.getText().toString();
        if(placaVar.equals("") || modeloVar.equals("") || marcaVar.equals("")){
            Toast.makeText(getApplicationContext(),"Faltan datos",Toast.LENGTH_LONG).show();
        }
        else{
            MyDB.insertContact(placaVar,modeloVar,marcaVar);
            finish();
        }
    }
}
