package com.example.pruebas.mantenimiento_administrador;

/**
 * Created by Pruebas on 24/05/2017.
 */
public class Constantes {

    //reportesMain : constantes
    private static final String estadoNuevo = "nuevo";
    public static String getEstadoNuevo(){
        return Constantes.estadoNuevo;
    }

    private static final String estadoPriorizados = "conPrioridad";
    public static String getEstadoPriorizados(){return Constantes.estadoPriorizados;}

    private static final String estadonEnProceso = "enProceso";
    public static String getEstadoEnProceso(){return Constantes.estadonEnProceso;}

    private static final String estadoFinalizados = "Finalizado";
    public static String getEstadoFinalizados(){return Constantes.estadoFinalizados;}

    private static final String estadoCancelados = "Cancelado";
    public static String getEstadoCancelados(){return Constantes.estadoCancelados;}

    private static final String estadoPriorizadosFecha = "fecha";
    public static String getEstadoPriorizadosFecha(){return Constantes.estadoPriorizadosFecha;}

    private static final String estadoPriorizadosAdmin = "Admin";
    public static String getEstadoPriorizadosAdmin(){return Constantes.estadoPriorizadosAdmin;}

    private static final String estadoInformacion = "informacion";
    public static String getEstadoInformacion(){return Constantes.estadoInformacion;}

    private static final String importanciaReporteAlto = "Alto";
    public static String getImportanciaReporteAlto(){return Constantes.importanciaReporteAlto;}

    private static final String importanciaReporteMedio = "Medio";
    public static String getImportanciaReporteMedio(){return Constantes.importanciaReporteMedio;}

    private static final String importanciaReporteBajo = "Bajo";
    public static String getImportanciaReporteBajo(){return Constantes.importanciaReporteBajo;}

    private static final String tipoUsurioTecnico = "Tecnico";
    public static String getTipoUsurioTecnico(){return Constantes.tipoUsurioTecnico;}


    //nuevas... para push


    private static final String mensajeCancelar = "Su reporte a sido cancelado por el administrador. Numero reporte: ";
    public static String getMensajeCancelar(){return Constantes.mensajeCancelar;}


    private static final String mensajeFinalizar = "Su reporte a finalizado exitosamente. Numero reporte: ";
    public static String getMensajeFinalizar(){return Constantes.mensajeFinalizar;}



    private static final String pushAppProfesorTecnicoId = "AAAAU-NQ3Ak:APA91bE09KiPNvglm_JW6J25YXBF1crW94fEAjQPcXxEONIsskszOAtUUvBXmOInMf_XwXX3tqabswj6bHIEqJ4iX0BrfrMCDnbVEZjvda6q0hylyfNCxDh0FtIBdX6smRaWu9P9hXwH";
    public static String getPushAppProfesorTecnicoID(){return Constantes.pushAppProfesorTecnicoId;}


    private static final String pushSenderProfesorTecnicoId  = "360296012809";
    public static String getPushSenderProfesorTecnicoId(){return Constantes.pushSenderProfesorTecnicoId;}



}
