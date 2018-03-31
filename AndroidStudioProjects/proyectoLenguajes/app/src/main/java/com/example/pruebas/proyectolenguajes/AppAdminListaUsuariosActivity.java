package com.example.pruebas.proyectolenguajes;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AppAdminListaUsuariosActivity extends AppCompatActivity {

    MenuInflater inflater;

    ListView listView;
    viewAdapter adaptador;


    String userLogin;
    //variable
    int posicionItemPresionadoMenuUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios_admin);
        listView=(ListView)findViewById(R.id.listViewListaUsuarios);

        crearLista();
        adaptador = new viewAdapter(AppAdminListaUsuariosActivity.this);
        listView.setAdapter(adaptador);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_admin_agregar_usuario,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        posicionItemPresionadoMenuUsuarios = item.getItemId();
        if(posicionItemPresionadoMenuUsuarios == R.id.itempOpcionAgregarListaUsuarios){
            Intent intent = new Intent(getApplicationContext(),AppAdminAgregarUsuariosListaUsuariosActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
    public void crearLista(){
        Global.listaClientesCreada.clear();
        for (int i=0;i<Global.listaUsuarios.size();i++){
            if(Global.listaUsuarios.get(i).getPermiso().equals(Global.permisosCliente)){
                Global.listaClientesCreada.add((Cliente)Global.listaUsuarios.get(i));
            }
        }
    }

    public void actualizarUsuario(){


        for (int i=0;i<Global.listaClientesCreada.size();i++){
            if(i == Global.posListViewPersonalizado){
                userLogin=Global.listaClientesCreada.get(i).getLogin();
                break;
            }
        }
        for (int i=0;i<Global.listaUsuarios.size();i++){
            if(Global.listaUsuarios.get(i).getLogin().equals(userLogin)){
                Global.listaUsuarios.remove(i);
                break;
            }
        }
    }

    public class viewAdapter extends BaseAdapter{
        LayoutInflater mInflater;
        public viewAdapter(Context context){
            mInflater= LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return Global.listaClientesCreada.size();
        }

        @Override
        public Object getItem(int i) {
            return Global.listaClientesCreada.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view==null){
                view=mInflater.inflate(R.layout.componente_usuarios,null);
            }

            TextView nombre = (TextView)view.findViewById(R.id.textViewNombreComponene);
            TextView login = (TextView)view.findViewById(R.id.textViewLoginComponente);
            TextView fechaRegistro = (TextView)view.findViewById(R.id.textViewFechaRegistroComponente);
            TextView ultimoRegistro = (TextView)view.findViewById(R.id.textViewFechaUltimoLoginComponente);


            nombre.setText(Global.listaClientesCreada.get(i).getNombre());
            login.setText(Global.listaClientesCreada.get(i).getLogin());
            fechaRegistro.setText(Global.listaClientesCreada.get(i).getFechaRegistro());
            ultimoRegistro.setText(Global.listaClientesCreada.get(i).getUltimoLogin());


            Button buttonEditar;
            Button buttonEliminar;
            Button buttonCall;

            buttonEditar=(Button)view.findViewById(R.id.buttonComponenteEditar);
            buttonEliminar=(Button)view.findViewById(R.id.buttonComponenteEliminar);
            buttonCall=(Button)view.findViewById(R.id.buttonComponenteLlamar);
            buttonEditar.setText("Editar");
            buttonEliminar.setText("Eliminar");
            buttonCall.setText("Llamar");

            buttonEditar.setTag(i);
            buttonEliminar.setTag(i);
            buttonCall.setTag(i);


            buttonEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Global.posListViewPersonalizado = (Integer) view.getTag();

                    Intent intent = new Intent(getApplicationContext(),AppAdminEditarUsuariosListaUsuariosActivity.class);
                    startActivity(intent);
                }
            });

            buttonEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Global.posListViewPersonalizado = (Integer) view.getTag();
                    new AlertDialog.Builder(AppAdminListaUsuariosActivity.this)

                            .setMessage("¿Confirma la acción seleccionada?")
                            .setTitle("Confirmacion")
                            .setPositiveButton("Confirmar", new DialogInterface.OnClickListener()  {
                                public void onClick(DialogInterface dialog, int id) {
                                    Log.i("Dialogos", "Elemento Eliminado.");
                                    dialog.cancel();
                                    actualizarUsuario();
                                    Global.listaClientesCreada.remove(Global.posListViewPersonalizado);
                                    adaptador = new viewAdapter(AppAdminListaUsuariosActivity.this);
                                     ///////////////////////////////////////malo ahi que actualizar
                                    listView.setAdapter(adaptador);
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Log.i("Dialogos", "Confirmacion Cancelada.");
                                    dialog.cancel();
                                }
                            }).create().show();
                }
            });

            buttonCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Global.posListViewPersonalizado = (Integer) view.getTag();
                    String varTelefono = Global.listaClientesCreada.get(Global.posListViewPersonalizado).getTelefono();
                    Toast.makeText(getApplicationContext(),"pos: " + Global.posListViewPersonalizado ,Toast.LENGTH_SHORT).show();

                    try {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+varTelefono));

                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(getApplicationContext(),"No hay permisos para llamadas",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{
                            startActivity(intent);
                        }

                    }catch (ActivityNotFoundException e){
                        Toast.makeText(getApplicationContext(),"Error al llamar",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return view;
        }
    }

}
