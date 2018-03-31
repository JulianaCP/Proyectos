package com.example.pruebas.mantenimiento_administrador;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class reporteEstadoEnProcesoEstadoFragment extends Fragment {


    public reporteEstadoEnProcesoEstadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reporte_estado_en_proceso_estado, container, false);
    }

}
