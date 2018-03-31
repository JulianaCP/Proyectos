package com.example.pruebas.proyectolenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AppAdminEditarProductosActivity extends AppCompatActivity {

    EditText nombreProducto;
    EditText descripcionProducto;
    EditText precioProducto;
    EditText cantidadProducto;


    Button buttonAceptar;
    Button buttonCancelar;

    //variables
    String nombre;
    String descripcion;
    String precio;
    String cantidad;

    String nuevoNombre;
    String nuevoDescripcion;
    String nuevoPrecio;
    String nuevoCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_admin_editar_productos);

        nombreProducto=(EditText)findViewById(R.id.editTextNombreEditarProducto);
        descripcionProducto=(EditText)findViewById(R.id.editTextDescripcionEditarProducto);
        precioProducto=(EditText)findViewById(R.id.editTextPrecioEditarProducto);
        cantidadProducto=(EditText)findViewById(R.id.editTextCantidadEditarProducto);

        buttonAceptar=(Button)findViewById(R.id.buttonAceptarEditarProducto);
        buttonCancelar=(Button)findViewById(R.id.buttonCancelarEditarProducto);

        encontrarValores();

        nombreProducto.setText(nombre);
        descripcionProducto.setText(descripcion);
        precioProducto.setText(precio);
        cantidadProducto.setText(cantidad);



        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombreProducto.getText().toString().equals("") || descripcionProducto.getText().toString().equals("") ||
                        precioProducto.getText().toString().equals("") || cantidadProducto.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Datos incorrectos ",Toast.LENGTH_SHORT).show();
                }
                else{
                    cambiarDatos();
                    Toast.makeText(getApplicationContext(),"Cambio realizado con exito ",Toast.LENGTH_SHORT).show();
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

    public void cambiarDatos(){
        nuevoNombre = nombreProducto.getText().toString();
        nuevoDescripcion = descripcionProducto.getText().toString();
        nuevoPrecio = precioProducto.getText().toString();
        nuevoCantidad = cantidadProducto.getText().toString();
        for (int i=0;i<Global.listaProductosObjetos.size();i++){
            if(i == Global.posicionItemListViewPresionado){
                Global.listaProductosObjetos.get(i).setNombre(nuevoNombre);
                Global.listaProductosObjetos.get(i).setDescripcion(nuevoDescripcion);
                Global.listaProductosObjetos.get(i).setPrecioPorUnidad(nuevoPrecio);
                Global.listaProductosObjetos.get(i).setCantidad(nuevoCantidad);
                break;
            }
        }

    }

    public void encontrarValores(){
        for (int i=0;i<Global.listaProductosObjetos.size();i++){
            if(i == Global.posicionItemListViewPresionado){
                nombre = Global.listaProductosObjetos.get(i).getNombre();
                descripcion = Global.listaProductosObjetos.get(i).getDescripcion();
                precio = Global.listaProductosObjetos.get(i).getPrecioPorUnidad();
                cantidad = Global.listaProductosObjetos.get(i).getCantidad();
                break;
            }
        }
    }

}
