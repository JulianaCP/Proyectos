package com.example.pruebas.practica_1_lab_lenguajes;

/**
 * Created by Pruebas on 02/11/2016.
 */
public class Pais {
    String poblacion;
    String nombre;
    String descripcion;
    public Pais(String nombre,String poblacion,String descripcion){
        this.nombre=nombre;
        this.poblacion=poblacion;
        this.descripcion=descripcion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
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
}
