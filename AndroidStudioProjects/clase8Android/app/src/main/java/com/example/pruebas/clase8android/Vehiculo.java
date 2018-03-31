package com.example.pruebas.clase8android;

/**
 * Created by Pruebas on 13/10/2016.
 */
public class Vehiculo {
    String numeroPlaca;
    String marca;
    String descripcion;
    String modelo;
    String color;
    int cantPersonas;
    int costoAproximado;

    public Vehiculo(){
        numeroPlaca = "";
        marca="";
        descripcion="";
        modelo="";
        color = "";
        cantPersonas=0;
        costoAproximado=0;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public int getCostoAproximado() {
        return costoAproximado;
    }

    public void setCostoAproximado(int costoAproximado) {
        this.costoAproximado = costoAproximado;
    }
}
