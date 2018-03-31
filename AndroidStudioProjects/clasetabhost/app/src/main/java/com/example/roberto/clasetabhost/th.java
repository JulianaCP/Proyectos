package com.example.roberto.clasetabhost;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

public class th extends AppCompatActivity {
    TabHost th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th);

        th=(TabHost)findViewById(R.id.tabHost);
        th.setup();

        TabHost.TabSpec tab1= th.newTabSpec("Tabla 1");
        TabHost.TabSpec tab2= th.newTabSpec("Tabla 2");
        TabHost.TabSpec tab3= th.newTabSpec("Tabla 3");


        tab1.setIndicator("Tabla 1");
        tab1.setContent(R.id.linearLayout);

        tab2.setIndicator("Tabla 2");
        tab2.setContent(R.id.linearLayout2);

        tab3.setIndicator("Tabla 3");
        tab3.setContent(R.id.linearLayout3);


        th.addTab(tab1);
        th.addTab(tab2);
        th.addTab(tab3);
        message();



    }
    public void message(){



    }

}
