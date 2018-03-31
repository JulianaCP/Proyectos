package com.example.pruebas.practica3_lab_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Pruebas on 08/11/2016.
 */
public class BDHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NOMBRE = "baseProductos.db";
    public static final String TABLE_NAME = "Producto";
    public static final String COLUMN_CODIGO = "codigo";
    public static final String COLUMN_MARCA = "marca";
    public static final String COLUMN_PRECIO = "precio";
    public static final String COLUMN_DESCRIPCION = "descripcion";

    public BDHelper(Context context) {
        super(context, DATABASE_NOMBRE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + COLUMN_CODIGO + " text primary key,"+COLUMN_MARCA +
                " text ,"+COLUMN_PRECIO +  " text ,"+COLUMN_DESCRIPCION+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertContact(String codigo, String marca, String precio,String descripcion){
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put(COLUMN_CODIGO, codigo);
        registro.put(COLUMN_MARCA, marca);
        registro.put(COLUMN_PRECIO, precio);
        registro.put(COLUMN_DESCRIPCION, descripcion);
        bd.insert(TABLE_NAME, null, registro);
        bd.close();
        return true;
    }
    public boolean updateContact(String oldCodigo,String newCodigo, String newMarca, String newPrecio,String newDescripcion){
        try {
            SQLiteDatabase bd = this.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put(COLUMN_CODIGO, newCodigo);
            registro.put(COLUMN_MARCA, newMarca);
            registro.put(COLUMN_PRECIO, newPrecio);
            registro.put(COLUMN_DESCRIPCION, newDescripcion);
            bd.update(TABLE_NAME, registro, COLUMN_CODIGO + "='" + oldCodigo+"'", null);
            bd.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public Integer deleteContact(String codigo){
        SQLiteDatabase bd = this.getWritableDatabase();
        return bd.delete(TABLE_NAME, COLUMN_CODIGO+"='" + codigo+"'", null);
    }
    public Cursor getData(String codigo){
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor fila =  bd.rawQuery("select * from "+TABLE_NAME+" where "+COLUMN_CODIGO+"='" + codigo+"'", null);
        return fila;
    }
    public ArrayList<Producto> getListData(){
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<Producto> arrayListData = new ArrayList<Producto>();
        if (cursor.moveToFirst()){
            do {
                Producto nuevo = new Producto();
                nuevo.setCodigo(cursor.getString(0));
                nuevo.setMarca(cursor.getString(1));
                nuevo.setPrecio(cursor.getString(2));
                nuevo.setDescripcion(cursor.getString(3));
                arrayListData.add(nuevo);
            } while (cursor.moveToNext());
        }
        return arrayListData;
    }
}