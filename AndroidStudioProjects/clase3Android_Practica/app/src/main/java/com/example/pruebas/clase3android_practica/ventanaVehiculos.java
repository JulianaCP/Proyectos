package com.example.pruebas.clase3android_practica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ventanaVehiculos extends AppCompatActivity {


    ListView listViewListaVehiculos;

    ArrayAdapter<String> arrayVehiculos;
    ArrayList<Vehiculos> listaVehiculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_vehiculos);


        listViewListaVehiculos = (ListView)findViewById(R.id.listViewVehiculos);

        String nombresVehiculos[] = {"Toyota","Suzuki","Ferrari","Nissan","Hyundai"};
        arrayVehiculos = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresVehiculos);
        listViewListaVehiculos.setAdapter(arrayVehiculos);

        listaVehiculos = new ArrayList<Vehiculos>();
        setInformacionListaVehiculos();


        listViewListaVehiculos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),mostrar(listViewListaVehiculos.getItemAtPosition(position).toString()), Toast.LENGTH_SHORT).show();

            }
        });
    }


    public void setInformacionListaVehiculos(){

        Vehiculos vehiculos = new Vehiculos();
        vehiculos.setColor("Azul");
        vehiculos.setMsrca("Toyota");
        this.listaVehiculos.add(vehiculos);

        Vehiculos vehiculos1 = new Vehiculos();
        vehiculos1.setColor("Negro");
        vehiculos1.setMsrca("Suzuki");
        this.listaVehiculos.add(vehiculos1);

        Vehiculos vehiculos2 = new Vehiculos();
        vehiculos2.setColor("Gris");
        vehiculos2.setMsrca("Ferrari");
        this.listaVehiculos.add(vehiculos2);

        Vehiculos vehiculos3 = new Vehiculos();
        vehiculos3.setColor("Rojo");
        vehiculos3.setMsrca("Nissan");
        this.listaVehiculos.add(vehiculos3);

        Vehiculos vehiculos4 = new Vehiculos();
        vehiculos4.setColor("Verde");
        vehiculos4.setMsrca("Hyundai");
        this.listaVehiculos.add(vehiculos4);
    }

    public String mostrar(String marca){

        String color="";
        for (int i=0;i<listaVehiculos.size();i++){
            if(listaVehiculos.get(i).getMsrca().equals(marca)){
                 color = "Vehiculo: " + listaVehiculos.get(i).getMsrca() + "\nColor: " + listaVehiculos.get(i).getColor();
            }
        }
        return color;
    }
}
