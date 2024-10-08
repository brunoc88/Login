package com.softulp.login.Model;

public class Usuario {
    private String Apellido;
    private String Mail;
    private long Dni;
    private String Password;

    public Usuario(String apellido, String mail, long dni, String password) {
        Apellido = apellido;
        Mail = mail;
        Dni = dni;
        Password = password;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public long getDni() {
        return Dni;
    }

    public void setDni(long dni) {
        Dni = dni;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
