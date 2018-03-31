package com.example.pruebas.mantenimiento_administrador;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Juliana on 24/05/2017.
 */
public class Conexion {

    private String baseurl;
    private final Retrofit retrofit;
    private Servidor servidor;

    public Conexion() {

        this.baseurl = "http://172.24.46.116:8090";
        this.retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
        this.servidor = retrofit.create(Servidor.class);
    }

    public Servidor getServidor() {
        return this.servidor;
    }
}
