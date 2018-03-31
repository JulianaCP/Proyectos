package com.example.pruebas.practica3_lab_android;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {

    EditText codigo,marca,precio,descripcion;
    String codigoVar,marcaVar,precioVar,descripcionVar;
    BDHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        MyDB = new BDHelper(this);
        codigo = (EditText)findViewById(R.id.editTextCodigoAgregar);
        marca = (EditText)findViewById(R.id.editTextMarcaAgregar);
        precio = (EditText)findViewById(R.id.editTextPrecioAgregar);
        descripcion = (EditText)findViewById(R.id.editTextDescripcionAgregar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_secundario,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.opcion_salvar){
            codigoVar = codigo.getText().toString();
            marcaVar = marca.getText().toString();
            precioVar = precio.getText().toString();
            descripcionVar=descripcion.getText().toString();

            Cursor cursor = MyDB.getData(codigoVar);
            if(cursor.moveToFirst()){
                Toast.makeText(getApplicationContext(),"Repetido",Toast.LENGTH_LONG).show();
                if(!cursor.isClosed()){
                    cursor.close();
                }
            }
            else{
                MyDB.insertContact(codigoVar,marcaVar,precioVar,descripcionVar);
                finish();
            }

            return true;
        }
        else if(item.getItemId() == R.id.opcion_cancelar){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
