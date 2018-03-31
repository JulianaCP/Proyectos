package com.example.pruebas.practica2_lab_android;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OpcionActivity extends AppCompatActivity {

    EditText matricula,marca,modelo;
    Button buttonEliminar,buttonCancelar,buttonModificar;
    BDHelper MyDB;
    String posicion;
    String valorViejo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion);
        matricula=(EditText)findViewById(R.id.editTextMatricula);
        marca=(EditText)findViewById(R.id.editTextMarca);
        modelo=(EditText)findViewById(R.id.editTextModelo);
        buttonEliminar=(Button)findViewById(R.id.buttonEliminar);
        buttonModificar=(Button)findViewById(R.id.buttonModificar);
        buttonCancelar=(Button)findViewById(R.id.buttonCancelar);



        MyDB = new BDHelper(this);
        Bundle bundle = getIntent().getExtras();
        posicion = bundle.getString("posicion");
        valorViejo= Global.matriculas.get(Integer.parseInt(posicion));
        try{
            Cursor fila = MyDB.getData(posicion);
            if(fila.moveToFirst()){
                matricula.setText(fila.getString(0));
                marca.setText(fila.getString(1));
                modelo.setText(fila.getString(2));
            }
            else{
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"entro catch",Toast.LENGTH_SHORT).show();
        }


        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmar();
            }
        });
        buttonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modificar();
            }
        });

    }



    public void confirmar(){
        final AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("confimar");
        dialogo.setMessage("Desea eliminar el vehiculo?");
        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                eliminar();
            }
        });
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }
    public void eliminar(){
        MyDB.deleteContact(Global.matriculas.get(Integer.parseInt(posicion)));
        finish();
    }
    public void modificar(){
        MyDB.updateContact(valorViejo,matricula.getText().toString(),marca.getText().toString(),modelo.getText().toString());
        finish();
    }
}
