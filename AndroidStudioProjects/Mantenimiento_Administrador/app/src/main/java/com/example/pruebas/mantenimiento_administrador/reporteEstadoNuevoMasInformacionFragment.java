package com.example.pruebas.mantenimiento_administrador;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class reporteEstadoNuevoMasInformacionFragment extends Fragment {

    private TextView estadoNuevoMasInfTextViewDescripcion;
    private EditText estadoNuevoMasInfEditTextSolicitar;
    private Button estadoNuevoMasInfButtonAceptar,estadoNuevoMasInfButtonCancelar;

    private String estadoNuevoMasInf_infomacionSolicitada;
    private int serId;
    private View rootView;
    private Conexion conexion;


    //fragments
    private reportesMainFragment reportesMainFragment;
    private detalleReportesFragment detalleReportesFragment;
    private FragmentManager manager;


    public reporteEstadoNuevoMasInformacionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_reporte_estado_nuevo_mas_informacion, container, false);


        estadoNuevoMasInfTextViewDescripcion=(TextView)rootView.findViewById(R.id.estadoNuevoMasInfTextViewDescripcion);
        estadoNuevoMasInfEditTextSolicitar=(EditText)rootView.findViewById(R.id.estadoNuevoMasInfEditTextSolicitar);
        estadoNuevoMasInfButtonAceptar = (Button)rootView.findViewById(R.id.estadoNuevoMasInfButtonAceptar);
        estadoNuevoMasInfButtonCancelar = (Button)rootView.findViewById(R.id.estadoNuevoMasInfButtonCancelar);

        estadoNuevoMasInfTextViewDescripcion.setSelected(true);
        estadoNuevoMasInfTextViewDescripcion.setText(Global.getListaReportes().get(Global.getPosicionListView()).getDescripcion());
        estadoNuevoMasInfTextViewDescripcion.setMovementMethod(new ScrollingMovementMethod());


        estadoNuevoMasInfButtonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detalleReportesFragment = new detalleReportesFragment();
                callFragment(detalleReportesFragment);
            }
        });
        estadoNuevoMasInfButtonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                if(estadoNuevoMasInfEditTextSolicitar.getText().toString().equals("")){
                    Snackbar.make(view, "Descripcion vacio", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
                    estadoNuevoMasInf_infomacionSolicitada = estadoNuevoMasInfEditTextSolicitar.getText().toString();
                    serId = Global.getListaReportes().get(Global.getPosicionListView()).getId();

                    conexion = new Conexion();
                    Call<Boolean> call = conexion.getServidor().serverSolicitarMasInfReporte(serId
                            ,estadoNuevoMasInf_infomacionSolicitada);
                    call.enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            cambiarEstadoReporte();
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Snackbar.make(view, "Error eliminacion", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    });
                }
            }
        });

        return rootView;
    }

    public void cambiarEstadoReporte(){

        conexion = new Conexion();
        Call<Boolean> call = conexion.getServidor().serverCambiarEstadoReporte(serId,Constantes.getEstadoInformacion());
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Snackbar.make(getView(), "Solicitud Realizada", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                reportesMainFragment = new reportesMainFragment();
                callFragment(reportesMainFragment);
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Snackbar.make(getView(), "Error ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void callFragment(Fragment fragment){
        manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.ContentForFragments,fragment).addToBackStack("tag").commit();
    }
}
