package com.example.jiovanny.robafacil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by daniel on 19/04/2016.
 */
public class MyBaseDatos extends SQLiteOpenHelper {
    //constantes
    private static final int VERSION_DATABASE = 1;
    private static final String NOMBRE_DATABASE = "robafacil.db";
    public static final String TABLA_USARIO = "usuario";
    private static final String KEY_ID_USUA = "id";
    private static final String KEY_NOM_USUA = "nombre";
    public static final String KEY_CONTRA_USUA = "contrasena";
    public static final String KEY_EMAIL = "email";
    private static final String KEY_ESTADO = "estado";
    private static final String[] COLUMNAS_USUARIO = {KEY_ID_USUA, KEY_NOM_USUA, KEY_CONTRA_USUA, KEY_EMAIL, KEY_ESTADO};
    public static final String TABLA_PRODUCTO = "producto";
    private static final String KEY_ID_PRO = "id";
    private static final String KEY_NOM_PRO = "nombre";
    private static final String KEY_DESC_ART = "descripcion";
    private static final String KEY_PRECIO = "precio";
    private static final String KEY_CATEGORIA = "categoria";
    private static final String[] COLUMNAS_PRODUCTO = {KEY_ID_PRO, KEY_NOM_PRO, KEY_DESC_ART, KEY_PRECIO,KEY_CATEGORIA};


    public MyBaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NOMBRE_DATABASE, factory, VERSION_DATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USARIO + "("+KEY_ID_USUA + " INTEGER PRIMARY KEY," + KEY_NOM_USUA + " TEXT,"+KEY_CONTRA_USUA+" TEXT,"+KEY_EMAIL+" TEXT," + KEY_ESTADO + " TEXT)";
        db.execSQL(CREAR_TABLA_USUARIO);
        String CREAR_TABLA_PRODUCTOS = "CREATE TABLE "+TABLA_PRODUCTO+"("+KEY_ID_PRO+" INTEGER PRIMARY KEY,"+ KEY_NOM_PRO+" TEXT,"+KEY_DESC_ART+" TEXT,"+KEY_PRECIO+" INTEGER,"+KEY_CATEGORIA+" INTEGER)";
        db.execSQL(CREAR_TABLA_PRODUCTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USARIO);
        this.onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PRODUCTO);
        this.onCreate(db);
    }

    public void addUsuario(Usuario usuario){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues valores= new ContentValues();
        valores.put(KEY_NOM_USUA,usuario.getNombre());
        valores.put(KEY_CONTRA_USUA,usuario.getContrasena());
        valores.put(KEY_EMAIL,usuario.getCorreo());
        valores.put(KEY_ESTADO,usuario.getEstado());
        db.insert(TABLA_USARIO,null,valores);
        db.close();
    }
    public void addProducto(Producto producto){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues valores= new ContentValues();
        valores.put(KEY_NOM_PRO,producto.getNombre());
        valores.put(KEY_DESC_ART,producto.getDescripcion());
        valores.put(KEY_PRECIO,producto.getPrecio());
        valores.put(KEY_CATEGORIA,producto.getCategoria());
        db.insert(TABLA_PRODUCTO,null,valores);
        db.close();
    }

    public Usuario getUsuario(String email){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.query(TABLA_USARIO,COLUMNAS_USUARIO,KEY_EMAIL+"= ?",new String[]{email},null,null,null,null);
        if (cursor==null)
            return null;
        if(!cursor.moveToFirst())
            return null;
        Usuario usuario= new Usuario();
        usuario.setId(Integer.parseInt(cursor.getString(0)));
        usuario.setNombre(cursor.getString(1));
        usuario.setContrasena(cursor.getString(2));
        usuario.setCorreo(cursor.getString(3));
        usuario.setEstado(cursor.getString(4));
        cursor.close();
        db.close();
        return usuario;
    }
    public Producto getProducto(String produc){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.query(TABLA_PRODUCTO,COLUMNAS_PRODUCTO,KEY_NOM_PRO+"= ?",new String[]{produc},null,null,null,null);
        if (cursor==null)
            return null;
        if(!cursor.moveToFirst())
            return null;
        Producto producto = new Producto();
        producto.setId(Integer.parseInt(cursor.getString(0)));
        producto.setNombre(cursor.getString(1));
        producto.setDescripcion(cursor.getString(2));
        producto.setPrecio(Integer.parseInt(cursor.getString(3)));
        producto.setCategoria(Integer.parseInt(cursor.getString(4)));
        cursor.close();
        db.close();
        return producto;
    }
    public Producto getProducto(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.query(TABLA_PRODUCTO,COLUMNAS_PRODUCTO,KEY_ID_PRO+"= ?",new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor==null)
            return null;
        if(!cursor.moveToFirst())
            return null;
        Producto producto = new Producto();
        producto.setId(Integer.parseInt(cursor.getString(0)));
        producto.setNombre(cursor.getString(1));
        producto.setDescripcion(cursor.getString(2));
        producto.setPrecio(Integer.parseInt(cursor.getString(3)));
        producto.setCategoria(Integer.parseInt(cursor.getString(4)));
        cursor.close();
        db.close();
        return producto;
    }
    public int getFilas(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.query(TABLA_PRODUCTO,COLUMNAS_PRODUCTO,null,null,null,null,null,null);
        int numFilas=cursor.getCount();
        return numFilas;
    }

}
