package com.example.pruebas.proyectolenguajes;

import java.util.Date;

/**
 * Created by Pruebas on 20/10/2016.
 */
public class Cliente extends Usuario{
    /*clase usuario en la cual se encuentran la estructure de los datos del usuario
    * cliente*/


    String fechaRegistro;
    String ultimoLogin;
    public Cliente(String nombre,String login,String password,String telefono,String permiso,String fechaRegistro,String ultimoLogin){
        super(nombre,login,password,telefono,permiso);
        this.fechaRegistro = fechaRegistro;
        this.ultimoLogin = ultimoLogin;
    }

    public String getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(String ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
