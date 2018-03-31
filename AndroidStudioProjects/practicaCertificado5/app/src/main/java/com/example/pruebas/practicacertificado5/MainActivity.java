package com.example.pruebas.practicacertificado5;

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
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DBHelper myDB;

    ArrayList<Persona> listaPersonasTab1 = new ArrayList<>();
    ArrayList<String> listaPersonasCedulasTab1 = new ArrayList<>();

    ArrayList<Persona> listaPersonasTab2 = new ArrayList<>();
    ArrayList<String> listaPersonasCedulasTab2 = new ArrayList<>();

    ArrayList<Persona> listaPersonasTab3 = new ArrayList<>();
    ArrayList<String> listaPersonasCedulasTab3 = new ArrayList<>();

    ArrayAdapter<String> adapter;

    TabHost tabHostMenu;
    ListView listViewTab1,listViewTab2,listViewTab3;
    Spinner spinner;
    Bundle bundle;


    String[]opciones={"14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34"};


    String opcionSeleccionadaSpinner;
    String opcionSeleccionadaViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DBHelper(this);
        tabHostMenu = (TabHost)findViewById(R.id.tabHost);
        listViewTab1 = (ListView)findViewById(R.id.listViewTab1);
        listViewTab2 = (ListView)findViewById(R.id.listViewTab2);
        listViewTab3 = (ListView)findViewById(R.id.listViewTab3);
        spinner=(Spinner)findViewById(R.id.spinnerTab2);
        //myDB.insertar("0","Ana","18");

        crearTab();
        llenarTab1();
        llenarTab2();
        llenarTab3();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                opcionSeleccionadaSpinner = opciones[i];

                llenarListViewTab2();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void llenarListViewTab2(){
        listaPersonasCedulasTab2.clear();
        listaPersonasTab2 = myDB.getInfoEspecifico(opcionSeleccionadaSpinner);

        for (int cont = 0;cont<listaPersonasTab2.size();cont++){
            listaPersonasCedulasTab2.add(listaPersonasTab2.get(cont).getId());
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaPersonasCedulasTab2);
        listViewTab2.setAdapter(adapter);

        listaPersonasTab3 = myDB.getInfo();
    }
    public void llenarTab1(){
        listaPersonasTab1 = myDB.getInfo();
        listaPersonasCedulasTab1.clear();
        for (int i = 0;i<listaPersonasTab1.size();i++){
            listaPersonasCedulasTab1.add(listaPersonasTab1.get(i).getId());
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaPersonasCedulasTab1);
        listViewTab1.setAdapter(adapter);
    }
    public void llenarTab2(){

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        llenarTab1();
        llenarTab2();
        llenarTab3();
        super.onResume();
    }

    public void llenarTab3(){
        listaPersonasTab3 = myDB.getInfo();
        listViewTab3.setAdapter(new viewAdapter(this));
    }
    public void crearTab(){
        tabHostMenu.setup();

        TabHost.TabSpec tab1 = tabHostMenu.newTabSpec("tab1");
        tab1.setContent(R.id.linearLayout);
        tab1.setIndicator("Lista");

        TabHost.TabSpec tab2 = tabHostMenu.newTabSpec("tab2");
        tab2.setContent(R.id.linearLayout2);
        tab2.setIndicator("Spinner");

        TabHost.TabSpec tab3 = tabHostMenu.newTabSpec("tab3");
        tab3.setContent(R.id.linearLayout3);
        tab3.setIndicator("viewAdapter");

        tabHostMenu.addTab(tab1);
        tabHostMenu.addTab(tab2);
        tabHostMenu.addTab(tab3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab,menu);
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
            final TextView id = (TextView)view.findViewById(R.id.viewId);
            final TextView nombre = (TextView)view.findViewById(R.id.viewNombre);
            final TextView edad = (TextView)view.findViewById(R.id.viewEdad);

            id.setText("Id: "+listaPersonasTab3.get(pos).getId());
            nombre.setText("Nombre:" +listaPersonasTab3.get(pos).getNombre());
            edad.setText("Edad: "+listaPersonasTab3.get(pos).getEdad());


            final Button buttonEditar = (Button)view.findViewById(R.id.viewEditar);
            final Button buttonEliminar = (Button)view.findViewById(R.id.viewEliminar);


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
                    listaPersonasTab3 = myDB.getInfo();
                    opcionSeleccionadaViewAdapter = listaPersonasTab3.get(pos).getId();
                    mensaje();
                }
            });


            return view;
        }
    }
    public void mensaje(){
        AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
        mensaje.setTitle("Confirmar");
        mensaje.setMessage("¿Desea confirmar?");
        mensaje.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        mensaje.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myDB.eliminar(opcionSeleccionadaViewAdapter);
                onResume();
            }
        });
        mensaje.show();

    }
}
