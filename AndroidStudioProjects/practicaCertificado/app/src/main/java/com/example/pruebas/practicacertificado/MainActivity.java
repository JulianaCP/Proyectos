package com.example.pruebas.practicacertificado;

import android.content.ContentValues;
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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.pruebas.practicacertificado.Global.listaVehiculos;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    BDHelper myDB;

    //tab 1
    ListView listaPlacasTab1;

    //tab2
    ListView listaPlacasTab2;
    Spinner spinnerTab2;

    String[] modelosVehiculos = {"1998","1999"};

    ListView listaPlacasTab3;
    Bundle bundle;


    public static ArrayList<String> listaTotalPlacas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost=(TabHost)findViewById(R.id.tabHost);
        myDB= new BDHelper(this);

        //tab1
        listaPlacasTab1=(ListView)findViewById(R.id.listViewTab1);

        //tab2
        spinnerTab2=(Spinner)findViewById(R.id.spinnerTab2);
        listaPlacasTab2=(ListView)findViewById(R.id.listViewTab2);


        //tab3

        listaPlacasTab3=(ListView)findViewById(R.id.listViewTab3);




        llenarBase();

        actualizarTab();
        crearInfoTab1();
        crearInfoTab2();
        crearInfoTab3();




        spinnerTab2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Global.opcionSeleccionada = modelosVehiculos[i];

                Global.listaVehiculos = myDB.getInfoModelo(Global.opcionSeleccionada);
                obtenerListaPlacas();
                llenarListViewTab2SegunModelo();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listaPlacasTab2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Global.opcionSeleccionada = Global.listaPlacas.get(i);
                Toast.makeText(getApplicationContext(),"opcion seleccionada: "+ Global.opcionSeleccionada,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onResume() {
        crearInfoTab1();
        crearInfoTab2();
        crearInfoTab3();
        super.onResume();
    }


    public class viewAdapter extends BaseAdapter{
        LayoutInflater layoutInflater;
        public viewAdapter(Context context){

            layoutInflater = layoutInflater.from(context);
        }
        @Override
        public int getCount() {
            Global.listaVehiculos = myDB.getInfo();
            return Global.listaVehiculos.size();
        }

        @Override
        public Object getItem(int i) {
            return Global.listaVehiculos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view = layoutInflater.inflate(R.layout.listview_personalizado,null);
            }

            final int posicion = i;
            final TextView placaText = (TextView)view.findViewById(R.id.placaL);
            final TextView modeloText = (TextView)view.findViewById(R.id.modeloL);
            final TextView colorText = (TextView)view.findViewById(R.id.colorL);

            placaText.setText(Global.listaVehiculos.get(i).getPlaca());
            modeloText.setText(Global.listaVehiculos.get(i).getModelo());
            colorText.setText(Global.listaVehiculos.get(i).getColor());


            final Button buttonEditar = (Button)view.findViewById(R.id.buttonEditarL); //////////////me equiboque en el view.  (falto)
            final Button buttonEliminar=(Button)view.findViewById(R.id.buttonEliminarL);

            buttonEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Global.opcionSeleccionada = Integer.toString(posicion);
                    bundle = new Bundle();
                  ///  Toast.makeText(getApplicationContext(),"antes"+Global.opcionSeleccionada,Toast.LENGTH_LONG).show();
                    bundle.putString("placa",Global.opcionSeleccionada);
                    Intent intent = new Intent(getApplicationContext(),editar.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            buttonEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Global.opcionSeleccionada = Global.listaVehiculos.get(posicion).getPlaca();
                    mensajeAlerta();

                }
            });

            return view;
        }
    }
    public void mensajeAlerta(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmar");
        builder.setMessage("¿Desea Eliminar?");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myDB.eliminar(Global.opcionSeleccionada);
                onResume();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }


    public void llenarListViewTab2SegunModelo(){
        Global.adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Global.listaPlacas);
        listaPlacasTab2.setAdapter(Global.adapter);
    }
    public void llenarBase(){
        myDB.insertar("111","1998","Blanco");
        myDB.insertar("222","1999","Negro");
        myDB.insertar("333","1998","Blanco");
        myDB.insertar("444","1999","Negro");
        myDB.insertar("555","1998","Blanco");
        myDB.insertar("666","1999","Negro");
    }

    public void crearInfoTab1(){
        Global.listaVehiculos = myDB.getInfo();
        for (int i = 0; i< listaVehiculos.size(); i++){
            listaTotalPlacas.add(listaVehiculos.get(i).getPlaca());
        }
        Global.adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaTotalPlacas);
        listaPlacasTab1.setAdapter(Global.adapter);
    }
    public void crearInfoTab2(){

        Global.adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,modelosVehiculos);
        Global.adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTab2.setAdapter(Global.adapter);


        ///


    }

    public void crearInfoTab3(){
        listaPlacasTab3.setAdapter(new viewAdapter(this));

        //

    }

    public void obtenerListaPlacas(){
        Global.listaPlacas.clear();
        for (int i = 0; i< listaVehiculos.size(); i++){
            Global.listaPlacas.add(listaVehiculos.get(i).getPlaca());
        }
    }
    public void actualizarTab(){
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setIndicator("Placas");
        tab1.setContent(R.id.linearLayout);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("Spinner");
        tab2.setContent(R.id.linearLayout2);
        tabHost.addTab(tab2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");
        tab3.setIndicator("Personalizado");
        tab3.setContent(R.id.linearLayout3);
        tabHost.addTab(tab3);
        ////


    }
}
