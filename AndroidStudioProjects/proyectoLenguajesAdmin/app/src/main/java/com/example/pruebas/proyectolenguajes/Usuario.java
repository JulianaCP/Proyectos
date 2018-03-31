package com.example.pruebas.proyectolenguajes;

/**
 * Created by Pruebas on 20/10/2016.
 */
public class Usuario {
    /*clase usuario en la cual se encuentran la estructure de los datos del usuario
    * administrador y cliente*/

    String nombre;
    String login;
    String password;
    String telefono;
    String permiso;

    public Usuario(String nombre,String login,String password,String telefono,String permiso){
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.telefono = telefono;
        this.permiso = permiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }
}
