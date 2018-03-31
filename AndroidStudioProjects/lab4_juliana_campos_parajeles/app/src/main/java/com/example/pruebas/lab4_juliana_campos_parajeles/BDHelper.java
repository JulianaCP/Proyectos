package com.example.pruebas.lab4_juliana_campos_parajeles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Pruebas on 09/11/2016.
 */

public class BDHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NOMBRE = "MiBD.db";
    public static final String TABLE_NOMBRE = "Vehiculo";
    public static final String COLUMN_PLACA = "placa";
    public static final String COLUMN_MODELO = "modelo";
    public static final String COLUMN_MARCA = "marca";


    public BDHelper(Context context) {
        super(context, DATABASE_NOMBRE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NOMBRE + "(" + COLUMN_PLACA +
                " text primary key," + COLUMN_MODELO +
                " text, " + COLUMN_MARCA + " text)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NOMBRE);
        onCreate(db);
    }
    public boolean insertContact(String placa, String modelo, String marca){
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put(COLUMN_PLACA, placa);
        registro.put(COLUMN_MODELO, modelo);
        registro.put(COLUMN_MARCA, marca);
        bd.insert(TABLE_NOMBRE, null, registro);
        bd.close();
        return true;
    }

    public ArrayList<Vehiculo> getData(String modelo){
        String selectQuery = "SELECT  * FROM " + TABLE_NOMBRE+" where "+COLUMN_MODELO+"='" + modelo+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<Vehiculo> arrayListData = new ArrayList<Vehiculo>();
        if (cursor.moveToFirst()){
            do {
                Vehiculo list = new Vehiculo();
                list.setPlaca(cursor.getString(0));
                list.setModelo(cursor.getString(1));
                list.setMarca(cursor.getString(2));
                arrayListData.add(list);
            } while (cursor.moveToNext());
        }
        return arrayListData;
    }


    public ArrayList<Vehiculo> getListData(){
        String selectQuery = "SELECT  * FROM " + TABLE_NOMBRE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<Vehiculo> arrayListData = new ArrayList<Vehiculo>();
        if (cursor.moveToFirst()){
            do {
                Vehiculo list = new Vehiculo();
                list.setPlaca(cursor.getString(0));
                list.setModelo(cursor.getString(1));
                list.setMarca(cursor.getString(2));
                arrayListData.add(list);
            } while (cursor.moveToNext());
        }
        return arrayListData;
    }
}