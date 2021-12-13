package com.example.huevos_villa_real;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ADAPTADOR extends RecyclerView.Adapter<ADAPTADOR.ProductoViewHolder> {
    List<Producto>PRODUCTOS;
    public ADAPTADOR(List<Producto> PRODUCTOS)
    {
        this.PRODUCTOS=PRODUCTOS;
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview,viewGroup,false);
        ProductoViewHolder PVH=new ProductoViewHolder(view);
        return PVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder productoViewHolder, int i) {
        productoViewHolder.NombreProducto.setText(PRODUCTOS.get(i).NOMBRE);
        productoViewHolder.PrecioProducto.setText(PRODUCTOS.get(i).PRECIO);
        productoViewHolder.ImagenProducto.setImageResource(PRODUCTOS.get(i).Imgid);
    }

    @Override
    public int getItemCount() {
        return PRODUCTOS.size();
        //return 0;
        //return 4;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView NombreProducto;
        TextView PrecioProducto;
        ImageView ImagenProducto;
        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.Card);
            NombreProducto=(TextView)itemView.findViewById(R.id.t1Card);
            PrecioProducto=(TextView)itemView.findViewById(R.id.t1Card2);
            ImagenProducto=(ImageView)itemView.findViewById(R.id.imgCard);
        }
    }
}


