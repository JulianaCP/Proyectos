package com.example.pruebas.proyectolenguajes;

import java.util.ArrayList;

/**
 * Created by Pruebas on 20/10/2016.
 */
public class Global {

    //constantes

    public static final String permisosAdministrador = "Administrador";
    public static final String permisosCliente = "Cliente";

    //listas

    public static ArrayList<Usuario> listaUsuarios = new ArrayList();
    public static ArrayList<Producto> listaProductosObjetos = new ArrayList<Producto>();

    public static ArrayList<Cliente> listaClientesCreada = new ArrayList<Cliente>();
    //variablews
    public static int posicionItemListViewPresionado;
    public static int posListViewPersonalizado;


    //constructor
    public Global(){

    }
}
