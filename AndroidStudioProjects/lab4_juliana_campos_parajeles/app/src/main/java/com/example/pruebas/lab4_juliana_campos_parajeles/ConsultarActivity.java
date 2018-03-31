package com.example.pruebas.lab4_juliana_campos_parajeles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ConsultarActivity extends AppCompatActivity {

    TextView placa,modelo,marca;
    Bundle bundle;
    BDHelper MyDB;
    String posicion;
    String placaVar;
    String modeloVar;
    String marcaVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        MyDB = new BDHelper(this);
        placa = (TextView)findViewById(R.id.textViewPlaca);
        modelo= (TextView)findViewById(R.id.textViewModelo);
        marca= (TextView)findViewById(R.id.textViewMarca);

        bundle = getIntent().getExtras();
        posicion = bundle.getString("posicion");
        placaVar = Global.listaVehiculos.get(Integer.parseInt(posicion)).getPlaca();
        modeloVar =  Global.listaVehiculos.get(Integer.parseInt(posicion)).getModelo();
        marcaVar = Global.listaVehiculos.get(Integer.parseInt(posicion)).getMarca();

        placa.setText(placaVar);
        modelo.setText(modeloVar);
        marca.setText(marcaVar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_consultar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.opcion_regresar){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
