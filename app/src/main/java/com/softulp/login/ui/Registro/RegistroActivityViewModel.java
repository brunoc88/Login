package com.softulp.login.ui.Registro;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.login.Model.Usuario;
import com.softulp.login.databinding.ActivityRegistroBinding;
import com.softulp.login.request.ApliClient;


public class RegistroActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Usuario> mUsuario;


    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Usuario>getMutableUsuario(){
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }


    // Método para cargar datos del usuario y actualizar el LiveData
    public void leerDatos(Context context) {
        Usuario usuario = ApliClient.leer(context);
        mUsuario.setValue(usuario); // Actualiza el LiveData con los datos leídos
    }

    // Método para guardar el usuario
    public void guardarUsuario(Context context, String apellido, String mail, long dni, String password) {
        Usuario usuario = new Usuario(apellido, mail, dni, password);
        mUsuario.setValue(usuario);
        ApliClient.guardar(context, usuario);
    }





}