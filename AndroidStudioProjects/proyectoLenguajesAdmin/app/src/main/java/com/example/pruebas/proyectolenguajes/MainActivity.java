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

import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    EditText loginEditTextUserName;
    EditText loginEditTextPassword;
    Button loginButtonAceptar;


    Button button; // de llamar


    //variables
    String userVar;
    String passwordVar;

    Boolean cumpleRequisitos;
    ArrayList<Cliente>listaCliente;

    Class vista;


    @Override
    protected void onResume(){
        /*Función encargada de actualizar los datos de las listas globales del sistema
        * con las información que se encuentra en la base de datos*/
        super.onResume();
        Global.setInfo(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        loginEditTextUserName=(EditText)findViewById(R.id.loginEditTextUserNameACT);
        loginEditTextPassword=(EditText)findViewById(R.id.loginEditTextPasswordACT);
        loginButtonAceptar=(Button)findViewById(R.id.loginBotonAceptarACT);


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
    }


    public Boolean verificar(){
        /*verifica si el usuario pertenece a los usuarios tipo administrador que se encuentran en los
        * datos del sistema.*/

        cumpleRequisitos=false;
        userVar = loginEditTextUserName.getText().toString();
        passwordVar = loginEditTextPassword.getText().toString();

        for (int i = 0; i< Global.listaUsuarios.size();i++){
            if(userVar.equals(Global.listaUsuarios.get(i).getLogin())){

                if(passwordVar.equals(Global.listaUsuarios.get(i).getPassword())){
                    if(Global.listaUsuarios.get(i).getPermiso().equals(Global.permisosAdministrador)){
                        vista = AppAdminActivity.class;
                        cumpleRequisitos=true;
                    }
                }
            }
        }
        return cumpleRequisitos;
    }
}
