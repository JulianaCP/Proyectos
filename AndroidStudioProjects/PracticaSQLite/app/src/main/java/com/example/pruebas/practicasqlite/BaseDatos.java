package com.example.pruebas.practicasqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pruebas on 27/10/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {
    public static String nombre_base = "basePracticaSQLite.db";


    //tabla persona
    public static String personas = "personas";
    public static String nombrePersona = "nombre";
    public static String apellido1Persona = "apellido1";
    public static String apellido2Persona = "apellido2";
    public static String cedulaPersona = "cedula";
    public static String edad = "edad";


    //tabla est
    public static String estudiantes = "estudiantes";
    public static String carneEstudiante = "carne";


    //tabla profesores

    public static String profesores = "profesores";
    public static String idProfesor = "idProfesor";
    public static String departamento = "departamento";

    //tabla cursos
    public static String cursos = "cursos";
    public static String idCurso = "idCurso";
    public static String nombreCurso = "nombre";
    public static String creditosCurso = "creditos";


    //tabla cursos - estudiantes
    public static String cursos_estudiantes = "cursos_estudiantes";







    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,nombre_base, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
