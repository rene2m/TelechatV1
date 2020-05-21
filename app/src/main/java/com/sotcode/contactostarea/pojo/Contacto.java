package com.sotcode.contactostarea.pojo;

public class Contacto {
    private int id ;
    private String nombre;
    private String telefono;
    private String email;
    private int foto;
    private int like;
    public Contacto(int foto, String nombre, String telefono, String email, int like) {
        this.foto=foto;
        this.nombre= nombre;
        this.telefono=telefono;
        this.email=email;
        this.like = like;
    }

    public Contacto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
