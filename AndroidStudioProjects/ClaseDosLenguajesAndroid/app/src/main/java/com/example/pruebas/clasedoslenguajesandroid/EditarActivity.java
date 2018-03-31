package com.example.pruebas.clasedoslenguajesandroid;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class EditarActivity extends AppCompatActivity {

    Bundle bundle;
    String oldName;
    BDHelper MyDB;
    EditText nombre,descripcion,precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        MyDB = new BDHelper(this);
        nombre=(EditText)findViewById(R.id.editarEditTextNombreProducto);
        descripcion=(EditText)findViewById(R.id.editarEditTextDescripcionProducto);
        precio=(EditText)findViewById(R.id.editarEditTextPrecioProducto);
        bundle = getIntent().getExtras();
        oldName = bundle.getString("nombre");
        Toast.makeText(getApplicationContext(),"oldname: " + oldName,Toast.LENGTH_SHORT).show();


        Cursor rs = MyDB.getData(oldName);
        if(rs.moveToFirst()) {
            nombre.setText(rs.getString(0));
            descripcion.setText(rs.getString(1));
            precio.setText(rs.getString(2));
            if (!rs.isClosed()) {
                rs.close();
            }
        }else{
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.GuardarProducto) {
            if (!MyDB.updateContact(oldName, nombre.getText().toString(),
                    descripcion.getText().toString(),
                    precio.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Repetido", Toast.LENGTH_SHORT).show();
            }
            finish();
        }
        if (item.getItemId() == R.id.Cancelar) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
