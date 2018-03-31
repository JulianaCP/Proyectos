package com.example.pruebas.clase8android;


import java.util.ArrayList;
import retrofit.Callback;
import retrofit.http.GET;

public interface Servidor {
    @GET("/vehiculos")
    void getVehiculosInfo(Callback<ArrayList<Vehiculo>> usersCallback);
}
