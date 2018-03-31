package com.example.pruebas.clase4android;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ventanaMostrar extends AppCompatActivity {

    int numero;
    double alimentacion;
    double vivienda;
    double GastosPublicos;
    double vehiculo;
    double prestamo;
    double ahorro;
    double gastosVarios;

    TextView mostrarSalario;
    TextView porcentajeAlimentacion;
    TextView porcentajeVivienda;
    TextView porcentajeGastosPublicos;
    TextView porcentajeVehiculo;
    TextView porcentajePrestamo;
    TextView porcetajeAhorro;
    TextView porcentajeGastosVarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_mostrar);

        mostrarSalario = (TextView)findViewById(R.id.texViewMostrarNumeroREciibido);
        porcentajeAlimentacion =(TextView)findViewById(R.id.Alimentacion);
        porcentajeVivienda = (TextView)findViewById(R.id.vivienda);
        porcentajeGastosPublicos = (TextView)findViewById(R.id.GastosPublicos);
        porcentajeVehiculo = (TextView)findViewById(R.id.Vehiculo);
        porcentajePrestamo = (TextView)findViewById(R.id.prestamo);
        porcetajeAhorro = (TextView)findViewById(R.id.ahorro);
        porcentajeGastosVarios = (TextView)findViewById(R.id.gastosVarios);




        Bundle recibido =getIntent().getExtras();
       numero = Integer.valueOf(recibido.getString("numero"));


        alimentacion = numero * 0.151;
        vivienda = numero * 0.23;
        GastosPublicos = numero * 0.13;
        vehiculo = numero *0.1788;
        prestamo = numero *0.10;
        ahorro = numero*0.1723;
        gastosVarios = numero*0.0379;



        DecimalFormat decimales = new DecimalFormat("0.00");


        System.out.println(decimales.format(numero));


        mostrarSalario.setText("Salario Total:  ₡" + recibido.getString("numero"));

        porcentajeAlimentacion.setText("Alimentacion:  ₡" + decimales.format(alimentacion));
        porcentajeVivienda.setText("vivienda:  ₡" + decimales.format(vivienda));
        porcentajeGastosPublicos.setText("GastosPublicos:  ₡" + decimales.format(GastosPublicos));
        porcentajeVehiculo.setText("vehiculo:  ₡" + decimales.format(vehiculo));
        porcentajePrestamo.setText("prestamo:  ₡" + decimales.format(prestamo));
        porcetajeAhorro.setText("ahorro:  ₡" + decimales.format(ahorro));
        porcentajeGastosVarios.setText("gastosVarios:  ₡" + decimales.format(gastosVarios));



    }
}
