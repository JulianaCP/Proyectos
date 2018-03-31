package com.example.pruebas.practicacertificado2;

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

    ArrayList<Persona> listaPersonas = new ArrayList<>();
    ArrayList<String> listaId = new ArrayList<>();
    ArrayAdapter<String> adapter;
    DBHelper myDB;
    String opcionSeleccionada;

    TabHost tabHost;

    ListView listViewTab1,listViewTab2,listViewTab3;
    Spinner spinner;

    String[] opcionesSpinner = {"mujer","hombre"};
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost=(TabHost)findViewById(R.id.tabHost);
        listViewTab1 = (ListView)findViewById(R.id.listViewTab1);
        myDB= new DBHelper(this);

        listViewTab2 = (ListView)findViewById(R.id.listViewTab2);
        spinner=(Spinner)findViewById(R.id.spinnerTab2);
        listViewTab3 = (ListView)findViewById(R.id.listViewTab3);

        crearTab();
        llenarTab1();
        llenarTab2();
        llenarTab3();


        listViewTab1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"selecciono: "+listaPersonas.get(i).getId(),Toast.LENGTH_LONG).show();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                opcionSeleccionada=opcionesSpinner[i];
                listaPersonas=myDB.getInfoEspecificas(opcionSeleccionada);
                llenarListViewTab2();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    protected void onResume() {
        llenarTab1();
        llenarTab2();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.agregarPersona){
            Intent intent = new Intent(getApplicationContext(),agregar.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void llenarListViewTab2(){
        ArrayList<String> cedulas = new ArrayList<>();
        cedulas=obtenerIdPersonas(listaPersonas);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cedulas);
        listViewTab2.setAdapter(adapter);
    }
    public void crearTab(){
        tabHost.setup();
        TabHost.TabSpec tab1= tabHost.newTabSpec("tab1");
        tab1.setIndicator("Lista");
        tab1.setContent(R.id.linearLayout);

        TabHost.TabSpec tab2= tabHost.newTabSpec("tab2");
        tab2.setIndicator("Seleccion");
        tab2.setContent(R.id.linearLayout2);

        TabHost.TabSpec tab3= tabHost.newTabSpec("tab3");
        tab3.setIndicator("Especial");
        tab3.setContent(R.id.linearLayout3);

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
    }
    public ArrayList<String> obtenerIdPersonas(ArrayList<Persona>lista){
        listaId.clear();
        for (int i=0;i<lista.size();i++){
            listaId.add(lista.get(i).getId());
        }
        return listaId;
    }
    public void llenarTab1(){
        ArrayList<String> cedulas = new ArrayList<>();
        listaPersonas.clear();
        listaPersonas = myDB.getInfo();
        cedulas = obtenerIdPersonas(listaPersonas);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cedulas);
        listViewTab1.setAdapter(adapter);
    }
    public void llenarTab2(){
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcionesSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public class viewAdapter extends BaseAdapter{

        LayoutInflater layoutInflater;
        public viewAdapter(Context context){
            layoutInflater = layoutInflater.from(context); ///////////////////////////////////
        }
        @Override
        public int getCount() {
            return listaPersonas.size();
        }

        @Override
        public Object getItem(int i) {
            return listaPersonas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view=layoutInflater.inflate(R.layout.componente,null);
            }
            final Button buttonEditar = (Button)view.findViewById(R.id.buttonCompoEditar);
            final Button buttonEliminar = (Button)view.findViewById(R.id.buttonCompoEliminar);
            final TextView textViewId =(TextView)view.findViewById(R.id.textViewComponenteId);
            final TextView textViewNombre =(TextView)view.findViewById(R.id.textViewCompoNombre);
            final TextView textViewSexo =(TextView)view.findViewById(R.id.textViewCompoSexo);

            textViewId.setText("Id: "+listaPersonas.get(i).getId());
            textViewNombre.setText("Nombre: "+listaPersonas.get(i).getNombre());
            textViewSexo.setText("Sexo: "+listaPersonas.get(i).getSexo());

            final int pos = i;


            buttonEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bundle=new Bundle();
                    bundle.putString("posicion",Integer.toString(pos));
                    Intent intent = new Intent(getApplicationContext(),editar.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            });
            buttonEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listaPersonas = myDB.getInfo();
                    opcionSeleccionada = Integer.toString(pos);
                    mensaje();
                }
            });

            return view;
        }

    }
    public void mensaje(){
        AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
        mensaje.setMessage("¿Desea Eliminar?");
        mensaje.setTitle("Confirmar");
        mensaje.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                opcionSeleccionada = listaPersonas.get(Integer.parseInt(opcionSeleccionada)).getId();
                myDB.eliminar(opcionSeleccionada);
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
    public void llenarTab3(){
        listaPersonas = myDB.getInfo();
        listViewTab3.setAdapter(new viewAdapter(this));
    }
}

