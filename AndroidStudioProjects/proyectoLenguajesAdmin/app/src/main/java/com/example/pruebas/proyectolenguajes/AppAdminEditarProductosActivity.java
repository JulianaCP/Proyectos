package com.example.pruebas.proyectolenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class AppAdminEditarProductosActivity extends AppCompatActivity {

    EditText descripcionProducto;
    EditText precioProducto;
    TextView nombreProducto;
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

        nombreProducto=(TextView) findViewById(R.id.textView10);
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
                }
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    public void cambiarDatos(){
        /*Edita los datos del producto seleccionado por el usuario, por los nuevos datos escritos por
         el usuario. se cambian los datos tanto en la base de datos como en las listas del sistema */
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

                RestAdapter.Builder builder4 = new RestAdapter.Builder()
                        .setEndpoint(Global.baseurl)
                        .setClient(new OkClient(new OkHttpClient()));// alt intro si da error...
                Global.server = builder4.build().create(Servidor.class);
                Global.server.modificarProducto(Global.listaProductosObjetos.get(i), new Callback<String>() {
                    @Override
                    public void success(String respuesta, Response response) {
                        if (respuesta.equals("si")){
                            Toast.makeText(AppAdminEditarProductosActivity.this,"Cambio realizado con exito",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(AppAdminEditarProductosActivity.this,"no se realizo"+respuesta,Toast.LENGTH_SHORT).show();
                        }
                        finish();
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
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
