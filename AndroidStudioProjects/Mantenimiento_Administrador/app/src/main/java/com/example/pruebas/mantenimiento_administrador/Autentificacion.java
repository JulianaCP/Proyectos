package com.example.pruebas.mantenimiento_administrador;

/**
 * Created by Pruebas on 12/05/2017.
 */
public class Autentificacion {

    private static Usuario usuarioLogin;

    public static Usuario getUsuarioLogin() {
        return usuarioLogin;
    }
    public static void setUsuarioLogin(Usuario usuarioPass) {
        Autentificacion.usuarioLogin = usuarioPass;
    }




}
