package com.example.pruebas.proyectolenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AppAdminAgregarProductoActivity extends AppCompatActivity {

    EditText nombreProducto;
    EditText descripcionProducto;
    EditText precioProducto;
    EditText cantidadProducto;

    Button buttonAceptar;
    Button buttonCancelar;


    //variables

    String nuevoNombre;
    String nuevoDescripcion;
    String nuevoPrecio;
    String nuevoCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_admin_agregar_producto);

        nombreProducto = (EditText)findViewById(R.id.editTextNombreAgregarProducto);
        descripcionProducto =(EditText)findViewById(R.id.editTextDescripcionAgregarProducto);
        precioProducto=(EditText)findViewById(R.id.editTextPrecioAgregarProducto);
        cantidadProducto=(EditText)findViewById(R.id.editTextCantidadAgregarProducto);

        buttonAceptar=(Button)findViewById(R.id.buttonAceptarAgregarProducto);
        buttonCancelar=(Button)findViewById(R.id.buttonCancelarAgregarProducto);


        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombreProducto.getText().toString().equals("") || descripcionProducto.getText().toString().equals("") ||
                        precioProducto.getText().toString().equals("") || cantidadProducto.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Datos incorrectos ",Toast.LENGTH_SHORT).show();
                }
                else{
                    agregar();
                    Intent intent = new Intent(getApplicationContext(),AppAdminActivity.class);
                    startActivity(intent);
                }

            }
        });


        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AppAdminActivity.class);
                startActivity(intent);
            }
        });
    }
    public void agregar(){
        nuevoNombre = nombreProducto.getText().toString();
        nuevoDescripcion = descripcionProducto.getText().toString();
        nuevoPrecio = precioProducto.getText().toString();
        nuevoCantidad = cantidadProducto.getText().toString();

        Producto producto = new Producto(nuevoNombre,nuevoDescripcion,nuevoCantidad,nuevoPrecio);
        Global.listaProductosObjetos.add(producto);
    }
}
