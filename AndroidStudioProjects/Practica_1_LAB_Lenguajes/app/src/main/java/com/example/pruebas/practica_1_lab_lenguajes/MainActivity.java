package com.example.pruebas.practica_1_lab_lenguajes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> nombresPaises = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInfo();
        generarLista();

        listView=(ListView)findViewById(R.id.listView);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresPaises);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Bundle bundle = new Bundle();

                bundle.putString("posicion",Integer.toString(i));
                Intent intent = new Intent(getApplicationContext(),MostrarActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(),"mostro opcion: " + Global.selecciono,Toast.LENGTH_LONG).show();
        super.onResume();
    }

    public void setInfo(){
        Pais pais1 = new Pais("Costa Rica","100000","descripcion de costa rica");
        Global.lista.add(pais1);

        Pais pais2 = new Pais("Panama","55451212","descripcion de Panama");
        Global.lista.add(pais2);

        Pais pais3 = new Pais("Colombia","4448888","descripcion de Colombia");
        Global.lista.add(pais3);
    }
    String nombre;
    public void generarLista(){
        nombresPaises.clear();
        for (int i=0;i<Global.lista.size();i++){
            nombre = Global.lista.get(i).getNombre();
            nombresPaises.add(nombre);
        }
    }
}
