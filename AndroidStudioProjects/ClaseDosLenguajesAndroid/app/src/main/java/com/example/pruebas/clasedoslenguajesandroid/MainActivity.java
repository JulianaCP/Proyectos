package com.example.pruebas.clasedoslenguajesandroid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<ListData>arrayListData;
    ListView listView;
    BDHelper MyDB;
    Bundle bundle;
    String seleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDB = new BDHelper(this);
        listView=(ListView)findViewById(R.id.listView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.guardar) {
            Intent intent = new Intent(getApplicationContext(), AgregarActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        arrayListData = MyDB.getListData();
        listView.setAdapter(new ViewAdapter(this));
        super.onResume();
    }

    public class ViewAdapter extends BaseAdapter{

        LayoutInflater layoutInflater;
        public ViewAdapter(Context context){
            layoutInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return arrayListData.size();
        }

        @Override
        public Object getItem(int i) {
            return arrayListData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.listitem,null);
            }
            final int pos = position;
            final TextView nameText = (TextView) convertView.findViewById(R.id.nameText);
            nameText.setText(getResources().getText(R.string.name)+" : "+arrayListData.get(position).getNombre());
            final TextView ageText = (TextView) convertView.findViewById(R.id.ageText);
            ageText.setText(getResources().getText(R.string.description)+" : "+arrayListData.get(position).getDescripcion());
            final Button edit = (Button) convertView.findViewById(R.id.buttonEditar);
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bundle = new Bundle();
                    bundle.putString("nombre", arrayListData.get(pos).getNombre());
                    Intent intent = new Intent(getApplicationContext(), EditarActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            final Button delete = (Button) convertView.findViewById(R.id.buttonEliminar);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    seleccionado = arrayListData.get(pos).getNombre();
                    confirmar_eliminar();
                }
            });
            return convertView;
        }

    }
    public void confirmar_eliminar() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Desea eliminar el producto ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                eliminar();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {


            }
        });
        dialogo1.show();
    }
    public void eliminar(){
        MyDB.deleteContact(seleccionado);
        onResume();
    }


}
