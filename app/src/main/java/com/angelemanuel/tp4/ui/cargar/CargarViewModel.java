package com.angelemanuel.tp4.ui.cargar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.angelemanuel.tp4.MainActivity;
import com.angelemanuel.tp4.model.Producto;

public class CargarViewModel extends ViewModel {

    private final MutableLiveData<String> errorCodigo = new MutableLiveData<>();
    private final MutableLiveData<String> errorDescripcion = new MutableLiveData<>();
    private final MutableLiveData<String> errorPrecio = new MutableLiveData<>();
    private final MutableLiveData<Boolean> exitoGuardado = new MutableLiveData<>();

    public LiveData<String> getErrorCodigo() {
        return errorCodigo;
    }

    public LiveData<String> getErrorDescripcion() {
        return errorDescripcion;
    }

    public LiveData<String> getErrorPrecio() {
        return errorPrecio;
    }

    public LiveData<Boolean> getExitoGuardado() {
        return exitoGuardado;
    }

    public void guardarProducto(String codigoStr, String descripcion, String precioStr) {
        boolean error = false;
        int codigo = 0;
        double precio = 0;

        if (codigoStr.isEmpty()) {
            errorCodigo.setValue("Campo vacío");
            error = true;
        } else {
            try {
                codigo = Integer.parseInt(codigoStr);
                if (existeCodigo(codigo)) {
                    errorCodigo.setValue("Código repetido");
                    error = true;
                } else {
                    errorCodigo.setValue(null);
                }
            } catch (NumberFormatException e) {
                errorCodigo.setValue("Código inválido");
                error = true;
            }
        }

        if (descripcion.isEmpty()) {
            errorDescripcion.setValue("Campo vacío");
            error = true;
        } else {
            errorDescripcion.setValue(null);
        }

        if (precioStr.isEmpty()) {
            errorPrecio.setValue("Campo vacío");
            error = true;
        } else {
            try {
                precio = Double.parseDouble(precioStr);
                errorPrecio.setValue(null);
            } catch (NumberFormatException e) {
                errorPrecio.setValue("Precio inválido");
                error = true;
            }
        }

        if (!error) {
            Producto nuevoProducto = new Producto(codigo, descripcion, precio);
            MainActivity.listaProductos.add(nuevoProducto);
            exitoGuardado.setValue(true);
            exitoGuardado.setValue(false); // Reset to prevent re-triggering
        }
    }

    private boolean existeCodigo(int codigo) {
        for (Producto p : MainActivity.listaProductos) {
            if (p.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
}
