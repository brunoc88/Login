package com.softulp.login.ui.Login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.login.Model.Usuario;
import com.softulp.login.databinding.ActivityMainBinding;
import com.softulp.login.request.ApliClient;
import com.softulp.login.ui.Registro.RegistroActivity;
import com.softulp.login.ui.Registro.RegistroActivityViewModel;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Usuario> mUsuario;
    private MutableLiveData<Boolean> loginSuccess = new MutableLiveData<>(); // Para indicar éxito en el login
    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Usuario> getMUsuario() {
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }

    public LiveData<Boolean> getLoginSuccess() {
        return loginSuccess;
    }

    public void login(Context context, String mail, String clave) {
        Usuario usuario = ApliClient.Login(context, mail, clave);

        if (usuario != null) {
            // Usuario válido, marcar login exitoso
            loginSuccess.setValue(true);
        } else {
            // Login fallido
            loginSuccess.setValue(false);
            Log.d("MainActivityViewModel", "Usuario o contraseña incorrectos");
        }
    }
}

