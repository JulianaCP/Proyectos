package com.example.pruebas.practicacertificado;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Pruebas on 04/02/2017.
 */
public class BDHelper extends SQLiteOpenHelper {
    public static final String BASE_NAME = "base.db";
    public static final String TABLE_NAME_VEHICULO = "vehiculo";
    public static final String TABLE_NAME_PLACA = "placa";
    public static final String TABLE_NAME_MODELO = "modelo";
    public static final String TABLE_NAME_COLOR = "color";

    public BDHelper(Context context){

        super(context,BASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME_VEHICULO+"("+TABLE_NAME_PLACA+" text primary key ,"
                +TABLE_NAME_MODELO+" text , "+TABLE_NAME_COLOR+" text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME_VEHICULO);
        onCreate(sqLiteDatabase);
    }
    public boolean insertar(String placaVar,String modeloVar,String colorVar){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put(TABLE_NAME_PLACA,placaVar);
        registro.put(TABLE_NAME_MODELO,modeloVar);
        registro.put(TABLE_NAME_COLOR,colorVar);
        db.insert(TABLE_NAME_VEHICULO,null,registro);
        db.close();
        return true;
    }
    public Integer eliminar(String placaVar){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_VEHICULO,TABLE_NAME_PLACA+"='"+placaVar+"'",null);
    }
    public boolean editar(String placaVarOld,String placaVarNew,String modeloVarNew,String colorVarNew){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put(TABLE_NAME_PLACA,placaVarNew);
            registro.put(TABLE_NAME_MODELO,modeloVarNew);
            registro.put(TABLE_NAME_COLOR,colorVarNew);
            db.update(TABLE_NAME_VEHICULO,registro,TABLE_NAME_PLACA+"='"+placaVarOld+"'",null);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public ArrayList<Vehiculo> getInfo(){
        String query = "select * from "+TABLE_NAME_VEHICULO;
        Global.listaVehiculos.clear();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do{
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setPlaca(cursor.getString(0));
                vehiculo.setModelo(cursor.getString(1));
                vehiculo.setColor(cursor.getString(2));
                Global.listaVehiculos.add(vehiculo);
            }while(cursor.moveToNext());

        }
        return Global.listaVehiculos;
    }
    public ArrayList<Vehiculo> getInfoModelo(String modeloVar){
        String query = "select * from "+TABLE_NAME_VEHICULO+" where "+TABLE_NAME_MODELO+" ='"+modeloVar+"'";
        Global.listaVehiculos.clear();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do{
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setPlaca(cursor.getString(0));
                vehiculo.setModelo(cursor.getString(1));
                vehiculo.setColor(cursor.getString(2));
                Global.listaVehiculos.add(vehiculo);
            }while(cursor.moveToNext());

        }
        return Global.listaVehiculos;
    }
}
