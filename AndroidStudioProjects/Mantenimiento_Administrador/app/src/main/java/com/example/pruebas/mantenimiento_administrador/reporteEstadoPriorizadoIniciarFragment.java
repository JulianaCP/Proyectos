package com.example.pruebas.mantenimiento_administrador;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class reporteEstadoPriorizadoIniciarFragment extends Fragment {

    private ArrayList<Usuario> listaTecnicos = new ArrayList<>();
    private ArrayList<Usuario> listaTecnicosSeleccionados = new ArrayList<>();
    private ArrayList<String> listaTecnicosString = new ArrayList<String>();
    private ArrayList<String> listaTecnicosSeleccionadosString = new ArrayList<String>();



    private int estadoPriorizadoInicioElementoSelecionadoListView;

    private View rootView;
    private Conexion conexion;

    private Usuario usuario;


    private String estadoPriorizadoIniciarNombreUsuario;
    private ListView estadoPriorizadoIniciarListViewTecnicos,estadoPriorizadoIniciarListViewSeleccionados;

    private Button estadoPriorizadoIniciarButtonAceptar,estadoPriorizadoIniciarButtonCancelar;
    ArrayAdapter<String> adapter;

    private int serId;




    //fragments

    private reportesMainFragment reportesMainFragment;
    private detalleReportesFragment detalleReportesFragment;
    private FragmentManager manager;



    public reporteEstadoPriorizadoIniciarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_reporte_estado_priorizado_iniciar, container, false);

        estadoPriorizadoIniciarListViewSeleccionados = (ListView)rootView.findViewById(R.id.estadoPriorizadoIniciarListViewSeleccionados);
        estadoPriorizadoIniciarListViewTecnicos = (ListView)rootView.findViewById(R.id.estadoPriorizadoIniciarListViewTecnicos);
        estadoPriorizadoIniciarButtonAceptar = (Button)rootView.findViewById(R.id.estadoPriorizadoIniciarButtonAceptar);
        estadoPriorizadoIniciarButtonCancelar = (Button)rootView.findViewById(R.id.estadoPriorizadoIniciarButtonCancelar);

        serId = Global.getListaReportes().get(Global.getPosicionListView()).getId();


        llenarListViewTecnicosSeleccionados();
        obtenerListaUsuariosTecnicos();

        estadoPriorizadoIniciarButtonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listaTecnicosSeleccionados.size() != 0){
                    for(int i=0;i<listaTecnicosSeleccionados.size();i++){
                        System.out.println("idReporte: " + serId + " nombreUsuario: " +listaTecnicosSeleccionados.get(i).getNombreUsuario() );

                        conexion = new Conexion();
                        Call<Boolean> call = conexion.getServidor().serverAsignarTecnicoServidor(serId
                                ,listaTecnicosSeleccionados.get(i).getNombreUsuario());
                        call.enqueue(new Callback<Boolean>() {
                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                System.out.println("inserto tecnico");
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                System.out.println("no inserto tecnico");
                            }
                        });
                    }

                    Snackbar.make(view, "Asignado exitosamente", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    cambiarEstadoReportePriorizado();
                }
                else{
                    Snackbar.make(view, "No existen tecnicos asociados", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        estadoPriorizadoIniciarButtonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDetalleFragment();
            }
        });
        estadoPriorizadoIniciarListViewTecnicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                estadoPriorizadoInicioElementoSelecionadoListView = i;
                showPopupMenu(view,R.menu.estado_priorizado_iniciar_popup_menu_tecnicos);
            }
        });
        estadoPriorizadoIniciarListViewSeleccionados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                estadoPriorizadoInicioElementoSelecionadoListView = i;
                showPopupMenu(view,R.menu.estado_priorizado_iniciar_popup_menu_asignados);
            }
        });

        return rootView;
    }

    public void llenarListViewTecnicosSeleccionados(){
        listaTecnicosSeleccionadosString = obtenerArrayListaString(listaTecnicosSeleccionados);
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.simple_linear_layout
                , listaTecnicosSeleccionadosString);
        estadoPriorizadoIniciarListViewSeleccionados.setAdapter(adapter);
    }

    public void obtenerListaUsuariosTecnicos(){
        conexion = new Conexion();
        Call<ArrayList<Usuario>> call = conexion.getServidor().serverObtenerListaUsuarios(Constantes.getTipoUsurioTecnico());
        call.enqueue(new Callback<ArrayList<Usuario>>() {
            @Override
            public void onResponse(Call<ArrayList<Usuario>> call, Response<ArrayList<Usuario>> response) {
                listaTecnicos = response.body();
                removerElementosSeleccionados();
                llenarListViewTecnicos();
            }

            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                Snackbar.make(getView(), "Proceso Fallido", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void removerElementosSeleccionados(){
        for (int i=0;i<listaTecnicosSeleccionados.size();i++){
            for (int x=0;x<listaTecnicos.size();x++){
                if(listaTecnicos.get(x).getNombreUsuario().equals(listaTecnicosSeleccionados.get(i).getNombreUsuario())){
                    listaTecnicos.remove(x);
                }
            }
        }
    }
    public void llenarListViewTecnicos(){
        listaTecnicosString =  obtenerArrayListaString(listaTecnicos);
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.simple_linear_layout
                , listaTecnicosString);
        estadoPriorizadoIniciarListViewTecnicos.setAdapter(adapter);

    }
    public ArrayList<String> obtenerArrayListaString(ArrayList<Usuario> lista){
        ArrayList<String> temp = new ArrayList<>();
        for (int i=0;i<lista.size();i++){
            estadoPriorizadoIniciarNombreUsuario = lista.get(i).getApellido1() +" "+ lista.get(i).getApellido2() +" "+
                    lista.get(i).getNombre();
            temp.add(estadoPriorizadoIniciarNombreUsuario);
        }
        return temp;
    }
    public void showPopupMenu(final View view, int popupMenu){
        PopupMenu popup = new PopupMenu(getActivity().getApplicationContext(), view);
        popup.getMenuInflater().inflate(popupMenu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case  R.id.estado_nuevo_priorizado_popup_tecnicos_Asignar:
                        System.out.println("estado_nuevo_priorizado_popup_tecnicos_Asignar");
                        usuario = listaTecnicos.get(estadoPriorizadoInicioElementoSelecionadoListView);
                        listaTecnicosSeleccionados.add(usuario);
                        listaTecnicos.remove(estadoPriorizadoInicioElementoSelecionadoListView);
                        llenarListViewTecnicos();
                        llenarListViewTecnicosSeleccionados();
                        return true;
                    case  R.id.estado_nuevo_priorizado_popup_Asignados_Eliminar:
                        usuario = listaTecnicosSeleccionados.get(estadoPriorizadoInicioElementoSelecionadoListView);
                        listaTecnicos.add(usuario);
                        listaTecnicosSeleccionados.remove(estadoPriorizadoInicioElementoSelecionadoListView);
                        llenarListViewTecnicosSeleccionados();
                        obtenerListaUsuariosTecnicos();
                        return true;
                }
                return true;
            }
        });
        popup.show();
    }

    public void cambiarEstadoReportePriorizado(){
        conexion = new Conexion();
        Call<Boolean> call = conexion.getServidor().serverCambiarEstadoReporte(serId,Constantes.getEstadoEnProceso());
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                callReporteMainFragment();
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
    public void callReporteMainFragment(){
        reportesMainFragment = new reportesMainFragment();
        callFragment(reportesMainFragment);
    }
    public void callFragment(Fragment fragment){
        manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.ContentForFragments,fragment).addToBackStack("tag").commit();
    }
}
