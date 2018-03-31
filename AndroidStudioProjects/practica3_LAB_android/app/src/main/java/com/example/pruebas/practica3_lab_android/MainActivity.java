package com.example.pruebas.practica3_lab_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    BDHelper MyDB;
    ArrayList<String>codigos = new ArrayList<>();
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDB = new BDHelper(this);
        listView = (ListView)findViewById(R.id.listView);

        Global.listaProductos = MyDB.getListData();
        obtenerLista();
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,codigos));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bundle = new Bundle();
                bundle.putString("posicion",Integer.toString(i));
                Intent intent = new Intent(getApplicationContext(),MultiprocesoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        Global.listaProductos = MyDB.getListData();
        obtenerLista();
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,codigos));
        super.onResume();
    }

    public void obtenerLista(){
        codigos.clear();
        for (int i=0; i<Global.listaProductos.size();i++){
            codigos.add(Global.listaProductos.get(i).getCodigo());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.opcion_agregar){
            Intent intent = new Intent(getApplicationContext(),AgregarActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
