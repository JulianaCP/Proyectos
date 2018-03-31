package com.example.pruebas.mantenimiento_administrador;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class
MainActivity extends AppCompatActivity {


    private Button loginButtonIniciarSesion;
    private EditText loginInputNombreUsuario, loginInputcontrasenna;
    private String valNombreUsuario, valContrasenna;

    private String serNombreUsuario,serContrasenna,serNombre,serApellido1,serApellido2,serCorreo,serTelefono,serRol,serActivo;
    private String usuarioValido;
    private Conexion conexion;
    private Usuario usuario;

    private CheckBox loginCheckBox_sesion;

    private SharedPreferences sharedPreferences;
    private String sharedPreferences_username;
    private String sharedPreferences_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButtonIniciarSesion = (Button)findViewById(R.id.loginButtonIniciarSesion);
        loginInputNombreUsuario = (EditText)findViewById(R.id.loginInputNombreUsuario);
        loginInputcontrasenna = (EditText)findViewById(R.id.loginInputContrasenna);
        loginCheckBox_sesion = (CheckBox)findViewById(R.id.loginCheckBoxSesion);

        sharedPreferences =  getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        verificar_sharedPrefrences();
      //  loginInputNombreUsuario.setText("Alvarado");
       // loginInputcontrasenna.setText("1234");


///////////////////
        //pruebas


       String refreshedToken = FirebaseInstanceId.getInstance().getToken();
       System.out.println("Token dispositivo: " + refreshedToken);

/////////////////////

        loginButtonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loginInputNombreUsuario.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Nombre de usuario vacio ",Toast.LENGTH_SHORT).show();
                }
                else if(loginInputcontrasenna.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Contraseña vacio ",Toast.LENGTH_SHORT).show();
                }
                else{
                    valNombreUsuario = loginInputNombreUsuario.getText().toString();
                    valContrasenna = loginInputcontrasenna.getText().toString();

                    verificarLogin(valNombreUsuario,valContrasenna);
                }
            }
        });
    }

    public void verificar_sharedPrefrences(){

        sharedPreferences_username = sharedPreferences.getString("username","");
        sharedPreferences_password = sharedPreferences.getString("password","");

        if(!sharedPreferences_username.equals("") && !sharedPreferences_password.equals("")){
            System.out.println("se inicion sesion por preferences");
            verificarLogin(sharedPreferences_username,sharedPreferences_password);
        }
        System.out.println("no entro");
        System.out.println("user: " + sharedPreferences_username);
        System.out.println("pass: " + sharedPreferences_password);
    }

    public boolean verificarLogin(final String parNombreUsuario, final String parContrasenna){


        conexion = new Conexion();
        Call<Usuario> call = conexion.getServidor().serverLogin(parNombreUsuario,parContrasenna);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                serNombreUsuario = response.body().getNombreUsuario();
                serContrasenna = response.body().getContrasena();
                serNombre = response.body().getNombre();
                serApellido1 = response.body().getApellido1();
                serApellido2 = response.body().getApellido2();
                serCorreo = response.body().getCorreo();
                serTelefono = response.body().getTelefono();
                serRol = response.body().getRol();
                serActivo = response.body().getActivo();


                if(parNombreUsuario.equals(serNombreUsuario) && parContrasenna.equals(serContrasenna)){
                    usuario = new Usuario(serNombreUsuario,serContrasenna,serNombre,serApellido1,
                            serApellido2,serCorreo,serTelefono,serRol,serActivo);
                    Autentificacion.setUsuarioLogin(usuario);

                    if(loginCheckBox_sesion.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",serNombreUsuario);
                        editor.putString("password",serContrasenna);
                        editor.apply();
                        System.out.println("se guardaron los datos de usuario");
                    }

                    Intent intent = new Intent(getApplicationContext(),nav_menu.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"datos incorrectos:   ",Toast.LENGTH_SHORT).show();
                }

               // Toast.makeText(getApplicationContext(),"usuario:   "+Autentificacion.getUsuarioLogin().getNombreUsuario(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"fallo conexion:   ",Toast.LENGTH_SHORT).show();
            }
        });
        return false;

    }



    ///// nuevo


}


