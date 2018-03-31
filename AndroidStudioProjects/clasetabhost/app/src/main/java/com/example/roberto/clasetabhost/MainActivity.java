package com.example.roberto.clasetabhost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    ArrayList<persona> listaPersonas;
    TabHost th;
    Button next, t1,t2,t3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=(ListView)findViewById(R.id.lista);
        listaPersonas= new ArrayList<persona>();
        setInfo();
        lista.setAdapter(new viewAdapter(MainActivity.this));
        next=(Button)findViewById(R.id.next);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent t=new Intent(MainActivity.this,th.class);
                startActivity(t);





            }
        });


    }
    public void mensaje1(View view){
        Toast.makeText(getApplicationContext(), "boton1", Toast.LENGTH_SHORT).show();
    }
    public void mensaje2(View view){
        Toast.makeText(getApplicationContext(), "boton2", Toast.LENGTH_SHORT).show();
    }
    public void mensaje3(View view){
        Toast.makeText(getApplicationContext(), "boton3", Toast.LENGTH_SHORT).show();
    }
    public void setInfo(){
        persona a =new persona();
        a.setNombre("Diego");
        a.setApellido("Rojas");
        listaPersonas.add(a);

        persona b =new persona();
        b.setNombre("Johanna");
        b.setApellido("Ruiz");
        listaPersonas.add(b);

        persona c =new persona();
        c.setNombre("Juliana");
        c.setApellido("Campos");
        listaPersonas.add(c);



    }

    public class viewAdapter extends BaseAdapter{
        LayoutInflater mInflater;
        public viewAdapter(Context context){
            mInflater= LayoutInflater.from(context);
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
            return  i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view=mInflater.inflate(R.layout.componente,null);
            }
            TextView name= (TextView) view.findViewById(R.id.Name);
            TextView apellido= (TextView) view.findViewById(R.id.ape);
            name.setText(listaPersonas.get(i).getNombre());
            apellido.setText(listaPersonas.get(i).getApellido());
            return view;





        }
    }


}
