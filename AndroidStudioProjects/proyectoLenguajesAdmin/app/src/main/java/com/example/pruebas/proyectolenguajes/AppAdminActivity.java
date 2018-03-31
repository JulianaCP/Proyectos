package com.example.pruebas.proyectolenguajes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class AppAdminActivity extends AppCompatActivity{



    ListView listViewOpcionesProductosAdmin;
    List<String> listaProductosAdminParaListViewString = new ArrayList<String>();
    ArrayAdapter<String> adapterListaEnListViewOpcionesProductosAdmin;


    //variables

    String nombreProducto;

    int posicionItemPopuMenuPresionado;

    //barra menu
    int idOpcionMenuPresionado;
    MenuInflater inflater;


    @Override
    protected void onResume(){

        /*Metodo para actualizar la pantalla de l usuario con los componentes deseados y su información*/

        obtenerListaDeNombres();
        adapterListaEnListViewOpcionesProductosAdmin = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaProductosAdminParaListViewString);
        listViewOpcionesProductosAdmin.setAdapter(adapterListaEnListViewOpcionesProductosAdmin);
        registerForContextMenu(listViewOpcionesProductosAdmin);
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_admin);
        listViewOpcionesProductosAdmin=(ListView)findViewById(R.id.listViewAdminOpcionesproductosInterface);

        listViewOpcionesProductosAdmin.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Global.posicionItemListViewPresionado = i;
                eliminar(Global.posicionItemListViewPresionado);
                return false;
            }
        });

        listViewOpcionesProductosAdmin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Global.posicionItemListViewPresionado = i;
                showPopupMenu(view);
            }
        });
    }

    ///////////////////////////////////////

    //barra de menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_admin_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        idOpcionMenuPresionado = item.getItemId();
        if(idOpcionMenuPresionado == R.id.itemp_opcion_AgregarProductos){
            mostrarOpcionSeleccionada(AppAdminAgregarProductoActivity.class); //mostrar agregar producto
            return true;
        }
        else{
            mostrarOpcionSeleccionada(AppAdminListaUsuariosActivity.class); //mostrar lista usuarios
            return true;
        }
    }

    //mostrar el activity que se le envia por paramentro
    public void mostrarOpcionSeleccionada(Class mostrarVista){
        Intent intent = new Intent(getApplicationContext(),mostrarVista);
        startActivity(intent);
    }


    ///////////////////////////

    public void showPopupMenu(final View view){
        /*muestra las distintas funciones del popumenu y sus distintas funciones o eventos*/

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                posicionItemPopuMenuPresionado = menuItem.getItemId();
                if(posicionItemPopuMenuPresionado == R.id.itemp_opcionPopu_Editar){
                   Intent intent = new Intent(getApplicationContext(),AppAdminEditarProductosActivity.class);
                    startActivity(intent);
                }
                else{
                   new AlertDialog.Builder(AppAdminActivity.this)

                            .setMessage("¿Confirma la acción seleccionada?")
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
                return true;
            }
        });
        inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu_admin_opciones,popupMenu.getMenu());
        popupMenu.show();
    }

    public void eliminar(int posicion){
        /*Elimina al objeto que posee la posicion enviada por parámetro tanto de la lista gloabl
        como de la base de datos del sistema*/

        final int posicionP= posicion;
        RestAdapter.Builder builder4 = new RestAdapter.Builder()
                .setEndpoint(Global.baseurl)
                .setClient(new OkClient(new OkHttpClient()));// alt intro si da error...
        Global.server = builder4.build().create(Servidor.class);
        Global.server.eliminarProducto(Global.listaProductosObjetos.get(posicion), new Callback<String>() {
            @Override
            public void success(String respuesta, Response response) {
                if (respuesta.equals("si")){
                    Toast.makeText(AppAdminActivity.this,"se ha realizado exitosamente",Toast.LENGTH_SHORT).show();
                    Global.listaProductosObjetos.remove(posicionP);
                    listaProductosAdminParaListViewString.remove(posicionP);
                    adapterListaEnListViewOpcionesProductosAdmin.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(AppAdminActivity.this,"Error al borrar"+respuesta,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(AppAdminActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }


    public void obtenerListaDeNombres(){
        /*introduce dentro de la lista listaProductosAdminParaListViewString todos los nombres de los
        * producctos que se encuentren en la lista global de productos (listaProductosObjetos)*/

        listaProductosAdminParaListViewString.clear();
        for(int i=0;i<Global.listaProductosObjetos.size();i++){
            nombreProducto = Global.listaProductosObjetos.get(i).getNombre();
            listaProductosAdminParaListViewString.add(nombreProducto);
        }
    }
}
