package com.example.pruebas.clase8sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Pruebas on 20/10/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {
    public static String DATABASE_NAME="base.db";
    public static String TABLA_NAME="productos";
    public static String COLUMN_NAME="nombre";
    public static String COLUM_DESCRIPCION="descripcion";
    public static String COLUMN_PRECIO="precio";
    public BaseDatos(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table "+TABLA_NAME+"( "+ COLUMN_NAME+ " text primary key, "+COLUM_DESCRIPCION+
                " text, "+ COLUMN_PRECIO+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean insertContact(String nombre,String descripcion,String precio){
        try {


            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put(COLUMN_NAME, nombre);
            registro.put(COLUM_DESCRIPCION, descripcion);
            registro.put(COLUMN_PRECIO, precio);

            db.insert(TABLA_NAME, null, registro);
            db.close();
            return true;
        }catch (Exception e){
            return false;
        }


    }
    public ArrayList<Producto> getDbInfo(){
        String query = "select * from "+TABLA_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        ArrayList<Producto> nuevaInfo = new ArrayList<Producto>();
        if(cursor.moveToFirst()){
            do{
                Producto list=new Producto();
                list.setNombre(cursor.getString(0));
                list.setDescripcion(cursor.getString(1));
                list.setPrecio(cursor.getString(2));
                nuevaInfo.add(list);

            }while (cursor.moveToNext());
        }
        return nuevaInfo;
    }

    public boolean updateContact(String oldName, String newName, String descripcion, String precio){
        try {
            SQLiteDatabase bd = this.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put(COLUMN_NAME,newName);
            registro.put(COLUM_DESCRIPCION,descripcion);
            registro.put(COLUMN_PRECIO,precio);
            bd.update(TABLA_NAME, registro, COLUMN_NAME + "='" + oldName + "'", null);
            bd.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public Integer deleteContact(String nombre){
        SQLiteDatabase bd = this.getWritableDatabase();
        return bd.delete(TABLA_NAME, COLUMN_NAME+"='" + nombre+"'", null);
    }
}
