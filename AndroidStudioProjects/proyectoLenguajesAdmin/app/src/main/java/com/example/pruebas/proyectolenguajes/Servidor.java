package com.example.pruebas.proyectolenguajes;
import java.util.ArrayList;


import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Johanna on 13/10/2016.
 */
public interface Servidor {

    /*Aquí se encuentran las distintas rutas que realizan el llamado a las funciones localizadas dentro del servidor
    * para de esta forma realizar las distintas consultas solicitadas o procesos a realizar*/


    @GET("/GetProductos")
    void getProductoInfo(Callback<ArrayList<Producto>>usersCallback);

    @GET("/Getclientes")
    void getClientes(Callback<ArrayList<Cliente>>usersCallback);

    @GET("/GetAdministradores")
    void GetAdministradores(Callback<ArrayList<Administrador>>usersCallback);

    @POST("/crearProducto/producto")
    void postData(@Body Producto producto,
                  Callback<String> serverResponseCallback);

    @POST("/modificar/producto")
    void modificarProducto(@Body Producto producto,
                  Callback<String> serverResponseCallback);

    @POST("/eliminar/producto")
    void eliminarProducto(@Body Producto producto,
                           Callback<String> serverResponseCallback);

    @POST("/crearCliente/cliente")
    void agregarCliente(@Body Cliente cliente,
                  Callback<String> serverResponseCallback);

    @POST("/modificar/cliente")
    void modificarCliente(@Body Cliente cliente,
                        Callback<String> serverResponseCallback);

    @POST("/eliminar/cliente")
    void eliminarCliente(@Body Usuario cliente,
                          Callback<String> serverResponseCallback);


    @POST("/crearAministrador/Administrador")
    void agregarAdministrador(@Body Administrador administrador,
                        Callback<String> serverResponseCallback);
}