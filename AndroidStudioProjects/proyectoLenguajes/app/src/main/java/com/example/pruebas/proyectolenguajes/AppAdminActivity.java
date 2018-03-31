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

import java.util.ArrayList;
import java.util.List;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_admin);

        listViewOpcionesProductosAdmin=(ListView)findViewById(R.id.listViewAdminOpcionesproductosInterface);

        ///////////////////
        //temporal mientras obtengo lo del servidor
        ////////////////////

        obtenerListaDeNombres();


        adapterListaEnListViewOpcionesProductosAdmin = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaProductosAdminParaListViewString);
        listViewOpcionesProductosAdmin.setAdapter(adapterListaEnListViewOpcionesProductosAdmin);
        registerForContextMenu(listViewOpcionesProductosAdmin);

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
        Toast.makeText(getApplicationContext(),"entro id:"+ idOpcionMenuPresionado,Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(getApplicationContext(),"posicionItemListViewPresionado: "+ Global.posicionItemListViewPresionado ,Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getApplicationContext(),"len: "+ listaProductosAdminParaListViewString.size() ,Toast.LENGTH_SHORT).show();

                                    dialog.cancel();
                                    eliminar(Global.posicionItemListViewPresionado);
                                    Toast.makeText(getApplicationContext(),"len: "+ listaProductosAdminParaListViewString.size() ,Toast.LENGTH_SHORT).show();

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
        Global.listaProductosObjetos.remove(posicion);
        listaProductosAdminParaListViewString.remove(posicion);
        adapterListaEnListViewOpcionesProductosAdmin.notifyDataSetChanged();
    }


    public void obtenerListaDeNombres(){
        listaProductosAdminParaListViewString.clear();
        for(int i=0;i<Global.listaProductosObjetos.size();i++){
            nombreProducto = Global.listaProductosObjetos.get(i).getNombre();
            listaProductosAdminParaListViewString.add(nombreProducto);
        }
    }
}
