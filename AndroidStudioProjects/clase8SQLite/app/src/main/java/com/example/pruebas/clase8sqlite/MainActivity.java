package com.example.pruebas.clase8sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BaseDatos myDB;
    ArrayList<Producto> objetos;
    ListView lista;
    Button add;
    Button eliminar;
    Button modificar;


    TextView nom;
    TextView desc;
    TextView precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB=new BaseDatos(this);
        lista=(ListView)findViewById(R.id.lista);

        objetos=new ArrayList<Producto>();
        add=(Button)findViewById(R.id.add);
        eliminar =(Button)findViewById(R.id.del);
        modificar=(Button)findViewById(R.id.mod);

        nom=(TextView)findViewById(R.id.nom);
        desc=(TextView)findViewById(R.id.desc);
        precio =(TextView)findViewById(R.id.prec);

        setInfo();

        lista.setAdapter(new viewAdapter(MainActivity.this));
       // objetos=myDB.getDbInfo();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nom.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Error...debe ingresar informacion", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean seguir = false;
                    for (int i=0; i<objetos.size();i++){
                        if(objetos.get(i).getNombre().equals(nom.getText().toString())){
                            seguir=true;
                            Toast.makeText(getApplicationContext(),"Error...ya existe un producto como ese",Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                    if(seguir==false){
                        myDB.insertContact(nom.getText().toString(),desc.getText().toString(),precio.getText().toString());
                        Toast.makeText(getApplicationContext(),"Inserccion exitosa",Toast.LENGTH_SHORT).show();
                        objetos=myDB.getDbInfo();
                        lista.setAdapter(new viewAdapter(MainActivity.this));
                    }
                }
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void setInfo(){
     //   myDB.insertContact("Jabon","xedex","4000");
      //  myDB.insertContact("cereal","cornfakes","2500");
      //  myDB.insertContact("desinfectante","fabuloso","1400");

        objetos=myDB.getDbInfo();

    }
    public class viewAdapter extends BaseAdapter {
        LayoutInflater mInflater;
        public viewAdapter(Context context){
            mInflater= LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return objetos.size();
        }
        @Override
        public Object getItem(int i) {
            return objetos.get(i);
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
            TextView nombre= (TextView) view.findViewById(R.id.nombre);
            TextView descripcion= (TextView) view.findViewById(R.id.descripcion);
            TextView precio= (TextView) view.findViewById(R.id.precio);
            nombre.setText(objetos.get(i).getNombre());
            descripcion.setText(objetos.get(i).getDescripcion());
            precio.setText(objetos.get(i).getPrecio());

            return view;
        }
    }
}
