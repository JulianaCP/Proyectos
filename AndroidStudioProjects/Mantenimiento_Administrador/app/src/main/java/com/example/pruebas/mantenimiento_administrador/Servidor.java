package com.example.pruebas.mantenimiento_administrador;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Juliana on 12/05/2017.
 */
public interface Servidor {

    @GET("/Usuarios/ObtenerInfo/{nombre}/{pass}")
    Call<Usuario> serverLogin(@Path("nombre") String nombre, @Path("pass") String pass);

    @GET("/Reporte/obtenerListaReportesEstado/{estadoReporte}")
    Call<ArrayList<Reporte>> serverObtenerListaReportesSegunEstado(@Path("estadoReporte") String estadoReporte);

    @GET("/Reporte/obtenerListaReportesPriorizadosFiltro/{tipoFiltro}")
    Call<ArrayList<Reporte>> serverObtenerListaReportesPriorizadosSegunFiltro(@Path("tipoFiltro") String tipoFiltro);

    @POST("/Reporte/reportesSolicitarInformacion/{idReporte}/{informacion}")
    Call<Boolean> serverSolicitarMasInfReporte(@Path("idReporte") int idReporte,@Path("informacion") String informacion);

    @POST("/Reportes/cambiarEstado/{idReporte}/{estado}")
    Call<Boolean> serverCambiarEstadoReporte(@Path("idReporte") int idReporte,@Path("estado") String informacion);

    @GET("/Usuarios/obtenerListaUsuarios/{tipoPermiso}")
    Call<ArrayList<Usuario>> serverObtenerListaUsuarios(@Path("tipoPermiso") String tipoPermiso);




    //falta hacer en servidor


    @POST("/Reporte/actualizarPrioridad/{idReporte}/{fechaFinalizacion}/{nivelPrioridad}")
    Call<Boolean> serverActualizarPrioridadReporte(@Path("idReporte") int idReporte
            ,@Path("fechaFinalizacion") String fechaFinalizacion,@Path("nivelPrioridad") String nivelPrioridad);



    @POST("/Reporte/asignarTecnico/{idReporte}/{idUsuario}")
    Call<Boolean> serverAsignarTecnicoServidor(@Path("idReporte") int idReporte
            ,@Path("idUsuario") String idUsuario);



    ////////////////////////   funciones push



    @POST("/Usuarios/enviarMensajePush")
    Call<String> serverEnviarMensajePush(@Body ConexionPush conexionPush);


    @POST("/Usuarios/actualizarTokenPush/{nombreUsuario}/{id}")
    Call<Boolean> serverActualizarToken(@Path("nombreUsuario") String nombreUsuario, @Path("id") String id);



    @GET("/Usuarios/obtenerTokenUsuario/{idReporte}")
    Call<String> serverObtenerTokenUsuario(@Path("idReporte") int idReporte);


}
