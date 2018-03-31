package com.example.pruebas.proyectolenguajes;

/**
 * Created by Pruebas on 21/10/2016.
 */
public class Producto {
    String nombre; //unico
    String descripcion;
    String cantidad;
    String precioPorUnidad;

    public Producto(String nombre,String descripcion,String cantidad,String precioPorUnidad){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.cantidad=cantidad;
        this.precioPorUnidad=precioPorUnidad;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(String precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }
}
