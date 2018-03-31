package com.example.pruebas.mantenimiento_administrador;

/**
 * Created by Pruebas on 01/09/2017.
 */
public class ConexionPush {
    String appID = "AAAAU-NQ3Ak:APA91bE09KiPNvglm_JW6J25YXBF1crW94fEAjQPcXxEONIsskszOAtUUvBXmOInMf_XwXX3tqabswj6bHIEqJ4iX0BrfrMCDnbVEZjvda6q0hylyfNCxDh0FtIBdX6smRaWu9P9hXwH";
    String senderID = "360296012809"; ;
    String deviceID;
    String mensaje;

    public ConexionPush(String deviceID, String mensaje) {
        this.deviceID = deviceID;
        this.mensaje = mensaje;
    }
}
