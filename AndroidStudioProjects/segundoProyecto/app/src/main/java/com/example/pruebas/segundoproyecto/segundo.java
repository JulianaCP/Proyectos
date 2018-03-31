package com.example.pruebas.segundoproyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class segundo extends AppCompatActivity {
    TextView show;

    ListView lista;
    ArrayAdapter<String>Adaptador;
    ArrayList<Persona>personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);


        show=(TextView)findViewById(R.id.show);
        Bundle b=getIntent().getExtras();  //recibe datos
        show.setText(b.getString("clave"));


        personas = new ArrayList<Persona>();
        setInfo(); //despues de la instanciacion del arraylist

        lista=(ListView)findViewById(R.id.listViewSegundo);

        String nombres[] = {"Pamela","Juliana","Johanna","Kembly"};
        Adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres);
        lista.setAdapter(Adaptador);


        //lista: nombre del listView
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {  //lista.setOnClickListener(new On) con solo eso sale (la "O" es mayuscula)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),funcion(lista.getItemAtPosition(position).toString()),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setInfo(){

        Persona a = new Persona();
        a.setNombre("Pamela");
        a.setProcedencia("Ciudad Quesada");
        this.personas.add(a);

        Persona b = new Persona();
        b.setNombre("Juliana");
        b.setProcedencia("Santa Rosa");
        this.personas.add(b);

        Persona c = new Persona();
        c.setNombre("Johanna");
        c.setProcedencia("San Jose");
        this.personas.add(c);

        Persona d = new Persona();
        d.setNombre("Kembly");
        d.setProcedencia("Pital");
        this.personas.add(d);
    }

    public String funcion(String nombre){

      String procedencia ="";
        for(int i=0;i<personas.size();i++){
            if(personas.get(i).getNombre().equals(nombre)){
                procedencia = "Nombre: " + personas.get(i).getNombre() +"\nProcedencia: " + personas.get(i).getProcedencia();
            }
        }

        return procedencia;
        //return procedencia de la personas
    }
}
