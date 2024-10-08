package com.softulp.login.ui.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.login.R;
import com.softulp.login.databinding.ActivityMainBinding;
import com.softulp.login.request.ApliClient;
import com.softulp.login.ui.Registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // Observamos el LiveData de loginSuccess
        vm.getLoginSuccess().observe(this, success -> {
            if (success) {
                // Si el login fue exitoso, navegar a la segunda Activity
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            } else {
                // Mostrar un mensaje de error si el login falló
                Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = binding.etUsuario.getText().toString();
                String password = binding.etPassword.getText().toString();
                vm.login(MainActivity.this, usuario, password);  // Pasamos el contexto de la Activity
            }
        });

        binding.btRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}
