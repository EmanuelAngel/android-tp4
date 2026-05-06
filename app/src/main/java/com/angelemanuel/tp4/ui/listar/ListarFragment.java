package com.angelemanuel.tp4.ui.listar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.angelemanuel.tp4.databinding.FragmentListarBinding;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel listarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listarViewModel = new ViewModelProvider(this).get(ListarViewModel.class);

        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listarViewModel.getProductos().observe(getViewLifecycleOwner(), productos -> {
            ProductoAdapter adapter = new ProductoAdapter(productos);
            binding.rvProductos.setAdapter(adapter);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
