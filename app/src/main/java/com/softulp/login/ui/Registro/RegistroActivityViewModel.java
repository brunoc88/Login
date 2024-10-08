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
    private MutableLiveData<Usuario> mUsuario = new MutableLiveData<>();

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Usuario> getMutableUsuario() {
        return mUsuario;
    }

    // Método para leer los datos del usuario
    public void leerDatos(Context context) {
        Usuario usuario = ApliClient.leer(context);
        mUsuario.setValue(usuario); // Establecer el usuario en LiveData
    }


    // Método para guardar el usuario
    public void guardarUsuario(Context context, String apellido, String mail, long dni, String password) {
        Usuario usuario = new Usuario(apellido, mail, dni, password);
        ApliClient.guardar(context, usuario);
        mUsuario.setValue(usuario); // Actualizar el LiveData con el nuevo usuario guardado
    }
}





