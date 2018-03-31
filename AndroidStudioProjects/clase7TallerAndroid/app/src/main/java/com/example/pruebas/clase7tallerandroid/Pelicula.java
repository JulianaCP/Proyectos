package com.example.pruebas.clase7tallerandroid;

/**
 * Created by Pruebas on 29/09/2016.
 */
public class Pelicula {

    String nombre;
    int pos;

    public Pelicula(){
        nombre="";
        pos=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
