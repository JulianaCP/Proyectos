package com.example.pruebas.mantenimiento_administrador;

/**
 * Created by Pruebas on 12/05/2017.
 */
public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private String telefono;
    private String rol;
    private String activo;

    public Usuario(String parNombreUsuaario, String parContrasena, String parNombre, String parApellido1,
                   String parApellido2, String parCorreo, String parTelefono, String parRol, String parActivo) {
        this.nombreUsuario = parNombreUsuaario;
        this.contrasena = parContrasena;
        this.nombre = parNombre;
        this.apellido1 = parApellido1;
        this.apellido2 = parApellido2;
        this.correo = parCorreo;
        this.telefono = parTelefono;
        this.rol = parRol;
        this.activo = parActivo;


    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }



}
