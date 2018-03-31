package com.example.pruebas.practicacertificado3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    DBHelper myDB;
    ArrayList<Persona> arrayListPersonaTab1 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DBHelper(this);


        arrayListPersonaTab1=myDB.getInfoEspecificas("hombre");
        Toast.makeText(getApplicationContext(),"size25p: " +arrayListPersonaTab1.size(),Toast.LENGTH_LONG).show();


    }
}
