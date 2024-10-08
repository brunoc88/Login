package com.softulp.login.ui.Login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

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
    private MutableLiveData<Boolean> loginStatus = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getLoginStatus() {
        return loginStatus;
    }

    public void login(Context context, String mail, String clave) {
        Usuario usuario = ApliClient.Login(context, mail, clave);

        if (usuario != null) {
            // Usuario válido, marcar login exitoso
            loginStatus.setValue(true);
            Intent intent = new Intent(context, RegistroActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//porque estamos iniciando una activy desde un lugar que no es una activity
            context.startActivity(intent);
        } else {
            // Login fallido
            loginStatus.setValue(false);
            // Mostrar mensaje de error
            Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

}


