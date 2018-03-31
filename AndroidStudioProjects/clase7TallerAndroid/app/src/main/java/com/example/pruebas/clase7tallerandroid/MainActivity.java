package com.example.pruebas.clase7tallerandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabHost tabla;
    ListView lista;

    ArrayList<Pelicula> peliculas;
    int[] imagenes = {

            R.drawable.divergente,
            R.drawable.realidad,
            R.drawable.rubias,
            R.drawable.xmen
    };


    //para el calendario
    CalendarView calendario;
    String fecha;
    String rHora;

    //para la vista 3

    Spinner sala;
    Spinner hora;


    NumberPicker cantPersonas;



    Button next;

    String peli = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabla=(TabHost)findViewById(R.id.tabHost);
        lista=(ListView)findViewById(R.id.listView);
        peliculas=new ArrayList<Pelicula>();
        calendario=(CalendarView)findViewById(R.id.calendarView);
        sala = (Spinner)findViewById(R.id.eSala);

        hora = (Spinner)findViewById(R.id.eHora);
        cantPersonas=(NumberPicker)findViewById(R.id.npCantPersonas);

        next=(Button)findViewById(R.id.buy);


        tabla.setup();
        TabHost.TabSpec ddd = tabla.newTabSpec("c");
        ddd.setIndicator("c label");
        ddd.setContent(R.id.linearLayout);


        TabHost.TabSpec tab1 = tabla.newTabSpec("tab1");
        TabHost.TabSpec tab2 = tabla.newTabSpec("tab2");
        TabHost.TabSpec tab3 = tabla.newTabSpec("tab3");
        tab1.setIndicator("paso 1");
        tab1.setContent(R.id.linearLayout);
        tab2.setIndicator("paso 2");
        tab2.setContent(R.id.linearLayout2);
        tab3.setIndicator("paso 3");
        tab3.setContent(R.id.linearLayout3);
        tabla.addTab(tab1);
        tabla.addTab(tab2);
        tabla.addTab(tab3);


        setInfo();




      //  Toast.makeText(getApplicationContext(), String.valueOf(peliculas.size()), Toast.LENGTH_SHORT).show();

        lista.setAdapter(new viewAdapter(MainActivity.this));



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                peli = peliculas.get(i).getNombre();
            }
        });


        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                //Toast.makeText(getApplicationContext(),String.valueOf(dayOfMonth)+"/"+String.valueOf(month)+"/"+String.valueOf(year),Toast.LENGTH_SHORT).show();
                fecha = String.valueOf(dayOfMonth)+ "/"+String.valueOf(month)+"/"+ String.valueOf(year);
            }
        });



        // tercera
        ArrayList<String>gh = new ArrayList<String>();
        gh.add("Sala 1");
        gh.add("Sala 2");

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,gh);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sala.setAdapter(adapt);


        ArrayList<String>horas = new ArrayList<String>();
        horas.add("8 pm");
        horas.add("7 pm");
        horas.add("6 pm");



        ArrayAdapter<String> adaptHoras = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,horas);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hora.setAdapter(adaptHoras);



        cantPersonas.setMinValue(1);
        cantPersonas.setMaxValue(50);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje = "Usted compro " + String.valueOf(cantPersonas.getValue()) +
                        " entradas para ver " + peli + " en la sala "+sala.getSelectedItem()+" a las "+
                        hora.getSelectedItem() + " bajo el costo de "+ String.valueOf(2500*cantPersonas.getValue());

                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void setInfo(){

        Pelicula pelicula1 = new Pelicula();
        pelicula1.setNombre("Divergente");
        pelicula1.setPos(0);
        this.peliculas.add(pelicula1);

        Pelicula pelicula2 = new Pelicula();
        pelicula2.setNombre("Xmen");
        pelicula2.setPos(1);
        this.peliculas.add(pelicula2);

        Pelicula pelicula3 = new Pelicula();
        pelicula3.setNombre("Donde estan las rubias");
        pelicula3.setPos(2);
        this.peliculas.add(pelicula3);

        Pelicula pelicula4 = new Pelicula();
        pelicula4.setNombre("La cruda realidad");
        pelicula4.setPos(3);
        this.peliculas.add(pelicula4);
    }

    public class viewAdapter extends BaseAdapter {
        LayoutInflater mInflater;
        public viewAdapter(Context context){
            mInflater= LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return peliculas.size();
        }

        @Override
        public Object getItem(int i) {
            return peliculas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return  i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view==null){
                view=mInflater.inflate(R.layout.componente,null);
            }
            TextView text= (TextView) view.findViewById(R.id.nombrep);
            ImageView imagen= (ImageView) view.findViewById(R.id.imagenp);
            imagen.setImageResource(imagenes[peliculas.get(i).getPos()]);
            text.setText(peliculas.get(i).getNombre());
            return view;

        }
    }
}
