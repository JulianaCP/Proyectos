package com.example.pruebas.lab4_juliana_campos_parajeles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    Spinner spinner;
    ArrayList<String> listaPlacas = new ArrayList<>();
    BDHelper MyDB;
    ListView listView;
    String opcionSeleccionadaSpinner;
    String opcionSeleccionadaListView;
    Bundle bundle;

    String[] opciones = {"96","97","98","2000","Todos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        spinner = (Spinner)findViewById(R.id.spinner);


        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        MyDB = new BDHelper(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                opcionSeleccionadaSpinner = opciones[i];
                if(opcionSeleccionadaSpinner.equals("Todos")){
                    Global.listaVehiculos = MyDB.getListData();
                    obtenerListaPlacas();
                    llenarListView();
                }
                else{
                    Global.listaVehiculos = MyDB.getData(opcionSeleccionadaSpinner);
                    obtenerListaPlacas();
                    llenarListView();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                opcionSeleccionadaListView = Integer.toString(i);
                bundle = new Bundle();
                bundle.putString("posicion",opcionSeleccionadaListView);
                Intent intent = new Intent(getApplicationContext(),ConsultarActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.opcion_agregar){
            Intent intent = new Intent(getApplicationContext(),AgregarActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void llenarListView(){
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaPlacas));
    }


    public void obtenerListaPlacas(){
        listaPlacas.clear();
        for (int i=0;i<Global.listaVehiculos.size();i++){
            listaPlacas.add(Global.listaVehiculos.get(i).getPlaca());
        }
    }

    @Override
    protected void onResume() {
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        super.onResume();
    }
}
