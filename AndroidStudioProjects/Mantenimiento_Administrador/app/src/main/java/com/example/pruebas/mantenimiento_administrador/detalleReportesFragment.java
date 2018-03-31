package com.example.pruebas.mantenimiento_administrador;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class detalleReportesFragment extends Fragment {

    private View rootView;
    private LayoutInflater inflaterRelativeLayout;
    private RelativeLayout detalleReporteRelativeLayoutContenedor;


    private TextView detalleReporteLabelId,detalleReporteLabelFechaReporte,detalleReporteLabelFechaFinalizacion,detalleReporteLabelDescripcion
            ,detalleReporteLabelSolicitante,detalleReporteLabelPrioridad,detalleReporteLabelLugar;



    private String serId,serFechaReporte,serFechaFinalizacion,serDescripcion,serSolicitante,serPrioridad,serLugar;



    private Button detalle_reporte_opciones_nuevo_masInfo,detalle_reporte_opciones_nuevo_priorizar
            ,detalle_reporte_opciones_nuevo_denegar;



    private Button detalle_reporte_opciones_enProceso_estado,detalle_reporte_opciones_enProceso_finalizar;



    private Button detalle_reporte_opciones_priorizados_editar,detalle_reporte_opciones_priorizados_Iniciar;


    private Conexion conexion;
    private ConexionPush conexionPush;

    private String deviceId;



    //fragments

    private reporteEstadoEnProcesoEstadoFragment reporteEstadoEnProcesoEstadoFragment;
    private reporteEstadoNuevoMasInformacionFragment reporteEstadoNuevoMasInformacionFragment;
    private reporteEstadoNuevoPriorizarFragment reporteEstadoNuevoPriorizarFragment;
    private reporteEstadoEditarPrioridadFragment reporteEstadoEditarPrioridadFragment;
    private reporteEstadoPriorizadoIniciarFragment reporteEstadoPriorizadoIniciarFragment;
    private reportesMainFragment reportesMainFragment;

    private FragmentManager manager;

    public detalleReportesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_detalle_reportes, container, false);



        serId = Integer.toString(Global.getListaReportes().get(Global.getPosicionListView()).getId());
        serFechaReporte = Global.getListaReportes().get(Global.getPosicionListView()).getFechaReporte();
        serFechaFinalizacion =  Global.getListaReportes().get(Global.getPosicionListView()).getFechaFinalizacion();
        serPrioridad =  Global.getListaReportes().get(Global.getPosicionListView()).getPrioridadReporte();
        serSolicitante =  Global.getListaReportes().get(Global.getPosicionListView()).getNombre();
        serDescripcion =  Global.getListaReportes().get(Global.getPosicionListView()).getDescripcion();
        serLugar = Global.getListaReportes().get(Global.getPosicionListView()).getEstablecimiento();



        detalleReporteLabelId = (TextView)rootView.findViewById(R.id.detalleReporteLabelId);
        detalleReporteLabelFechaReporte = (TextView)rootView.findViewById(R.id.detalleReporteLabelFechaReporte);
        detalleReporteLabelFechaFinalizacion = (TextView)rootView.findViewById(R.id.detalleReporteLabelFechaFinalizacion);
        detalleReporteLabelPrioridad = (TextView)rootView.findViewById(R.id.detalleReporteLabelPrioridad);
        detalleReporteLabelSolicitante = (TextView)rootView.findViewById(R.id.detalleReporteLabelSolicitante);
        detalleReporteLabelDescripcion = (TextView)rootView.findViewById(R.id.detalleReporteLabelDescripcion);
        detalleReporteLabelLugar = (TextView)rootView.findViewById(R.id.detalleReporteLabelLugar);


        detalleReporteLabelDescripcion.setSelected(true);


        detalleReporteLabelId.setText(serId);
        detalleReporteLabelFechaReporte.setText(serFechaReporte);
        detalleReporteLabelFechaFinalizacion.setText(serFechaFinalizacion);
        detalleReporteLabelPrioridad.setText(serPrioridad);
        detalleReporteLabelSolicitante.setText(serSolicitante);
        detalleReporteLabelDescripcion.setText(serDescripcion);
        detalleReporteLabelLugar.setText(serLugar);


        detalleReporteLabelDescripcion.setMovementMethod(new ScrollingMovementMethod());


        if(Global.getTipoReporteSeleccionado().equals(Constantes.getEstadoNuevo())){
            detalleReporteRelativeLayoutContenedor =(RelativeLayout)rootView.findViewById(R.id.detalleReporteRelativeLayoutContenedor);
            inflaterRelativeLayout = LayoutInflater.from(getActivity());
                inflaterRelativeLayout.inflate(R.layout.activity_detalle_reporte_opciones_nuevo,detalleReporteRelativeLayoutContenedor,true);


            detalle_reporte_opciones_nuevo_masInfo=(Button)rootView.findViewById(R.id.detalle_reporte_opciones_nuevo_masInf);
            detalle_reporte_opciones_nuevo_priorizar=(Button)rootView.findViewById(R.id.detalle_reporte_opciones_nuevo_priorizar);
            detalle_reporte_opciones_nuevo_denegar=(Button)rootView.findViewById(R.id.detalle_reporte_opciones_nuevo_denegar);


            detalle_reporte_opciones_nuevo_masInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("OPCION NUEVO: MAS INFORMACION");
                    reporteEstadoNuevoMasInformacionFragment = new reporteEstadoNuevoMasInformacionFragment();
                    callFragment(reporteEstadoNuevoMasInformacionFragment);
                }
            });
            detalle_reporte_opciones_nuevo_priorizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("OPCION NUEVO: PRIORIZAR");
                    reporteEstadoNuevoPriorizarFragment = new reporteEstadoNuevoPriorizarFragment();
                    callFragment(reporteEstadoNuevoPriorizarFragment);
                }
            });
            detalle_reporte_opciones_nuevo_denegar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("OPCION NUEVO: DENEGAR O CANCELAR");
                    mensajeConfirmacion(Constantes.getEstadoCancelados());
                }
            });
        }
        else if(Global.getTipoReporteSeleccionado().equals(Constantes.getEstadoEnProceso())){
            detalleReporteRelativeLayoutContenedor =(RelativeLayout)rootView.findViewById(R.id.detalleReporteRelativeLayoutContenedor);
            inflaterRelativeLayout = LayoutInflater.from(getActivity());
            inflaterRelativeLayout.inflate(R.layout.activity_detalle_reporte_opciones_enproceso,detalleReporteRelativeLayoutContenedor,true);


            detalle_reporte_opciones_enProceso_estado = (Button)rootView.findViewById(R.id.detalle_reporte_opciones_enProceso_estado);
            detalle_reporte_opciones_enProceso_finalizar = (Button)rootView.findViewById(R.id.detalle_reporte_opciones_enProceso_finalizar);


            detalle_reporte_opciones_enProceso_estado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("OPCION NUEVO: ESTADO");
                    reporteEstadoEnProcesoEstadoFragment = new reporteEstadoEnProcesoEstadoFragment();
                    callFragment(reporteEstadoEnProcesoEstadoFragment);
                }
            });
            detalle_reporte_opciones_enProceso_finalizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("OPCION NUEVO: FINALIZAR");
                    mensajeConfirmacion(Constantes.getEstadoFinalizados());
                }
            });

        }
        else if(Global.getTipoReporteSeleccionado().equals(Constantes.getEstadoPriorizados())){
            detalleReporteRelativeLayoutContenedor =(RelativeLayout)rootView.findViewById(R.id.detalleReporteRelativeLayoutContenedor);
            inflaterRelativeLayout = LayoutInflater.from(getActivity());
            inflaterRelativeLayout.inflate(R.layout.activity_detalle_reporte_opciones_priorizados,detalleReporteRelativeLayoutContenedor,true);

            detalle_reporte_opciones_priorizados_editar = (Button)rootView.findViewById(R.id.detalle_reporte_opciones_priorizados_editarPrio);
            detalle_reporte_opciones_priorizados_Iniciar = (Button)rootView.findViewById(R.id.detalle_reporte_opciones_priorizados_inicar);

            detalle_reporte_opciones_priorizados_editar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    reporteEstadoEditarPrioridadFragment = new reporteEstadoEditarPrioridadFragment();
                    callFragment(reporteEstadoEditarPrioridadFragment);
                }
            });


            detalle_reporte_opciones_priorizados_Iniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    reporteEstadoPriorizadoIniciarFragment = new reporteEstadoPriorizadoIniciarFragment();
                    callFragment(reporteEstadoPriorizadoIniciarFragment);
                }
            });
        }
        return rootView;
    }
    public void mensajeConfirmacion(final String tipo){
        new AlertDialog.Builder(getActivity())
                .setMessage("¿Desea Confirmar?")
                .setTitle("Confirmacion")
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int id) {
                        if(tipo.equals(Constantes.getEstadoCancelados())){
                            confirmacionDenegar();
                            Log.i("Dialogos", "Reporte Denegado.");
                            dialog.cancel();
                            callReportesFragment();

                        }
                        else if(tipo.equals(Constantes.getEstadoFinalizados())){
                            confirmacionFinalizar();
                            Log.i("Dialogos", "Reporte Finalizado.");
                            dialog.cancel();
                            callReportesFragment();
                        }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("Dialogos", "Confirmacion Cancelada.");
                        dialog.cancel();
                    }
                }).create().show();
    }
    public void confirmacionDenegar(){
        conexion = new Conexion();
        Call<Boolean> call = conexion.getServidor().serverCambiarEstadoReporte(Integer.parseInt(serId),Constantes.getEstadoCancelados());
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                obtenerTokenUsuario(Constantes.getMensajeCancelar());
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Snackbar.make(getView(), "Error ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void confirmacionFinalizar(){
        conexion = new Conexion();
        Call<Boolean> call = conexion.getServidor().serverCambiarEstadoReporte(Integer.parseInt(serId)
                ,Constantes.getEstadoFinalizados());
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                obtenerTokenUsuario(Constantes.getMensajeFinalizar());
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Snackbar.make(getView(), "Error ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void obtenerTokenUsuario(final String mensaje){

        conexion = new Conexion();
        Call<String> call = conexion.getServidor().serverObtenerTokenUsuario(Integer.parseInt(serId));
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println("get token: " + response.body());
                deviceId = response.body();
                enviarMensaje(mensaje,deviceId);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("FAIL get token: " + t.toString());
            }
        });
    }
    public void enviarMensaje(String mensaje, String deviceId){

        conexionPush = new ConexionPush(deviceId,mensaje);

        conexion = new Conexion();
        Call<String> call = conexion.getServidor().serverEnviarMensajePush(conexionPush);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println("resultado: " +response.body());
             /*   Snackbar.make(getView(), "Envio mensaje con exito", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                        */
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("FAIL: send message " + t.toString());
            }
        });
    }


    public void callReportesFragment(){
        reportesMainFragment = new reportesMainFragment();
        callFragment(reportesMainFragment);
    }

    public void callFragment(Fragment fragment){
        manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.ContentForFragments,fragment).addToBackStack("tag").commit();
    }


}
