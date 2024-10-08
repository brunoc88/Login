package com.softulp.login.ui.Registro;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.login.Model.Usuario;
import com.softulp.login.R;
import com.softulp.login.databinding.ActivityRegistroBinding;
import com.softulp.login.request.ApliClient;

public class RegistroActivity extends AppCompatActivity {
    private ActivityRegistroBinding binding;
    private RegistroActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(RegistroActivityViewModel.class);


        // Leer los datos del usuario desde el ViewModel
        vm.leerDatos(getApplicationContext());
        //mostrar gatos
        // Observa los cambios en mUsuario
        vm.getMutableUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                // Actualiza la interfaz de usuario con los datos del usuario
                if (usuario != null) {
                    binding.etApellido.setText(usuario.getApellido());
                    binding.etMail.setText(usuario.getMail());
                    binding.etDni.setText(String.valueOf(usuario.getDni()));
                    binding.etClave.setText(usuario.getPassword());
                }
            }
        });

        // Botón de Guardar
        binding.btGuardar.setOnClickListener(v -> {
            String apellido = binding.etApellido.getText().toString();
            String mail = binding.etMail.getText().toString();
            long dni;
            try {
                dni = Long.parseLong(binding.etDni.getText().toString());
            } catch (NumberFormatException e) {
                binding.etDni.setError("DNI inválido");
                return;
            }
            String password = binding.etClave.getText().toString();

            // Guardar el usuario desde el ViewModel
            vm.guardarUsuario(getApplicationContext(), apellido, mail, dni, password);
            Toast.makeText(getApplicationContext(), "Usuario guardado", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
