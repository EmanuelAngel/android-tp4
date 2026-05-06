package com.angelemanuel.tp4.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.angelemanuel.tp4.R;
import com.angelemanuel.tp4.model.Producto;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private final List<Producto> productos;

    public ProductoAdapter(List<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.tvDescripcion.setText(producto.getDescripcion());
        holder.tvCodigo.setText("Código: " + producto.getCodigo());
        holder.tvPrecio.setText("$" + producto.getPrecio());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvDescripcion;
        public final TextView tvCodigo;
        public final TextView tvPrecio;

        public ViewHolder(View view) {
            super(view);
            tvDescripcion = view.findViewById(R.id.tv_descripcion);
            tvCodigo = view.findViewById(R.id.tv_codigo);
            tvPrecio = view.findViewById(R.id.tv_precio);
        }
    }
}
