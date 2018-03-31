package com.example.pruebas.mantenimiento_administrador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Juliana on 12/05/2017.
 */
public class Global {

    // ArrayList reportes
    private static ArrayList<Reporte> listaReportes = new ArrayList<Reporte>();
    public static ArrayList<Reporte> getListaReportes(){
        return Global.listaReportes;
    }
    public static void setListaReportes(ArrayList<Reporte> lista){
        Global.listaReportes = lista ;
    }


    //reportes Main
    private static int posicionListView;
    public static int getPosicionListView() {
        return posicionListView;
    }
    public static void setPosicionListView(int posicionListView) {
        Global.posicionListView = posicionListView;
    }


    //reportes Main
    private static String tipoReporteSeleccionado;
    public static String getTipoReporteSeleccionado() {
        return tipoReporteSeleccionado;
    }
    public static void setTipoReporteSeleccionado(String tipoReporteSeleccionado) {
        Global.tipoReporteSeleccionado = tipoReporteSeleccionado;
    }

    private static String tipoReporteSeleccionadoPopup;
    public static String getTipoReporteSeleccionadoPopup() {
        return tipoReporteSeleccionadoPopup;
    }
    public static void setTipoReporteSeleccionadoPopup(String tipoReporteSeleccionado) {
        Global.tipoReporteSeleccionadoPopup = tipoReporteSeleccionado;
    }

}
