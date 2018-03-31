package com.example.pruebas.clase8android;

import android.content.Context;
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

import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;

import retrofit.client.OkClient;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    String baseurl = "http://172.24.43.9";
    Servidor server;
    ArrayList<Vehiculo> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView)findViewById(R.id.lista);
        carros = new ArrayList<Vehiculo>();
    }
    public void getVehiculosInfo(View view){
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(baseurl)
                .setClient(new OkClient(new OkHttpClient()));
        server = builder.build().create(Servidor.class);
        server.getVehiculosInfo(new Callback<ArrayList<Vehiculo>>() {
            @Override
            public void success(ArrayList<Vehiculo> vehiculos, Response response) {
                carros=vehiculos;
                lista.setAdapter(new viewAdapter(MainActivity.this));
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(),error.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class viewAdapter extends BaseAdapter {
        LayoutInflater mInflater;

        public viewAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return carros.size();
        }

        @Override
        public Object getItem(int i) {
            return carros.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = mInflater.inflate(R.layout.componente, null);
            }
            final TextView numeroPlaca = (TextView) view.findViewById(R.id.numeroPlaca);
            numeroPlaca.setText("Placa: " + carros.get(i).getNumeroPlaca());

            final TextView marca = (TextView) view.findViewById(R.id.marca);
            marca.setText("Marca: " + carros.get(i).getMarca());

            final TextView desc = (TextView) view.findViewById(R.id.descripcion);
            desc.setText("Descr: " + carros.get(i).getDescripcion());


            final TextView modelo = (TextView) view.findViewById(R.id.modelo);
            modelo.setText("Modelo: " + carros.get(i).getModelo());

            final TextView capP = (TextView) view.findViewById(R.id.capPersonas);
            capP.setText("Capacidad personas: " + String.valueOf(carros.get(i).getCantPersonas()));

            final TextView color = (TextView) view.findViewById(R.id.color);
            color.setText("Color: " + carros.get(i).getColor());

            final TextView costoAproximado = (TextView) view.findViewById(R.id.costo);
            costoAproximado.setText("Costo aproximado: " + String.valueOf(carros.get(i).getCostoAproximado()));

            return view;
        }
    }
}
