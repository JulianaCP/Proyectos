package com.example.pruebas.clasedoslenguajesandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pruebas on 17/11/2016.
 */
public class Borrar extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Base.bd";
    public static final String TABLE_PRODUCTO = "Producto";
    public static final String TABLE_PRODUCTO_COLUMN_CODIGO = "codigo";
    public static final String TABLE_PRODUCTO_COLUMN_NOMBRE = "nombre";
    public static final String TABLE_PRODUCTO_COLUMN_PRECIO = "precio";

    public Borrar(Context context){
        super(context,DATABASE_NAME,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create  table " + TABLE_PRODUCTO + " ("+TABLE_PRODUCTO_COLUMN_CODIGO + " text primary key,"+TABLE_PRODUCTO_COLUMN_NOMBRE+
        " text,"+TABLE_PRODUCTO_COLUMN_PRECIO+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exist "+TABLE_PRODUCTO);
        onCreate(sqLiteDatabase);
    }
}
