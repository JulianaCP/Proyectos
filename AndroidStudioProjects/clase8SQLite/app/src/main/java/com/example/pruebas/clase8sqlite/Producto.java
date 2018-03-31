package com.example.pruebas.clase8sqlite;

/**
 * Created by Pruebas on 20/10/2016.
 */
public class Producto {
    String nombre;
    String descripcion;
    String precio;

    public Producto(){
        nombre = "";
        descripcion = "";
        precio="";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
