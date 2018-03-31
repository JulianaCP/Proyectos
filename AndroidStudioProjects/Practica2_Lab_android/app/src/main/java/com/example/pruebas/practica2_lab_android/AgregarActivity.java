package com.example.pruebas.practica2_lab_android;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {

    EditText matricula,marca,modelo;
    BDHelper MyDBM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        MyDBM=new BDHelper(this);
        matricula=(EditText)findViewById(R.id.editTextMatriculaAGregar);
        marca=(EditText)findViewById(R.id.editTextMarcaAGregar);
        modelo=(EditText)findViewById(R.id.editTextModeloAGregar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_agregar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.opcionGuardar){
            Cursor fila = MyDBM.getData(matricula.getText().toString());
            if(fila.moveToFirst()){
                Toast.makeText(getApplicationContext(),"REpetido",Toast.LENGTH_LONG).show();
            }
            else{
                MyDBM.insertContact(matricula.getText().toString(),marca.getText().toString(),modelo.getText().toString());
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }

        }
        else{
            finish();
        }
        return true;
    }
}
