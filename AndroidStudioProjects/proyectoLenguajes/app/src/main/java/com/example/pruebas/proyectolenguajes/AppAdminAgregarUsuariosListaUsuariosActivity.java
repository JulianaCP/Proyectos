package com.example.pruebas.proyectolenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        Toast.makeText(getApplicationContext(),"agregar usuario",Toast.LENGTH_SHORT).show();


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


        //evento boton aceptar
        registroBotonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButtonPresionado=view.getId();
                Toast.makeText(getApplicationContext(),"entro",Toast.LENGTH_SHORT).show();

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


                        Cliente cliente = new Cliente(nombre,login,password,telefono,permiso,fechaRegistro,ultimoLogin);
                        Global.listaUsuarios.add(cliente);

                        Toast.makeText(getApplicationContext(),"creo cliente len: "+Global.listaUsuarios.size(),Toast.LENGTH_SHORT).show();

                        regresar();


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

                            Administrador administrador = new Administrador(nombre,login,password,telefono,permiso,departamento,salario,cedula);
                            Global.listaUsuarios.add(administrador);

                            Toast.makeText(getApplicationContext(),"creo admin len: "+Global.listaUsuarios.size(),Toast.LENGTH_SHORT).show();

                            regresar();

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
