package com.example.pruebas.clase6;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    TabHost tabla;
    Button buttonSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabla = (TabHost)findViewById(R.id.tabHost2);
        tab();
        buttonSalir = (Button)findViewById(R.id.salir);
        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensaje();
            }
        });
    }

    public void mensaje(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Atencion")
                .setMessage("Desean salir del programa")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).create().show();
    }

    public void tab(){

        tabla.setup();

        TabHost.TabSpec tab1 = tabla.newTabSpec("tab1");
        TabHost.TabSpec tab2 = tabla.newTabSpec("tab2");
        TabHost.TabSpec tab3 = tabla.newTabSpec("tab3");

        tab1.setIndicator("tab1");
        tab1.setContent(R.id.linearLayout4);

        tab2.setIndicator("tab2");
        tab2.setContent(R.id.linearLayout5);

        tab3.setIndicator("tab3");
        tab3.setContent(R.id.linearLayout6);


        tabla.addTab(tab1);
        tabla.addTab(tab2);
        tabla.addTab(tab3);


    }

}
