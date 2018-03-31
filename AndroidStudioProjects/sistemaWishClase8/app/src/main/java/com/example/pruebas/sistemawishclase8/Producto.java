package com.example.pruebas.sistemawishclase8;

/**
 * Created by Pruebas on 06/10/2016.
 */
public class Producto {
    String nombre;
    String descripcion;
    int posImagen;
    int precio;

    public Producto(){

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

    public int getPosImagen() {
        return posImagen;
    }

    public void setPosImagen(int posImagen) {
        this.posImagen = posImagen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
