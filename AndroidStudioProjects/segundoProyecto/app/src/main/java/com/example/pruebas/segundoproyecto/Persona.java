package com.example.pruebas.segundoproyecto;

import java.util.ArrayList;

/**
 * Created by Pruebas on 18/08/2016.
 */
public class Persona {

    String nombre;
    String procedencia;
    //ArrayList<String> lista;


    public Persona(){
       // lista = new ArrayList<String>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }
}
