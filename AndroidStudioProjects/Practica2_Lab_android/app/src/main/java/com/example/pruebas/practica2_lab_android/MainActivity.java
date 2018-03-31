package com.example.pruebas.practica2_lab_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;

    BDHelper MyDB;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        MyDB=new BDHelper(this);
        obtenerLista();
        Global.listaVehiculos.clear();
        Global.listaVehiculos = MyDB.getListData();
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Global.matriculas) );


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bundle=new Bundle();
                bundle.putString("posicion",Integer.toString(i));
                Intent intent = new Intent(getApplicationContext(),OpcionActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {

        Toast.makeText(getApplicationContext(),"len: " + Global.matriculas.size(),Toast.LENGTH_LONG).show();

        Global.listaVehiculos.clear();
        Global.listaVehiculos = MyDB.getListData();
        obtenerLista();
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Global.matriculas) );
        super.onResume();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.opcionAgregar){
            Intent intent = new Intent(getApplicationContext(),AgregarActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
    public void obtenerLista(){
        Global.matriculas.clear();
        for (int i=0;i<Global.listaVehiculos.size();i++){
            Global.matriculas.add(Global.listaVehiculos.get(i).getMatricula());
        }
    }
}
