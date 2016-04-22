package com.example.jiovanny.robafacil;

/**
 * Created by daniel on 19/04/2016.
 */
public class Usuario {
    private String nombre;
    private String contrasena;
    private String correo;
    private String estado;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario() {
    }

    //Comentario del javi prueba GitHub
    //Comentario del javi prueba GitHub//Comentario del javi prueba GitHub//Comentario del javi prueba GitHub
    //Comentario del javi prueba GitHub



    public Usuario(int id,String nombre, String contrasena, String correo, String estado) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.estado = estado;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
