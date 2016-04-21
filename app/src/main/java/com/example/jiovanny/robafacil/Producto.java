package com.example.jiovanny.robafacil;

/**
 * Created by daniel on 19/04/2016.
 */
public class Producto{
    private String nombre,descripcion;
    private int precio, id,categoria;
    public static final int ELECTRODOMESTICOS =1;
    public static final int LINEA_BLANCA =2;
    public static final int MUEBLES =3;
    public static final int AUTOS =4;

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        if (categoria==ELECTRODOMESTICOS)
            this.categoria=ELECTRODOMESTICOS;
        if (categoria==LINEA_BLANCA)
            this.categoria=LINEA_BLANCA;
        if (categoria==MUEBLES)
            this.categoria=MUEBLES;
        if (categoria==AUTOS)
            this.categoria=AUTOS;
    }

    public Producto() {
    }

    public Producto(String nombre, String descripcion, int precio, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
