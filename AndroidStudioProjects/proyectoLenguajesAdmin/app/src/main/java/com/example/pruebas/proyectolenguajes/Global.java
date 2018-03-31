package com.example.pruebas.proyectolenguajes;

import android.content.Context;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

/**
 * Created by Pruebas on 20/10/2016.
 */
public class Global {

    //constantes

    public static final String permisosAdministrador = "Administrador";
    public static final String permisosCliente = "Cliente";
    public static String baseurl= "http://10.0.2.2:8080";
    //public static String baseurl= "http://172.24.41.35:8080";
    public  static Servidor server;
    //listas

    public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    public static ArrayList<Producto> listaProductosObjetos = new ArrayList<Producto>();
    public static ArrayList<Cliente> listaClientesCreada = new ArrayList<Cliente>();

    //variablews
    public static int posicionItemListViewPresionado;
    public static int posListViewPersonalizado;


    //constructor
    public Global(){

    }


    public static void setInfo(final Context context){
        /*Funcion encargada de introducir dentro de las distintas listas globales del sistema,
        * los diversos datos que se almacenan en la base de datos mysql*/


        Global.listaProductosObjetos.clear();
        Global.listaUsuarios.clear();
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(Global.baseurl)
                .setClient(new OkClient(new OkHttpClient()));// alt intro si da error...
        Global.server = builder.build().create(Servidor.class);
        Global.server.getProductoInfo(new Callback<ArrayList<Producto>>() {
            @Override
            public void success(ArrayList<Producto> Productos, Response response) {
                Global.listaProductosObjetos= Productos;
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        RestAdapter.Builder builder2 = new RestAdapter.Builder()
                .setEndpoint(Global.baseurl)
                .setClient(new OkClient(new OkHttpClient()));// alt intro si da error...
        Global.server = builder2.build().create(Servidor.class);
        Global.server.getClientes(new Callback<ArrayList<Cliente>>() {
            @Override
            public void success(ArrayList<Cliente> listaClientes, Response response) {
                for(int i= 0; i<listaClientes.size(); i++){
                    Global.listaUsuarios.add(listaClientes.get(i));
                }
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });

        RestAdapter.Builder builder3 = new RestAdapter.Builder()
                .setEndpoint(Global.baseurl)
                .setClient(new OkClient(new OkHttpClient()));// alt intro si da error...
        Global.server = builder3.build().create(Servidor.class);
        Global.server.GetAdministradores(new Callback<ArrayList<Administrador>>() {
            @Override
            public void success(ArrayList<Administrador> listaAdministrador, Response response) {
                for(int i= 0; i<listaAdministrador.size(); i++){
                    Global.listaUsuarios.add(listaAdministrador.get(i));
                }
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
