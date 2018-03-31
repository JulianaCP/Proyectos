package com.example.pruebas.proyectolenguajes;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    EditText loginEditTextUserName;
    EditText loginEditTextPassword;
    Button loginButtonAceptar;
    Button loginButtonRegistrarse;

    Button button; // de llamar


    //variables
    String userVar;
    String passwordVar;

    Boolean cumpleRequisitos;


    Class vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInfo();

        button = (Button) findViewById(R.id.buttonCall); //boton de llamar


        loginEditTextUserName=(EditText)findViewById(R.id.loginEditTextUserNameACT);
        loginEditTextPassword=(EditText)findViewById(R.id.loginEditTextPasswordACT);
        loginButtonAceptar=(Button)findViewById(R.id.loginBotonAceptarACT);
        loginButtonRegistrarse=(Button)findViewById(R.id.loginBotonRegistrarseACT);


        //evento al presionar boton aceptar
        loginButtonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //se quiere loguear
                if(loginEditTextUserName.getText().toString().equals("") || loginEditTextPassword.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Error datos imcompletos",Toast.LENGTH_SHORT).show();
                }
                else{
                    verificar();
                    if(cumpleRequisitos==false){
                        Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(),vista);
                        startActivity(intent);
                    }



                }

            }
        });

        //evento al presionar boton registrarse
        loginButtonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventanaRegistrarse = new Intent(getApplicationContext(),RegistroActivity.class);
                startActivity(ventanaRegistrarse);
            }
        });

    }


    public Boolean verificar(){
        cumpleRequisitos=false;
        userVar = loginEditTextUserName.getText().toString();
        passwordVar = loginEditTextPassword.getText().toString();

        for (int i = 0; i< Global.listaUsuarios.size();i++){
            if(userVar.equals(Global.listaUsuarios.get(i).getLogin())){

                if(passwordVar.equals(Global.listaUsuarios.get(i).getPassword())){
                    cumpleRequisitos=true;
                    if(Global.listaUsuarios.get(i).getPermiso().equals(Global.permisosCliente)){
                        vista = AppClientActivity.class;
                    }
                    else{
                        vista = AppAdminActivity.class;
                    }
                }
            }
        }
        return cumpleRequisitos;
    }

    public void setInfo(){
        Global.listaProductosObjetos.clear();
        Producto producto1 = new Producto("Producto 1","este es el primer producto","3","48500");
        Global.listaProductosObjetos.add(producto1);
        Producto producto2 = new Producto("Producto 2","este es el  producto 2","30","2700");
        Global.listaProductosObjetos.add(producto2);
        Producto producto3 = new Producto("Producto 3","este es el  producto 3","310","3200");
        Global.listaProductosObjetos.add(producto3);

        Administrador admin = new Administrador("juliana","j","1","868088809","Administrador","Contabilidad","2000000","554545455");
        Global.listaUsuarios.add(admin);

        Cliente cliente1 = new Cliente("juliana","jppp","1ppp","868088809","Cliente","25/10/2016","25/10/2016");
        Global.listaUsuarios.add(cliente1);
        Cliente cliente2 = new Cliente("Juliana2","j2","1","85806809","Cliente","25/10/2016","25/10/2016");
        Global.listaUsuarios.add(cliente2);
        Cliente cliente3 = new Cliente("cliente2","user123","1234","84806809","Cliente","25/10/2016","25/10/2016");
        Global.listaUsuarios.add(cliente3);
    }
}
