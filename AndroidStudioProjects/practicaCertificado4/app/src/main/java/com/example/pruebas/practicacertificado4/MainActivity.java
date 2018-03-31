package com.example.pruebas.practicacertificado4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Persona> listaPersonasTab1=new ArrayList<>();
    ArrayList<String> listaCedulasPersonaTab1 = new ArrayList<>();

    ArrayList<Persona> listaPersonasTab2=new ArrayList<>();
    ArrayList<String> listaCedulasPersonaTab2 = new ArrayList<>();

    ArrayList<Persona> listaPersonasTab3=new ArrayList<>();
    ArrayList<String> listaCedulasPersonaTab3 = new ArrayList<>();

    DBHelper  myDB;
    TabHost tabHostBase;
    ArrayAdapter<String> adapter;
    ListView listViewTab1,listViewTab2,listViewTab3;
    Spinner spinner;
    String [] opciones = {"mujer","hombre"};
    Bundle bundle;
    String eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DBHelper(this);
        tabHostBase = (TabHost)findViewById(R.id.tabHost);
        listViewTab1=(ListView)findViewById(R.id.listViewTab1);
        listViewTab2=(ListView)findViewById(R.id.listViewTab2);
        listViewTab3=(ListView)findViewById(R.id.listViewTab3);
        spinner=(Spinner)findViewById(R.id.spinnerTab2);

        ///   llenarBase();
        /*
        listaPersonasTab1 = myDB.getInfoEspecifico("hombre");
        Toast.makeText(getApplicationContext(),"len tipo: "+ listaPersonasTab1.size(),Toast.LENGTH_SHORT).show();
        */

        crearTab();
        llenarTab1();
        llenarTab2();
        llenarTab3();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String opcionSeleccionadaSpinner = opciones[i];
                listaPersonasTab2 = myDB.getInfoEspecifico(opcionSeleccionadaSpinner);
                listaCedulasPersonaTab2.clear();
                llenarListViewTab2();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listViewTab1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String opcion = listaCedulasPersonaTab1.get(i);
                Toast.makeText(getApplicationContext(),"opcion: "+opcion,Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void llenarTab3(){
        listaPersonasTab3 = myDB.getInfo();
        listViewTab3.setAdapter(new viewAdapter(this));
    }
    public void llenarListViewTab2(){
        for (int i=0;i<listaPersonasTab2.size();i++){
            listaCedulasPersonaTab2.add(listaPersonasTab2.get(i).getId());
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaCedulasPersonaTab2);
        listViewTab2.setAdapter(adapter);
        listaPersonasTab3 = myDB.getInfo();
    }
    public void llenarTab1(){
        listaPersonasTab1 = myDB.getInfo();
        listaCedulasPersonaTab1.clear();
        for (int i=0;i<listaPersonasTab1.size();i++){
            listaCedulasPersonaTab1.add(listaPersonasTab1.get(i).getId());

        }

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaCedulasPersonaTab1);
        listViewTab1.setAdapter(adapter);

    }
    public void llenarTab2(){
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public void crearTab(){
        tabHostBase.setup();
        TabHost.TabSpec tab1 = tabHostBase.newTabSpec("tab1");
        tab1.setContent(R.id.linearLayout);
        tab1.setIndicator("Lista");

        TabHost.TabSpec tab2 = tabHostBase.newTabSpec("tab2");
        tab2.setContent(R.id.linearLayout2);
        tab2.setIndicator("Spinner");

        TabHost.TabSpec tab3 = tabHostBase.newTabSpec("tab3");
        tab3.setContent(R.id.linearLayout3);
        tab3.setIndicator("Especial");

        tabHostBase.addTab(tab1);
        tabHostBase.addTab(tab2);
        tabHostBase.addTab(tab3);
    }


    @Override
    protected void onResume() {
        llenarTab1();
        llenarTab2();
        llenarTab3();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tabs,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.agregar){
            Intent intent = new Intent(getApplicationContext(),agregar.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void llenarBase(){
        myDB.insertar("1","1","mujer");
    }

    public class viewAdapter extends BaseAdapter{

        LayoutInflater layoutInflater;
        public viewAdapter(Context context){
            layoutInflater = layoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return listaPersonasTab3.size();
        }

        @Override
        public Object getItem(int i) {
            return listaPersonasTab3.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                view = layoutInflater.inflate(R.layout.componente,null);
            }

            final int pos = i;
            final TextView idString =(TextView)view.findViewById(R.id.viewAdapterId);
            final TextView nombreString = (TextView)view.findViewById(R.id.viewAdapterNombre);
            final TextView sexoString = (TextView)view.findViewById(R.id.viewAdapterSexo);
            final Button buttonEditar = (Button)view.findViewById(R.id.viewAdapterEditar);
            final Button buttonEliminar = (Button)view.findViewById(R.id.viewAdapterEliminar);

            idString.setText("ID: "+listaPersonasTab3.get(pos).getId());
            nombreString.setText("Nombre: "+listaPersonasTab3.get(pos).getNombre());
            sexoString.setText("Sexo: "+listaPersonasTab3.get(pos).getSexo());



            buttonEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bundle = new Bundle();
                    bundle.putString("pos",Integer.toString(pos));
                    Intent intent = new Intent(getApplicationContext(),editar.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            buttonEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    eliminar = listaPersonasTab3.get(pos).getId();
                    mensaje();


                }
            });

            return view;
        }
    }
    public void mensaje(){
        AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
        mensaje.setTitle("Confirmar");
        mensaje.setMessage("¿Desea confirmar la eliminacion?");
        mensaje.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myDB.eliminar(eliminar);
                onResume();
            }
        });
        mensaje.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        mensaje.show();
    }
}
