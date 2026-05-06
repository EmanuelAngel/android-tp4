package com.angelemanuel.tp4.ui.cargar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.angelemanuel.tp4.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private CargarViewModel cargarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cargarViewModel = new ViewModelProvider(this).get(CargarViewModel.class);

        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnGuardar.setOnClickListener(v -> {
            String codigo = binding.etCodigo.getText().toString();
            String descripcion = binding.etDescripcion.getText().toString();
            String precio = binding.etPrecio.getText().toString();
            cargarViewModel.guardarProducto(codigo, descripcion, precio);
        });

        cargarViewModel.getErrorCodigo().observe(getViewLifecycleOwner(), error -> {
            binding.tilCodigo.setError(error);
        });

        cargarViewModel.getErrorDescripcion().observe(getViewLifecycleOwner(), error -> {
            binding.tilDescripcion.setError(error);
        });

        cargarViewModel.getErrorPrecio().observe(getViewLifecycleOwner(), error -> {
            binding.tilPrecio.setError(error);
        });

        cargarViewModel.getExitoGuardado().observe(getViewLifecycleOwner(), exito -> {
            if (exito) {
                Toast.makeText(getContext(), "Producto guardado con éxito", Toast.LENGTH_SHORT).show();
                limpiarCampos();
            }
        });

        return root;
    }

    private void limpiarCampos() {
        binding.etCodigo.setText("");
        binding.etDescripcion.setText("");
        binding.etPrecio.setText("");
        binding.tilCodigo.setError(null);
        binding.tilDescripcion.setError(null);
        binding.tilPrecio.setError(null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
