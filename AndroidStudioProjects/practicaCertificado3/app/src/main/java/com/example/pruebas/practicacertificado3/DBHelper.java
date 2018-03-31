package com.example.pruebas.practicacertificado3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Pruebas on 12/02/2017.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String BASE_NAME = "base.db";
    public static final String TABLE_PERSONA = "persona";
    public static final String TABLE_PERSONA_ID = "id";
    public static final String TABLE_PERSONA_NOMBRE = "nombre";
    public static final String TABLE_PERSONA_SEXO = "sexo";
    public static ArrayList<Persona> lista = new ArrayList<>();
    public DBHelper(Context context){
        super(context,BASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_PERSONA+" ("+TABLE_PERSONA_ID+" text primary key ,"
                +TABLE_PERSONA_NOMBRE+" text ,"+TABLE_PERSONA_SEXO+" text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_PERSONA_NOMBRE);
        onCreate(sqLiteDatabase);
    }
    public boolean insertar(String idVar,String nombreVar,String sexoVar){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put(TABLE_PERSONA_ID,idVar);
        registro.put(TABLE_PERSONA_NOMBRE,nombreVar);
        registro.put(TABLE_PERSONA_SEXO,sexoVar);
        db.insert(TABLE_PERSONA,null,registro);
        db.close();
        return true;
    }
    public Integer eliminar(String idVar){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_PERSONA,TABLE_PERSONA_ID+"='"+idVar+"'",null);
    }
    public boolean editar(String idVarOld,String idVarNew,String nombreVarNew,String sexoVarNew){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put(TABLE_PERSONA_ID,idVarNew);
            registro.put(TABLE_PERSONA_NOMBRE,nombreVarNew);
            registro.put(TABLE_PERSONA_SEXO,sexoVarNew);
            db.update(TABLE_PERSONA,registro,TABLE_PERSONA_ID+"='"+idVarOld+"'",null);
            db.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public ArrayList<Persona> getInfo(){
        String query = "select * from "+TABLE_PERSONA;
        SQLiteDatabase db = this.getReadableDatabase();
        lista.clear();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){

            do{
                Persona persona = new Persona();
                persona.setId(cursor.getString(0));
                persona.setNombre(cursor.getString(1));
                persona.setSexo(cursor.getString(2));
                lista.add(persona);
            }while (cursor.moveToNext());
        }
        return lista;
    }
    public ArrayList<Persona> getInfoEspecificas(String sexo){
        String query = "select * from "+TABLE_PERSONA +" where "+TABLE_PERSONA_SEXO +"='"+sexo+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        lista.clear();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Persona persona = new Persona();
                persona.setId(cursor.getString(0));
                persona.setNombre(cursor.getString(1));
                lista.add(persona);
            }while (cursor.moveToNext());
        }
        return lista;
    }


}
