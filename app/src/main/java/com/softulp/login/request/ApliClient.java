package com.softulp.login.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.softulp.login.Model.Usuario;

public class ApliClient {
    private static SharedPreferences sp;

    public static SharedPreferences conectar(Context context){
        if(sp == null){
            sp = context.getSharedPreferences("Datos",0);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario){
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("dni",usuario.getDni());
        editor.putString("apellido",usuario.getApellido());
        editor.putString("mail",usuario.getMail());
        editor.putString("password",usuario.getPassword());
        editor.apply();

    }

    public static Usuario leer(Context context){
        SharedPreferences sp = conectar(context);
        long dni = sp.getLong("dni", -1);
        String apellido = sp.getString("apellido","-1");
        String mail = sp.getString("mail","-1");
        String password = sp.getString("password","-1");

        Usuario usuario = new Usuario(apellido,mail,dni,password);
        return usuario;
    }

    public static Usuario Login(Context context, String mail, String password){
        Usuario usuario = null;
        SharedPreferences sp = conectar(context);
        long dni = sp.getLong("dni", -1);
        String apellido = sp.getString("apellido","-1");
        String email = sp.getString("mail","-1");
        String pass= sp.getString("password","-1");

        if(mail.equals(email) && password.equals(pass)){
            usuario = new Usuario(apellido,email,dni,pass);
        }
        return usuario;
    }
}
