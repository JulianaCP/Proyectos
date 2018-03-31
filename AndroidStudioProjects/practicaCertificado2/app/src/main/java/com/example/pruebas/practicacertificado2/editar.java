package com.example.pruebas.practicacertificado2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

public class editar extends AppCompatActivity {

    String posEnviada;
    Bundle bundle;
    RadioButton mujer,hombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        bundle=getIntent().getExtras();
        posEnviada = bundle.getString("posicion");

    }
}
