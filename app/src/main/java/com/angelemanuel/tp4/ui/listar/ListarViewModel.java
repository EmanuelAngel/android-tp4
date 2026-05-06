package com.angelemanuel.tp4.ui.listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.angelemanuel.tp4.MainActivity;
import com.angelemanuel.tp4.model.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListarViewModel extends ViewModel {

    private final MutableLiveData<List<Producto>> productos = new MutableLiveData<>();

    public LiveData<List<Producto>> getProductos() {
        cargarProductos();
        return productos;
    }

    public void cargarProductos() {
        List<Producto> lista = new ArrayList<>(MainActivity.listaProductos);
        Collections.sort(lista, (p1, p2) -> p1.getDescripcion().compareToIgnoreCase(p2.getDescripcion()));
        productos.setValue(lista);
    }
}
