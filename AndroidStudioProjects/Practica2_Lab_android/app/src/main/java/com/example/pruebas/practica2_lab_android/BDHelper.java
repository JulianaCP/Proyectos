package com.example.pruebas.practica2_lab_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Pruebas on 02/11/2016.
 */
public class BDHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NOMBRE = "BaseVehiculos.db";
    public static final String TABLE_NAME = "Vehiculo";
    public static final String COLUMN_MATRICULA= "matricula";
    public static final String COLUMN_MARCA = "marca";
    public static final String COLUMN_MODELO = "modelo";

    public BDHelper(Context context) {
        super(context, DATABASE_NOMBRE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + COLUMN_MATRICULA + " text primary key,"+COLUMN_MARCA +
            " text ,"+COLUMN_MODELO+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertContact(String matricula, String marca, String modelo){
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put(COLUMN_MATRICULA, matricula);
        registro.put(COLUMN_MARCA, marca);
        registro.put(COLUMN_MODELO, modelo);
        bd.insert(TABLE_NAME, null, registro);
        bd.close();
        return true;
    }
    public boolean updateContact(String oldMatricula, String newMatricula, String newMarca, String newModelo){
        try {
            SQLiteDatabase bd = this.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put(COLUMN_MATRICULA, newMatricula);
            registro.put(COLUMN_MARCA, newMarca);
            registro.put(COLUMN_MODELO, newModelo);
            bd.update(TABLE_NAME, registro, COLUMN_MATRICULA + "='" + oldMatricula+"'", null);
            bd.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public Integer deleteContact(String matricula){
        SQLiteDatabase bd = this.getWritableDatabase();
        return bd.delete(TABLE_NAME, COLUMN_MATRICULA+"='" + matricula+"'", null);
    }
    public Cursor getData(String matricula){
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor fila =  bd.rawQuery("select * from "+TABLE_NAME+" where "+COLUMN_MATRICULA+"='" + matricula+"'", null);
        return fila;
    }
    public ArrayList<Vehiculo> getListData(){
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<Vehiculo> arrayListData = new ArrayList<Vehiculo>();
        if (cursor.moveToFirst()){
            do {
                Vehiculo nuevo = new Vehiculo();
                nuevo.setMatricula(cursor.getString(0));
                nuevo.setMarca(cursor.getString(1));
                nuevo.setModelo(cursor.getString(2));
                arrayListData.add(nuevo);
            } while (cursor.moveToNext());
        }
        return arrayListData;
    }
}
