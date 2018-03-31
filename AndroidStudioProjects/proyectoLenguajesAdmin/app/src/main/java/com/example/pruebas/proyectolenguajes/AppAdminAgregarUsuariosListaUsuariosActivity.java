package com.example.pruebas.proyectolenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class AppAdminAgregarUsuariosListaUsuariosActivity extends AppCompatActivity {
    //componentes activity
    View registroContenedorAtributosExtraAdministrador;
    EditText registroNombre;
    EditText registroContraseña;
    EditText registroLogin;
    EditText registroTelefono;
    RadioButton registroOpcionCliente;
    RadioButton registroOpcionAdministrador;
    EditText registroDepartamento;
    EditText registroSalario;
    EditText registroCedula;
    Button registroBotonAceptar;

    //variables
    int radioButtonPresionado;
    String query;

    //atributos de usuarios

    String nombre;
    String login;
    String password;
    String telefono;
    String permiso;


    //atributos administrador

    String departamento;
    String salario;
    String cedula;


    //atributos clientes

    String fechaRegistro;
    String  ultimoLogin;
    Date fechaActual;
    SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_admin_agregar_usuarios_lista_usuarios);


        registroContenedorAtributosExtraAdministrador = findViewById(R.id.agregarUsuarioContenedorAtributosAdministrador);
        registroContenedorAtributosExtraAdministrador.setVisibility(View.INVISIBLE);


        registroNombre = (EditText) findViewById(R.id.agregarUsuarioEditTexNombre);
        registroContraseña = (EditText) findViewById(R.id.agregarUsuarioEditTextConstraseña);
        registroLogin = (EditText) findViewById(R.id.agregarUsuarioEditTexLogin);
        registroTelefono = (EditText) findViewById(R.id.agregarUsuarioEditTextTelefono);
        registroOpcionCliente = (RadioButton) findViewById(R.id.agregarUsuarioOpcionCliente);
        registroOpcionAdministrador = (RadioButton) findViewById(R.id.agregarUsuarioOpcionAdministrador);
        registroDepartamento = (EditText) findViewById(R.id.agregarUsuarioEditTextDepartamento);
        registroSalario = (EditText) findViewById(R.id.agregarUsuarioEditTextSalario);
        registroCedula = (EditText) findViewById(R.id.agregarUsuarioEditTextCedula);

        registroBotonAceptar = (Button) findViewById(R.id.agregarUsuarioButtonAceptarUsuario);


        //evento boton aceptar registra o agrega al usuario dependiendo de cual se haya seleccionado.
        registroBotonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButtonPresionado=view.getId();

                //verificacion espacios en blanco
                if(registroNombre.getText().toString().equals("") || registroContraseña.getText().toString().equals("") ||
                        registroContraseña.getText().toString().equals("") || registroLogin.getText().toString().equals("") ||
                        registroTelefono.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(),"Error... Datos incompletos agregar usuario",Toast.LENGTH_SHORT).show();
                }

                else{
                    nombre = registroNombre.getText().toString();
                    login = registroLogin.getText().toString();  //unico
                    password = registroContraseña.getText().toString();
                    telefono = registroTelefono.getText().toString();


                    //tipo usuario cliente
                    if(registroOpcionCliente.isChecked()){
                        fechaActual = new Date();
                        fechaRegistro =  formato.format(fechaActual);
                        ultimoLogin = formato.format(fechaActual);

                        permiso = Global.permisosCliente;
                        final Cliente cliente = new Cliente(nombre,login,password,telefono,permiso,fechaRegistro,ultimoLogin);


                        RestAdapter.Builder builder4 = new RestAdapter.Builder()
                                .setEndpoint(Global.baseurl)
                                .setClient(new OkClient(new OkHttpClient()));// alt intro si da error...
                        Global.server = builder4.build().create(Servidor.class);
                        Global.server.agregarCliente(cliente, new Callback<String>() {
                            @Override
                            public void success(String respuesta, Response response) {
                                if (respuesta.equals("si")){
                                    Toast.makeText(AppAdminAgregarUsuariosListaUsuariosActivity.this,"Se ha realizado exitosamente",Toast.LENGTH_SHORT).show();
                                    Global.listaUsuarios.add(cliente);
                                    finish();
                                }
                                else{
                                    Toast.makeText(AppAdminAgregarUsuariosListaUsuariosActivity.this,"Error: no se realizó",Toast.LENGTH_SHORT).show();

                                }
                                finish();
                            }

                            @Override
                            public void failure(RetrofitError error) {

                            }
                        });


                    }
                    else{
                        //tipo usuario administrador

                        if(registroDepartamento.getText().toString().equals("") || registroSalario.getText().toString().equals("") ||
                                registroCedula.getText().toString().equals("")  ){
                            Toast.makeText(getApplicationContext(),"Error... Datos incompletos",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            departamento = registroDepartamento.getText().toString();
                            cedula = registroCedula.getText().toString(); //unico
                            salario = registroSalario.getText().toString();
                            permiso = Global.permisosAdministrador;

                            final Administrador administrador = new Administrador(nombre,login,password,telefono,permiso,departamento,salario,cedula);

                            RestAdapter.Builder builder4 = new RestAdapter.Builder()
                                    .setEndpoint(Global.baseurl)
                                    .setClient(new OkClient(new OkHttpClient()));// alt intro si da error...
                            Global.server = builder4.build().create(Servidor.class);
                            Global.server.agregarAdministrador(administrador, new Callback<String>() {
                                @Override
                                public void success(String respuesta, Response response) {
                                    if (respuesta.equals("si")){
                                        Toast.makeText(AppAdminAgregarUsuariosListaUsuariosActivity.this,"si se realizo",Toast.LENGTH_SHORT).show();
                                        Global.listaUsuarios.add(administrador);

                                    }
                                    else{
                                        Toast.makeText(AppAdminAgregarUsuariosListaUsuariosActivity.this,"no se realizo",Toast.LENGTH_SHORT).show();
                                    }
                                    finish();
                                }

                                @Override
                                public void failure(RetrofitError error) {

                                }
                            });


                            //regresar();

                        }

                    }
                }
            }
        });

    }

    public void regresar(){

        Intent intent = new Intent(getApplicationContext(),AppAdminListaUsuariosActivity.class);
        startActivity(intent);
    }

    //evento seleccionar tipo de usuario (seleccion de radio button)
    public void onRadioButtonClickedUserType(View view)
    {
        radioButtonPresionado= view.getId();

        if(radioButtonPresionado == registroOpcionCliente.getId()){
            registroContenedorAtributosExtraAdministrador.setVisibility(View.INVISIBLE);
            registroContenedorAtributosExtraAdministrador.setVisibility(View.GONE);
        }
        else{
            registroContenedorAtributosExtraAdministrador.setVisibility(View.VISIBLE);
        }
    }
}
