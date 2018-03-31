package com.example.pruebas.proyectolenguajes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;


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

        /*funcion encargada de a el nuevo producto dentro de la base de datos del sistema
        * y las listas actuales del sistema*/

        nuevoNombre = nombreProducto.getText().toString();
        nuevoDescripcion = descripcionProducto.getText().toString();
        nuevoPrecio = precioProducto.getText().toString();
        nuevoCantidad = cantidadProducto.getText().toString();

        final Producto producto = new Producto(nuevoNombre,nuevoDescripcion,nuevoCantidad,nuevoPrecio);


        RestAdapter.Builder builder4 = new RestAdapter.Builder()
                .setEndpoint(Global.baseurl)
                .setClient(new OkClient(new OkHttpClient()));// alt intro si da error...
        Global.server = builder4.build().create(Servidor.class);
        Global.server.postData(producto, new Callback<String>() {
            @Override
            public void success(String respuesta, Response response) {
                if (respuesta.equals("si")){
                    Toast.makeText(AppAdminAgregarProductoActivity.this,"Se ha realizado exitosamente",Toast.LENGTH_SHORT).show();
                    Global.listaProductosObjetos.add(producto);
                }
                else{
                    Toast.makeText(AppAdminAgregarProductoActivity.this,"Error: no se realizó",Toast.LENGTH_SHORT).show();
                }
                finish();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
