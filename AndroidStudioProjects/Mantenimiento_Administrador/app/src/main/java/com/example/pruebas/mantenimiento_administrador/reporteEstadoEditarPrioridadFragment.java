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
public class reporteEstadoEditarPrioridadFragment extends Fragment {

    private int estadoPriorizadoDia, estadoPriorizadoMes, estadoPriorizadoAño;
    private DatePickerDialog datePickerDialog;
    private View rootView;
    private LinearLayout estadoPriorizadoEditarLinearLayoutFecha;
    private Button estadoPriorizadoEditarButtonAceptar,estadoPriorizadoEditarButtonCancelar;
    private RadioButton estadoPriorizadoEditarRadioAlto,estadoPriorizadoEditarRadioMedio,estadoPriorizadoEditarRadioBajo;
    private TextView estadoPriorizadoEditarTXT_Fecha;


    private int serId;
    private Conexion conexion;
    private String serFechaFinalizacion,serNivelPrioridad;


    //fragments

    private reportesMainFragment reportesMainFragment;
    private detalleReportesFragment detalleReportesFragment;
    private FragmentManager manager;



    public reporteEstadoEditarPrioridadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_reporte_estado_editar_prioridad, container, false);


        estadoPriorizadoEditarButtonAceptar = (Button)rootView.findViewById(R.id.estadoPriorizadoEditarButtonAceptar);
        estadoPriorizadoEditarButtonCancelar = (Button)rootView.findViewById(R.id.estadoPriorizadoEditarButtonCancelar);
        estadoPriorizadoEditarRadioAlto = (RadioButton)rootView.findViewById(R.id.estadoPriorizadoEditarRadioButtonAlto);
        estadoPriorizadoEditarRadioMedio = (RadioButton)rootView.findViewById(R.id.estadoPriorizadoEditarRadioButtonMedio);
        estadoPriorizadoEditarRadioBajo = (RadioButton)rootView.findViewById(R.id.estadoPriorizadoEditarRadioButtonBajo);
        estadoPriorizadoEditarTXT_Fecha = (TextView)rootView.findViewById(R.id.estadoPriorizadoEditarLabelDate);

        estadoPriorizadoEditarLinearLayoutFecha = (LinearLayout)rootView.findViewById(R.id.estadoPriorizadoEditarLinearLayoutFecha);




        serId = Global.getListaReportes().get(Global.getPosicionListView()).getId();
        serFechaFinalizacion = Global.getListaReportes().get(Global.getPosicionListView()).getFechaFinalizacion();
        serNivelPrioridad = Global.getListaReportes().get(Global.getPosicionListView()).getPrioridadReporte();

        marcarRadioButton();
        estadoPriorizadoEditarTXT_Fecha.setText(serFechaFinalizacion);




        estadoPriorizadoEditarButtonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(estadoPriorizadoEditarRadioAlto.isChecked()){
                    serNivelPrioridad = Constantes.getImportanciaReporteAlto();
                }
                else if(estadoPriorizadoEditarRadioMedio.isChecked()){
                    serNivelPrioridad = Constantes.getImportanciaReporteMedio();
                }
                else{
                    serNivelPrioridad = Constantes.getImportanciaReporteBajo();
                }

                conexion = new Conexion();
                System.out.println("serID: " + serId);
                Call<Boolean> call = conexion.getServidor().serverActualizarPrioridadReporte(serId
                        ,estadoPriorizadoEditarTXT_Fecha.getText().toString(),serNivelPrioridad);
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Snackbar.make(view, "Asignacion Prioridad Exitosa", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        callReporteMainFragment();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Snackbar.make(view, "Proceso Fallido", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
        });

        estadoPriorizadoEditarButtonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDetalleFragment();
            }
        });

        obtenerFecha();
        estadoPriorizadoEditarLinearLayoutFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarCalendario();
            }
        });


        return rootView;
    }
    public void marcarRadioButton(){
        if(serNivelPrioridad.equals(Constantes.getImportanciaReporteAlto())){
            estadoPriorizadoEditarRadioAlto.setChecked(true);
        }
        else if(serNivelPrioridad.equals(Constantes.getImportanciaReporteMedio())){
            estadoPriorizadoEditarRadioMedio.setChecked(true);
        }
        else{
            estadoPriorizadoEditarRadioBajo.setChecked(true);
        }
    }
    public void obtenerFecha(){
        Calendar c = Calendar.getInstance();
        estadoPriorizadoAño = c.get(Calendar.YEAR);
        estadoPriorizadoMes = c.get(Calendar.MONTH);
        estadoPriorizadoDia = c.get(Calendar.DAY_OF_MONTH);
    }
    public void mostrarCalendario(){
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                estadoPriorizadoEditarTXT_Fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },estadoPriorizadoAño,estadoPriorizadoMes,estadoPriorizadoDia);
        datePickerDialog.show();
    }


    public void callDetalleFragment(){
        detalleReportesFragment = new detalleReportesFragment();
        callFragment(detalleReportesFragment);
    }
    public void callReporteMainFragment(){
        reportesMainFragment = new reportesMainFragment();
        callFragment(reportesMainFragment);
    }
    public void callFragment(Fragment fragment){
        manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.ContentForFragments,fragment).addToBackStack("tag").commit();
    }

}
