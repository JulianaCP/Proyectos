package com.example.pruebas.clase4android;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewLista;
    ArrayList<Persona> listaPersonas;

    TabHost th;

    Button next,t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewLista=(ListView)findViewById(R.id.listViewCompuesto);
        listaPersonas = new ArrayList<Persona>();
        setInfo();

        listViewLista.setAdapter(new viewAdapter(MainActivity.this));
        next = (Button)findViewById(R.id.next);
        t1 = (Button)findViewById(R.id.t1);
        t2 = (Button)findViewById(R.id.t2);
        t3 = (Button)findViewById(R.id.t3);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                th = (TabHost)findViewById(R.id.tabHost);
                th.setup();

                TabHost.TabSpec tabSpec1 = th.newTabSpec("Tab 1");
                TabHost.TabSpec tabSpec2 = th.newTabSpec("Tab 2");
                TabHost.TabSpec tabSpec3 = th.newTabSpec("Tab 3");

                tabSpec1.setIndicator("paso 1");
                tabSpec1.setContent(R.id.linearLayout);


                tabSpec1.setIndicator("paso 2");
                tabSpec1.setContent(R.id.linearLayout2);


                tabSpec1.setIndicator("paso 3");
                tabSpec1.setContent(R.id.linearLayout3);


                th.addTab(tabSpec1);
                th.addTab(tabSpec2);
                th.addTab(tabSpec3);

            }
        });


    }
    public void mensaje1(View view){

        Toast.makeText(getApplicationContext(),"boton1",Toast.LENGTH_SHORT).show();
    }
    public void mensaje2(View view){

        Toast.makeText(getApplicationContext(),"boton2",Toast.LENGTH_SHORT).show();
    }

    public void mensaje3(View view){

        Toast.makeText(getApplicationContext(),"boton3",Toast.LENGTH_SHORT).show();
    }



    public void setInfo(){

        Persona personas1 = new Persona();
        personas1.setNombre("Diego");
        personas1.setApellido("Rojas");
        listaPersonas.add(personas1);


        Persona personas2 = new Persona();
        personas2.setNombre("Daniel");
        personas2.setApellido("Perez");
        listaPersonas.add(personas2);


        Persona personas3 = new Persona();
        personas3.setNombre("Juliana");
        personas3.setApellido("Campos");
        listaPersonas.add(personas3);


        Persona personas4 = new Persona();
        personas4.setNombre("Johanna Ruiz");
        personas4.setApellido("Rojas");
        listaPersonas.add(personas4);

    }



    public class viewAdapter extends BaseAdapter{
        LayoutInflater layoutInflater;
        public viewAdapter(Context context){
            layoutInflater = layoutInflater.from(context);
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
            if(view==null){
                view=layoutInflater.inflate(R.layout.componente,null);
            }

            TextView name = (TextView)view.findViewById(R.id.name);
            TextView apellido = (TextView)view.findViewById(R.id.apellido);
            name.setText(listaPersonas.get(i).getNombre());
            apellido.setText(listaPersonas.get(i).getApellido());

            return view;
        }
    }
}
