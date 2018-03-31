package com.example.pruebas.mantenimiento_administrador;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class reportesMainFragment extends Fragment {

    private String reportesMainRadioButtonChecked = "";


    private View rootView;
    private ListView reportesMainListViewReportes;
    private RadioButton reportesMainRadioButtonNuevos,reportesMainRadioButtonPriorizados,reportesMainRadioButtonEnProceso
            ,reportesMainRadioButtonFinalizados;
    private Conexion conexion;

    private String reportesMainTipoPopupSeleccionado = "";



    //fragments

    private detalleReportesFragment detalleReportesFragment;
    private FragmentManager manager;



    public reportesMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_reportes_main, container, false);

        reportesMainListViewReportes = (ListView)rootView.findViewById(R.id.reportesMainListViewReportes);

        reportesMainRadioButtonNuevos = (RadioButton)rootView.findViewById(R.id.reportesMainRadioButtonNuevos);
        reportesMainRadioButtonPriorizados = (RadioButton)rootView.findViewById(R.id.reportesMainRadioButtonPriorizados);
        reportesMainRadioButtonEnProceso = (RadioButton)rootView.findViewById(R.id.reportesMainRadioButtonEnProceso);
        reportesMainRadioButtonFinalizados = (RadioButton)rootView.findViewById(R.id.reportesMainRadioButtonFinalizados);


        obtenerEstadoRadioButton();
        llenarArrayListReportes();

        reportesMainRadioButtonEnProceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reportesMainTipoPopupSeleccionado = "";
                reportesMainRadioButtonEnProceso.setChecked(true);
                reportesMainRadioButtonPriorizados.setChecked(false);
                reportesMainRadioButtonNuevos.setChecked(false);
                reportesMainRadioButtonFinalizados.setChecked(false);
                Global.setTipoReporteSeleccionado(Constantes.getEstadoEnProceso());
                obtenerEstadoRadioButton();
                llenarArrayListReportes();

            }
        });
        reportesMainRadioButtonNuevos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reportesMainTipoPopupSeleccionado = "";
                reportesMainRadioButtonNuevos.setChecked(true);
                reportesMainRadioButtonPriorizados.setChecked(false);
                reportesMainRadioButtonEnProceso.setChecked(false);
                reportesMainRadioButtonFinalizados.setChecked(false);
                Global.setTipoReporteSeleccionado(Constantes.getEstadoNuevo());
                obtenerEstadoRadioButton();
                llenarArrayListReportes();
            }
        });
        reportesMainRadioButtonFinalizados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!reportesMainTipoPopupSeleccionado.equals(Constantes.getEstadoCancelados())
                        && !reportesMainTipoPopupSeleccionado.equals(Constantes.getEstadoFinalizados())){
                    reportesMainRadioButtonFinalizados.setChecked(false);
                }

                showPopupMenu(view,R.menu.reportes_main_popup_menu_terminados);
            }
        });
        reportesMainRadioButtonPriorizados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!reportesMainTipoPopupSeleccionado.equals(Constantes.getEstadoPriorizadosAdmin())
                        && !reportesMainTipoPopupSeleccionado.equals(Constantes.getEstadoPriorizadosFecha())){
                    reportesMainRadioButtonPriorizados.setChecked(false);
                }

                showPopupMenu(view,R.menu.reportes_main_popup_menu_priorizados);
            }
        });

        reportesMainListViewReportes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Global.setPosicionListView(i);
                Global.setTipoReporteSeleccionado(Global.getListaReportes().get(i).getEstadoReporte());
                detalleReportesFragment = new detalleReportesFragment();
                callFragment(detalleReportesFragment);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        obtenerEstadoRadioButton();
        llenarArrayListReportes();
        super.onResume();
    }
    public void llenarArrayListReportes(){

        if(reportesMainRadioButtonChecked.equals(Constantes.getEstadoPriorizados())){
            conexion = new Conexion();
            Call<ArrayList<Reporte>> call = conexion.getServidor().serverObtenerListaReportesPriorizadosSegunFiltro(Global.getTipoReporteSeleccionadoPopup());
            call.enqueue(new Callback<ArrayList<Reporte>>() {
                @Override
                public void onResponse(Call<ArrayList<Reporte>> call, Response<ArrayList<Reporte>> response) {
                    Global.setListaReportes(response.body());
                    llenarListView();
                }
                @Override
                public void onFailure(Call<ArrayList<Reporte>> call, Throwable t) {
                    System.out.println("\n\n\n\nFAIL_primero " + "\n\n\n");
                }
            });
        }
        else{
            System.out.println("\n\n\n\nreportesMainRadioButtonChecked: " +reportesMainRadioButtonChecked+ "\n\n\n");
            conexion = new Conexion();
            Call<ArrayList<Reporte>> call = conexion.getServidor().serverObtenerListaReportesSegunEstado(reportesMainRadioButtonChecked);
            call.enqueue(new Callback<ArrayList<Reporte>>() {
                @Override
                public void onResponse(Call<ArrayList<Reporte>> call, Response<ArrayList<Reporte>> response) {
                    Global.setListaReportes(response.body());
                    llenarListView();
                }
                @Override
                public void onFailure(Call<ArrayList<Reporte>> call, Throwable t) {

                    System.out.println("\n\n\n\nFAIL " + t.getCause()+ "\n\n\n");
                }
            });
        }
    }
    public void llenarListView(){
        reportesMainListViewReportes.setAdapter(new viewAdapter(getActivity().getApplicationContext()));
    }
    public void obtenerEstadoRadioButton(){
        if(reportesMainRadioButtonNuevos.isChecked()){
            reportesMainRadioButtonChecked = Constantes.getEstadoNuevo();
        }
        else if(reportesMainRadioButtonPriorizados.isChecked()){
            reportesMainRadioButtonChecked = Constantes.getEstadoPriorizados();
        }
        else if(reportesMainRadioButtonEnProceso.isChecked()){
            reportesMainRadioButtonChecked = Constantes.getEstadoEnProceso();
        }
        else if(reportesMainRadioButtonFinalizados.isChecked()){
            reportesMainRadioButtonChecked = Global.getTipoReporteSeleccionadoPopup();
        }
    }
    public void showPopupMenu(final View view, int popupMenu){
        PopupMenu popup = new PopupMenu(getActivity().getApplicationContext(), view);
        popup.getMenuInflater().inflate(popupMenu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case  R.id.reportes_main_popup_priorizados_fecha:
                        reportesMainTipoPopupSeleccionado = Constantes.getEstadoPriorizadosFecha();
                        Global.setTipoReporteSeleccionadoPopup(Constantes.getEstadoPriorizadosFecha());
                        actualizarCheckPriorizados();
                        return true;
                    case  R.id.reportes_main_popup_priorizados_admin:
                        reportesMainTipoPopupSeleccionado = Constantes.getEstadoPriorizadosAdmin();
                        Global.setTipoReporteSeleccionadoPopup(Constantes.getEstadoPriorizadosAdmin());
                        actualizarCheckPriorizados();
                        return true;
                    case R.id.reportes_main_popup_terminados_cancelados:
                        reportesMainTipoPopupSeleccionado = Constantes.getEstadoCancelados();
                        Global.setTipoReporteSeleccionadoPopup(Constantes.getEstadoCancelados());
                        actualizarCheckFinalizados();
                        return true;
                    case R.id.reportes_main_popup_terminados_finalizados:
                        reportesMainTipoPopupSeleccionado = Constantes.getEstadoFinalizados();
                        Global.setTipoReporteSeleccionadoPopup(Constantes.getEstadoFinalizados());
                        actualizarCheckFinalizados();
                        return true;
                }
                return true;
            }
        });
        popup.show();
    }
    public void actualizarCheckPriorizados(){
        reportesMainRadioButtonPriorizados.setChecked(true);
        reportesMainRadioButtonFinalizados.setChecked(false);
        reportesMainRadioButtonEnProceso.setChecked(false);
        reportesMainRadioButtonNuevos.setChecked(false);

        obtenerEstadoRadioButton();
        llenarArrayListReportes();
    }
    public void actualizarCheckFinalizados(){
        reportesMainRadioButtonFinalizados.setChecked(true);
        reportesMainRadioButtonPriorizados.setChecked(false);
        reportesMainRadioButtonEnProceso.setChecked(false);
        reportesMainRadioButtonNuevos.setChecked(false);
        obtenerEstadoRadioButton();
        llenarArrayListReportes();
    }

    public class viewAdapter extends BaseAdapter {
        LayoutInflater layoutInflater;
        public viewAdapter(Context context){
            layoutInflater = layoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return Global.getListaReportes().size();
        }

        @Override
        public Object getItem(int i) {
            return Global.getListaReportes().get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view = layoutInflater.inflate(R.layout.reportes_main_componente_listview,null);
            }
            final int posicionListView = i;
            final TextView tituloId = (TextView)view.findViewById(R.id.reportes_main_componente_label_titulo_id);
            final TextView tituloSolicitante = (TextView)view.findViewById(R.id.reportes_main_componente_label_titulo_solicitante);
            final TextView tituloLaboratorio = (TextView)view.findViewById(R.id.reportes_main_componente_label_titulo_lab);

            final TextView serId = (TextView)view.findViewById(R.id.reportes_main_componente_label_ser_id);
            final TextView serSolicitante = (TextView)view.findViewById(R.id.reportes_main_componente_label_ser_solicitante);
            final TextView serLaboratorio = (TextView)view.findViewById(R.id.reportes_main_componente_label_ser_lab);

            serId.setText(Integer.toString(Global.getListaReportes().get(posicionListView).getId()));
            serSolicitante.setText(Global.getListaReportes().get(posicionListView).getNombre());
            serLaboratorio.setText(Global.getListaReportes().get(posicionListView).getEstablecimiento());

            tituloId.setTextColor(getResources().getColor(R.color.colorNegro));
            tituloLaboratorio.setTextColor(getResources().getColor(R.color.colorNegro));
            tituloSolicitante.setTextColor(getResources().getColor(R.color.colorNegro));
            serId.setTextColor(getResources().getColor(R.color.colorNegro));
            serSolicitante.setTextColor(getResources().getColor(R.color.colorNegro));
            serLaboratorio.setTextColor(getResources().getColor(R.color.colorNegro));
            return view;
        }
    }

    public void callFragment(Fragment fragment){
        manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.ContentForFragments,fragment).addToBackStack("tag").commit();
    }
}

