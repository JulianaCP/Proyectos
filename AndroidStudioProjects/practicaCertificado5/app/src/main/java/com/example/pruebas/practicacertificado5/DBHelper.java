package com.example.pruebas.practicacertificado5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Pruebas on 14/02/2017.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String BASE_NAME = "base.db";
    public static final String TABLE_PERSONA = "persona";
    public static final String TABLE_PERSONA_ID = "idPersona";
    public static final String TABLE_PERSONA_NOMBRE = "nombrePersona";
    public static final String TABLE_PERSONA_EDAD = "edadPersona";
    public static ArrayList<Persona> lista = new ArrayList<>();
    public DBHelper(Context context){
        super(context,BASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_PERSONA+" ("+TABLE_PERSONA_ID+" text primary key , "
                +TABLE_PERSONA_NOMBRE+" text , "+TABLE_PERSONA_EDAD+" text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_PERSONA);
        onCreate(sqLiteDatabase);
    }
    public boolean insertar(String idVar,String nombreVar,String edadVar){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put(TABLE_PERSONA_ID,idVar);
        registro.put(TABLE_PERSONA_NOMBRE,nombreVar);
        registro.put(TABLE_PERSONA_EDAD,edadVar);
        db.insert(TABLE_PERSONA,null,registro);
        db.close();
        return true;
    }
    public ArrayList<Persona> getInfo(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from "+TABLE_PERSONA;
        Cursor cursor = db.rawQuery(query,null);
        lista.clear();
        if (cursor.moveToFirst()){
            do{
                Persona persona = new Persona();
                persona.setId(cursor.getString(0));
                persona.setNombre(cursor.getString(1));
                persona.setEdad(cursor.getString(2));
                lista.add(persona);
            }while (cursor.moveToNext());

        }
        return lista;
    }
    public ArrayList<Persona> getInfoEspecifico(String edad){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from "+TABLE_PERSONA + " where "+TABLE_PERSONA_EDAD+"='"+edad+"'";
        Cursor cursor = db.rawQuery(query,null);
        lista.clear();
        if (cursor.moveToFirst()){
            do{
                Persona persona = new Persona();
                persona.setId(cursor.getString(0));
                persona.setNombre(cursor.getString(1));
                persona.setEdad(cursor.getString(2));
                lista.add(persona);
            }while (cursor.moveToNext());

        }
        return lista;
    }
    public Integer eliminar(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_PERSONA,TABLE_PERSONA_ID+"='"+id+"'",null);
    }
    public boolean editar(String idOld,String idNew,String nombreNew,String edadNew){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put(TABLE_PERSONA_ID,idNew);
            registro.put(TABLE_PERSONA_NOMBRE,nombreNew);
            registro.put(TABLE_PERSONA_EDAD,edadNew);
            db.update(TABLE_PERSONA,registro,TABLE_PERSONA_ID+"='"+idOld+"'",null);
            db.close();
            return true;
        }catch (Exception e){
            return false;
        }
    };
}
