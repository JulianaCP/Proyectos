package com.example.pruebas.proyectolenguajes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AppClientActivity extends AppCompatActivity {
    MenuInflater inflater;
    ListView listView;
    //variables

    String nombre;
    String descripcion;
    String cantidad;
    String precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_client);

        listView = (ListView)findViewById(R.id.listViewAppClienteListaProductos);
        listView.setAdapter(new viewAdapter(AppClientActivity.this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cliente_salir,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        return true;
    }

    public class viewAdapter extends BaseAdapter{

        LayoutInflater inflaterViewAdapter;
        public viewAdapter(Context context){
            inflaterViewAdapter= LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return Global.listaProductosObjetos.size();
        }

        @Override
        public Object getItem(int i) {
            return Global.listaProductosObjetos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view=inflaterViewAdapter.inflate(R.layout.componente_app_cliente_lista_productos,null);
            }
            TextView nombreProducto = (TextView)view.findViewById(R.id.texViewNombreProductosAppCliente);
            TextView descripcionProducto = (TextView)view.findViewById(R.id.textViewDescripcionProductosAppCliente);
            TextView cantidadProducto =(TextView)view.findViewById(R.id.textViewCantidadProductosAppCliente);
            TextView precioProducto=(TextView)view.findViewById(R.id.textViewPrecioProductosAppCliente);


            nombre = Global.listaProductosObjetos.get(i).getNombre();
            descripcion= Global.listaProductosObjetos.get(i).getDescripcion();
            cantidad= Global.listaProductosObjetos.get(i).getCantidad();
            precio= Global.listaProductosObjetos.get(i).getPrecioPorUnidad();


            nombreProducto.setText(nombre);
            descripcionProducto.setText(descripcion);
            cantidadProducto.setText(cantidad);
            precioProducto.setText(precio);


            return view;
        }
    }
}
