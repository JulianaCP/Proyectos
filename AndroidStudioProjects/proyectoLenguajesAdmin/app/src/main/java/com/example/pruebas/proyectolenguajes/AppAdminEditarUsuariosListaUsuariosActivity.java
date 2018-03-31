package com.example.pruebas.proyectolenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.gsm.GsmCellLocation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class AppAdminEditarUsuariosListaUsuariosActivity extends AppCompatActivity {

    EditText nombreUsuario;
    EditText telefonoUsuario;
    EditText fechaRegistroUsuario;
    EditText ultimoLoginUsuario;
    TextView passwordUsuario;
    RadioButton opcionCliente;
    RadioButton opcionAdministrador;

    Button buttonAceptar;
    Button buttonCancelar;
    //variables

    String nombre;
    String contraseña;
    String telefono;
    String fechaREgistro;
    String ultimoLogin;
    String permiso;

    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_admin_editar_usuarios_lista_usuarios);

        nombreUsuario=(EditText)findViewById(R.id.editarEditTexNombre);
        passwordUsuario=(TextView) findViewById(R.id.lgn);
        telefonoUsuario=(EditText)findViewById(R.id.editarEditTextTelefono);
        fechaRegistroUsuario=(EditText)findViewById(R.id.editarEditTexFechaRegistro);
        ultimoLoginUsuario =(EditText)findViewById(R.id.editarUsuarioEditTextUltimoLogin);
        buttonAceptar=(Button)findViewById(R.id.editarUsuarioButtonAceptarUsuario);
        buttonCancelar=(Button)findViewById(R.id.editarUsuariosbuttonCancelar);

        encontrarValores();

        nombreUsuario.setText(nombre);
        passwordUsuario.setText(contraseña);
        telefonoUsuario.setText(telefono);
        fechaRegistroUsuario.setText(fechaREgistro);
        ultimoLoginUsuario.setText(ultimoLogin);

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombreUsuario.getText().toString().equals("") || passwordUsuario.getText().toString().equals("") ||
                        telefonoUsuario.getText().toString().equals("") || fechaRegistroUsuario.getText().toString().equals("") ||
                        ultimoLoginUsuario.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Error... Datos incompletos editar usuario",Toast.LENGTH_SHORT).show();
                }
                else{

                    actualizarCliente();
                   finish();
                }
            }
        });

        //accion de boton cancelar solicitud de editar
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    String userLogin;
    public void actualizarCliente(){
        /*Funcion encargada de actualizar los datos del cliente seleccionado
        * tanto en la base de datos como en las listas del sistema*/

        nombre = nombreUsuario.getText().toString();
        contraseña = passwordUsuario.getText().toString();
        telefono= telefonoUsuario.getText().toString();
        fechaREgistro= fechaRegistroUsuario.getText().toString();
        ultimoLogin= ultimoLoginUsuario.getText().toString();

        for (int i=0;i<Global.listaClientesCreada.size();i++){
            if(i == Global.posListViewPersonalizado){
                Global.listaClientesCreada.get(i).setNombre(nombre);
                Global.listaClientesCreada.get(i).setLogin(contraseña);
                Global.listaClientesCreada.get(i).setTelefono(telefono);
                Global.listaClientesCreada.get(i).setFechaRegistro(fechaREgistro);
                Global.listaClientesCreada.get(i).setUltimoLogin(ultimoLogin);
                userLogin=Global.listaClientesCreada.get(i).getLogin();
                break;
            }
        }
        for (int i=0;i<Global.listaUsuarios.size();i++){
            if(Global.listaUsuarios.get(i).getLogin().equals(userLogin)){
                Global.listaUsuarios.get(i).setNombre(nombre);
                Global.listaUsuarios.get(i).setLogin(contraseña);
                Global.listaUsuarios.get(i).setTelefono(telefono);
                cliente = (Cliente) Global.listaUsuarios.get(i);
                cliente.setFechaRegistro(fechaREgistro);
                cliente.setUltimoLogin(ultimoLogin);

                RestAdapter.Builder builder4 = new RestAdapter.Builder()
                        .setEndpoint(Global.baseurl)
                        .setClient(new OkClient(new OkHttpClient()));// alt intro si da error...
                Global.server = builder4.build().create(Servidor.class);
                Global.server.modificarCliente(cliente, new Callback<String>() {
                    @Override
                    public void success(String respuesta, Response response) {
                        if (respuesta.equals("si")){
                            Toast.makeText(AppAdminEditarUsuariosListaUsuariosActivity.this,"si se realizo",Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(AppAdminEditarUsuariosListaUsuariosActivity.this,"no se realizo",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
                break;
            }
        }
    }

    public void encontrarValores(){
        /*se encarga de encontrar la distinta información del usuario para poder mostrarla al administrador para
        * facilitar el proceso de editar los datos*/


        for (int i=0;i<Global.listaClientesCreada.size();i++){
            if(i == Global.posListViewPersonalizado){
                nombre = Global.listaClientesCreada.get(i).getNombre();
                contraseña = Global.listaClientesCreada.get(i).getLogin();
                telefono= Global.listaClientesCreada.get(i).getTelefono();
                fechaREgistro=Global.listaClientesCreada.get(i).getFechaRegistro();
                  ultimoLogin=Global.listaClientesCreada.get(i).getUltimoLogin();

                if(Global.listaClientesCreada.get(i).getPermiso().equals(Global.permisosCliente)){
                    permiso=Global.permisosCliente;
                }
                else{
                    permiso=Global.permisosAdministrador;
                }

                break;
            }
        }
    }
}
