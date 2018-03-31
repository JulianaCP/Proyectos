package com.example.pruebas.clasedoslenguajesandroid;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {

    EditText nombre,descripcion,precio;
    BDHelper MyDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        nombre=(EditText)findViewById(R.id.agregarEditTextNombreProducto);
        descripcion=(EditText)findViewById(R.id.agregarEditTextDescripcionProducto);
        precio=(EditText)findViewById(R.id.agregarEditTextPrecioProducto);
        MyDB = new BDHelper(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.GuardarProducto) {
            Cursor rs = MyDB.getData(nombre.getText().toString());
            if (rs.moveToFirst()) {
                Toast.makeText(getApplicationContext(), "Repetido", Toast.LENGTH_SHORT).show();
                if (!rs.isClosed()) {
                    rs.close();
                }
            }
            else {
                MyDB.insertContact(nombre.getText().toString(), descripcion.getText().toString(),
                        precio.getText().toString());
                finish();
            }
        }
        if (item.getItemId() == R.id.Cancelar) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
