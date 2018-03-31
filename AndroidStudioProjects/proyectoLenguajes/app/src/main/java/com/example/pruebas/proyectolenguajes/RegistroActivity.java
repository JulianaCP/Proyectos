package com.example.pruebas.proyectolenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroActivity extends AppCompatActivity {

    //componentes activity
    View registroContenedorAtributosExtraAdministrador;
    EditText registroNombre;
    EditText registroContraseña;
    EditText registroLogin;
    EditText registroTelefono;
    Button registroBotonAceptar;


    //atributos de usuarios

    String nombre;
    String login;
    String password;
    String telefono;
    String permiso;

    //atributos clientes

    String fechaRegistro;
    String  ultimoLogin;
    Date fechaActual;
    SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registroNombre = (EditText) findViewById(R.id.registoUsuarioEditTexNombre);
        registroContraseña = (EditText) findViewById(R.id.registoUsuarioEditTextConstraseña);
        registroLogin = (EditText) findViewById(R.id.registoUsuarioEditTexLogin);
        registroTelefono = (EditText) findViewById(R.id.registoUsuarioEditTextTelefono);
        registroBotonAceptar = (Button) findViewById(R.id.registoUsuarioButtonAceptarUsuario);


        //evento boton aceptar
        registroBotonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //verificacion espacios en blanco
                if(registroNombre.getText().toString().equals("") || registroContraseña.getText().toString().equals("") ||
                        registroContraseña.getText().toString().equals("") || registroLogin.getText().toString().equals("") ||
                        registroTelefono.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(),"Error... Datos incompletos registro",Toast.LENGTH_SHORT).show();
                }

                else{
                    nombre = registroNombre.getText().toString();
                    login = registroLogin.getText().toString();  //unico
                    password = registroContraseña.getText().toString();
                    telefono = registroTelefono.getText().toString();

                    fechaActual = new Date();
                    fechaRegistro =  formato.format(fechaActual);
                    ultimoLogin = formato.format(fechaActual);

                    permiso = Global.permisosCliente;

                    Toast.makeText(getApplicationContext(),"len:"+Global.listaUsuarios.size()+   " login: "+ login+ " password: "+ password,Toast.LENGTH_SHORT).show();

                    Cliente cliente = new Cliente(nombre,login,password,telefono,permiso,fechaRegistro,ultimoLogin);
                    Global.listaUsuarios.add(cliente);

                    Toast.makeText(getApplicationContext(),"len:"+Global.listaUsuarios.size()+   " login: "+ login+ " password: "+ password,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                }
            }
        });

    }

}
