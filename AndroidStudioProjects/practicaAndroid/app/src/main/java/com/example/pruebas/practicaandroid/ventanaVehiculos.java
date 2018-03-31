package com.example.pruebas.practicaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ventanaVehiculos extends AppCompatActivity {


    ListView listView;

    ArrayAdapter<String> arrayAdapterLista;
    ArrayList<VehiculoClass> arrayListVehiculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_vehiculos);

        listView = (ListView)findViewById(R.id.listViewListaVehiculos);
        String nombreLista[] = {"Toyota","Suzuki","Ferrari","Nissan","Hyundai"};

        arrayAdapterLista = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreLista);
        listView.setAdapter(arrayAdapterLista);

        arrayListVehiculos = new ArrayList<>();

        llenarDatosArray();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),mostrar(listView.getItemAtPosition(position).toString()),Toast.LENGTH_SHORT).show();
            }
        });

    }
    void llenarDatosArray(){

        VehiculoClass vehiculoClass = new VehiculoClass();
        vehiculoClass.setColor("Azul");
        vehiculoClass.setMarca("Toyota");
        this.arrayListVehiculos.add(vehiculoClass);

        VehiculoClass vehiculoClass2 = new VehiculoClass();
        vehiculoClass2.setColor("Verde");
        vehiculoClass2.setMarca("Suzuki");
        this.arrayListVehiculos.add(vehiculoClass2);

        this.arrayListVehiculos.add(vehiculoClass);
        VehiculoClass vehiculoClass3 = new VehiculoClass();
        vehiculoClass3.setColor("Morado");
        vehiculoClass3.setMarca("Ferrari");
        this.arrayListVehiculos.add(vehiculoClass3);

        VehiculoClass vehiculoClass4 = new VehiculoClass();
        vehiculoClass4.setColor("Rosa");
        vehiculoClass4.setMarca("Hyundai");
        this.arrayListVehiculos.add(vehiculoClass4);

    }
    String mostrar(String marca){

        String nombre="";
        for(int i=0; i<arrayListVehiculos.size();i++){
            if(arrayListVehiculos.get(i).getMarca().equals(marca)){
                nombre = "\nMarca: " + arrayListVehiculos.get(i).getMarca() + "\nColor: "+ arrayListVehiculos.get(i).getColor();
            }
        }

        return nombre;


    }
}
