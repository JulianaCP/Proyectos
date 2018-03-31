package com.example.pruebas.practica3_lab_android;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MultiprocesoActivity extends AppCompatActivity {

    BDHelper MyDB;
    EditText codigo,marca,precio,descripcion;
    Bundle bundle;
    String posicion;

    String codigoVar,marcaVar,precioVar,descripcionVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiproceso);
        MyDB = new BDHelper(this);
        codigo = (EditText)findViewById(R.id.editTextCodigoMulti);
        marca = (EditText)findViewById(R.id.editTextMarcaMulti);
        precio = (EditText)findViewById(R.id.editTextPrecioMulti);
        descripcion = (EditText)findViewById(R.id.editTextDescripcionMulti);

        bundle = getIntent().getExtras();
        posicion = bundle.getString("posicion");
        Toast.makeText(getApplicationContext(),"posicion: " + posicion,Toast.LENGTH_LONG).show();

        codigoVar = Global.listaProductos.get(Integer.parseInt(posicion)).getCodigo();
        marcaVar = Global.listaProductos.get(Integer.parseInt(posicion)).getMarca();
        precioVar = Global.listaProductos.get(Integer.parseInt(posicion)).getPrecio();
        descripcionVar = Global.listaProductos.get(Integer.parseInt(posicion)).getDescripcion();

        codigo.setText(codigoVar);
        marca.setText(marcaVar);
        precio.setText(precioVar);
        descripcion.setText(descripcionVar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_seleccionar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.opcionEliminar){
            Toast.makeText(getApplicationContext(),"eliminar",Toast.LENGTH_LONG).show();
            mensajeEliminar();
        }
        else if(item.getItemId() == R.id.opcionModificar){
            Toast.makeText(getApplicationContext(),"modificar",Toast.LENGTH_LONG).show();
            modificar();
        }
        else if(item.getItemId() == R.id.opcion_cancelar_seleccion){
            Toast.makeText(getApplicationContext(),"cancelar",Toast.LENGTH_LONG).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void mensajeEliminar(){
        AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
        mensaje.setTitle("Confirmar");
        mensaje.setMessage("Desea eliminar el producto?");
        mensaje.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    eliminar();
            }
        });
        mensaje.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        mensaje.create().show();
    }
    public void eliminar(){
        MyDB.deleteContact(Global.listaProductos.get(Integer.parseInt(posicion)).getCodigo());
        finish();
    }
    public void modificar(){
        codigoVar = codigo.getText().toString();
        marcaVar = marca.getText().toString();
        precioVar = precio.getText().toString();
        descripcionVar = descripcion.getText().toString();
        if(!MyDB.updateContact(Global.listaProductos.get(Integer.parseInt(posicion)).getCodigo(),codigoVar,marcaVar,precioVar,descripcionVar)){
            Toast.makeText(getApplicationContext(),"Repetido",Toast.LENGTH_LONG).show();
        }
        finish();
    }
}
