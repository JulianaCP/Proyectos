package com.example.pruebas.claseunolenguajesandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    String [] paises = {"costa rica","argentina","chile"};
    String [] poblacion = {"20000","5521252","5444555"};
    ArrayAdapter<String> adapter;
    TextView textViewMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView=(ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,paises);
        listView.setAdapter(adapter);
        textViewMensaje=(TextView)findViewById(R.id.textViewCantidadPoblacion);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textViewMensaje.setText("Poblacion de: " + listView.getItemAtPosition(i).toString() +" es " + poblacion[i]) ;
            }
        });
    }
}
