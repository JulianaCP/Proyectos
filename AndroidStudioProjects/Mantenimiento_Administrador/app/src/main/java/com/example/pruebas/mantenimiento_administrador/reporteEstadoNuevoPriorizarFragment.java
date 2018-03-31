package com.example.pruebas.mantenimiento_administrador;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class reporteEstadoNuevoPriorizarFragment extends Fragment {


    private DatePickerDialog datePickerDialog;
    private Button estadoNuevoPriorizarButtonAceptar,estadoNuevoPriorizarButtonCancelar;
    private int estadoNuevoPriorizarDia, estadoNuevoPriorizarMes, estadoNuevoPriorizarAño;
    private RadioButton estadoNuevoPriorizaAlto,estadoNuevoPriorizaMedio,estadoNuevoPriorizaBajo;


    private View rootView;
    private Conexion conexion;
    private LinearLayout estadoNuevoLinearLayoutFecha;
    private TextView estadoNuevoPriorizarTxtDate;
    private String estadoNuevoPriorizarRadioButtonChecked;
    private int serIdReporte;
    private String txt_fecha;




    //fragments

    private reportesMainFragment reportesMainFragment;
    private detalleReportesFragment detalleReportesFragment;
    private FragmentManager manager;



    public reporteEstadoNuevoPriorizarFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       rootView = inflater.inflate(R.layout.fragment_reporte_estado_nuevo_priorizar, container, false);

        estadoNuevoLinearLayoutFecha = (LinearLayout)rootView.findViewById(R.id.estadoNuevoLinearLayoutFecha);




        estadoNuevoPriorizarButtonAceptar = (Button)rootView.findViewById(R.id.estadoNuevoPriorizarButtonAceptar);
        estadoNuevoPriorizarButtonCancelar = (Button)rootView.findViewById(R.id.estadoNuevoPriorizarButtonCancelar);
        estadoNuevoPriorizarTxtDate = (TextView)rootView.findViewById(R.id.estadoNuevoPriorizarLabelDate);

        estadoNuevoPriorizaAlto = (RadioButton)rootView.findViewById(R.id.estadoNuevoPriorizarRadioButtonAlto);
        estadoNuevoPriorizaMedio = (RadioButton)rootView.findViewById(R.id.estadoNuevoPriorizarRadioButtonMedio);
        estadoNuevoPriorizaBajo = (RadioButton)rootView.findViewById(R.id.estadoNuevoPriorizarRadioButtonBajo);


        serIdReporte = Global.getListaReportes().get(Global.getPosicionListView()).getId();
        estadoNuevoPriorizarTxtDate.setText(Global.getListaReportes().get(Global.getPosicionListView()).getFechaFinalizacion());

        obtenerFecha();

        estadoNuevoLinearLayoutFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarCalendario();
            }
        });
        estadoNuevoPriorizarButtonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(estadoNuevoPriorizaAlto.isChecked()){
                    estadoNuevoPriorizarRadioButtonChecked = Constantes.getImportanciaReporteAlto();
                }
                else if(estadoNuevoPriorizaMedio.isChecked()){
                    estadoNuevoPriorizarRadioButtonChecked = Constantes.getImportanciaReporteMedio();
                }
                else{
                    estadoNuevoPriorizarRadioButtonChecked = Constantes.getImportanciaReporteBajo();
                }

                conexion = new Conexion();
                txt_fecha =  estadoNuevoPriorizarTxtDate.getText().toString();
                System.out.println("id: " +serIdReporte+ " txt_fecha: " + txt_fecha + " nivel: " + estadoNuevoPriorizarRadioButtonChecked);
                Call<Boolean> call = conexion.getServidor().serverActualizarPrioridadReporte(serIdReporte
                        ,txt_fecha,estadoNuevoPriorizarRadioButtonChecked);
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Snackbar.make(view, "Asignacion Prioridad Exitosa", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        cambiarEstadoReporteNuevo();

                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Snackbar.make(view, "Proceso Fallido", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
        });

        estadoNuevoPriorizarButtonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDetalleFragment();
            }
        });

        return rootView;
    }

    public void obtenerFecha(){
        Calendar c = Calendar.getInstance();
        estadoNuevoPriorizarAño = c.get(Calendar.YEAR);
        estadoNuevoPriorizarMes = c.get(Calendar.MONTH);
        estadoNuevoPriorizarDia = c.get(Calendar.DAY_OF_MONTH);
    }
    public void mostrarCalendario(){
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                estadoNuevoPriorizarTxtDate.setText(dayOfMonth+"-"+(month+1)+"-"+year);
            }
        },estadoNuevoPriorizarAño,estadoNuevoPriorizarMes,estadoNuevoPriorizarDia);
        datePickerDialog.show();
    }
    public void cambiarEstadoReporteNuevo(){
        conexion = new Conexion();
        Call<Boolean> call = conexion.getServidor().serverCambiarEstadoReporte(serIdReporte,Constantes.getEstadoPriorizados());
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                callReporteFragment();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Snackbar.make(getView(), "Error ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void callDetalleFragment(){
        detalleReportesFragment = new detalleReportesFragment();
        callFragment(detalleReportesFragment);
    }
    public void callReporteFragment(){
        reportesMainFragment = new reportesMainFragment();
        callFragment(reportesMainFragment);
    }
    public void callFragment(Fragment fragment){
        manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.ContentForFragments,fragment).addToBackStack("tag").commit();
    }
}
