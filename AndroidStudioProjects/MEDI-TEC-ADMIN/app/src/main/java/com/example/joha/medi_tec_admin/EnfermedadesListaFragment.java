package com.example.joha.medi_tec_admin;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnfermedadesListaFragment extends Fragment {
    private View rootView;
    ListView enfermedades_lista_listView_enfermedades;
    Bundle bundle;
    ArrayAdapter<String> adapter;
    ArrayList<Enfermedad> arrayListEnfermedadesClass;
    ArrayList<String> arrayListEnfermedadesString;
    int posicionItemPopuMenuPresionado;
    int idEnfermedad;
    MenuInflater inflayer;

    public EnfermedadesListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment}
        rootView = inflater.inflate(R.layout.fragment_enfermedades_lista, container, false);
        enfermedades_lista_listView_enfermedades = (ListView) rootView.findViewById(R.id.enfermedades_lista_listView_enfermedades);
        //llenarGlobal();
        obtenerDatos();
        enfermedades_lista_listView_enfermedades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Global.posicionItemListViewPresionado = i;
                showPopupMenu(view);
            }
        });

        FloatingActionButton btnAgregarMedicamento = (FloatingActionButton) rootView.findViewById(R.id.btnAgregarEnfermedad);
        btnAgregarMedicamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarEnfermedadFragment agregarEnfermedadFragment = new AgregarEnfermedadFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.ContentForFragments, agregarEnfermedadFragment).commit();
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        obtenerDatos();
        super.onResume();
    }
    public void obtenerDatos(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Global.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Servidor servidor = retrofit.create(Servidor.class);

        Call<ArrayList<Enfermedad>> call= servidor.obtenerListaEnfermedades();

        call.enqueue(new Callback<ArrayList<Enfermedad>>() {
            @Override
            public void onResponse(Call<ArrayList<Enfermedad>> call, Response<ArrayList<Enfermedad>> response) {
                Global.listaEnfermedades = response.body();
                llenarListViewEnfermedades();
            }

            @Override
            public void onFailure(Call<ArrayList<Enfermedad>> call, Throwable t) {
                Snackbar.make(getView(), "Fallo: "+ t.getMessage(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void llenarListViewEnfermedades(){
        arrayListEnfermedadesClass = Global.listaEnfermedades;
        arrayListEnfermedadesString = convertirClass_String();
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,arrayListEnfermedadesString);
        enfermedades_lista_listView_enfermedades.setAdapter(adapter);
    }

    public ArrayList<String> convertirClass_String(){
        ArrayList<String> listaTemp = new ArrayList<String>();
        String valor;

        for (int i=0;i<arrayListEnfermedadesClass.size();i++){
            valor = arrayListEnfermedadesClass.get(i).getNombre();
            listaTemp.add(valor);
        }

        return listaTemp;
    }

    public void showPopupMenu(final View view){

        PopupMenu popupMenu = new PopupMenu(getActivity(), view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                posicionItemPopuMenuPresionado = menuItem.getItemId();
                if(posicionItemPopuMenuPresionado == R.id.menuOpcionEditarEnfermedad){

                    /*bundle = new Bundle();
                    bundle.putString("valor",Integer.toString(Global.posicionItemListViewPresionado));
                    Intent intent = new Intent(getApplicationContext(),editar_enfermedades.class);
                    intent.putExtras(bundle);
                    startActivity(intent);*/
                    EditarEnfermedadFragment editarEnfermedadFragment = new EditarEnfermedadFragment();
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.ContentForFragments, editarEnfermedadFragment).commit();
                }
                else if(posicionItemPopuMenuPresionado == R.id.menuOpcionEliminarEnfermedad){
                    new AlertDialog.Builder(getActivity())

                            .setMessage("¿Desea Eliminar?")
                            .setTitle("Confirmacion")
                            .setPositiveButton("Confirmar", new DialogInterface.OnClickListener()  {
                                public void onClick(DialogInterface dialog, int id) {
                                    Log.i("Dialogos", "Elemento Eliminado.");
                                    dialog.cancel();
                                    eliminar(Global.posicionItemListViewPresionado);

                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Log.i("Dialogos", "Confirmacion Cancelada.");
                                    dialog.cancel();
                                }
                            }).create().show();

                }
                else{
                    asignarSintomaEnfermedadFragment asignarSintomaEnfermedadFragment = new asignarSintomaEnfermedadFragment();
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.ContentForFragments, asignarSintomaEnfermedadFragment).commit();
                }
                return true;
            }
        });
        inflayer = getActivity().getMenuInflater();
        inflayer.inflate(R.menu.popup_menu_enfermedad,popupMenu.getMenu());
        popupMenu.show();
    }
    public void eliminar(int posicion){
        idEnfermedad=Global.listaEnfermedades.get(posicion).getIdEnfermedad();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Global.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Servidor servidor = retrofit.create(Servidor.class);
        Call<Boolean> call = servidor.eliminarEnfermedad(idEnfermedad);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Snackbar.make(getView(), "Eliminacion exitosa", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                onResume();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Snackbar.make(getView(), "Error eliminacion", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

}
