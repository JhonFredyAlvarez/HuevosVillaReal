package com.example.huevos_villa_real;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    RecyclerView LISTAPRODUCTOS;
    List<Producto> PRODUCTOS;
    Context CONTEXTO;
    FirebaseFirestore db;
    String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=FirebaseFirestore.getInstance();
        LISTAPRODUCTOS=(RecyclerView)findViewById(R.id.lista);
        LISTAPRODUCTOS.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(CONTEXTO);
        LISTAPRODUCTOS.setLayoutManager(layoutManager);
        ADAPTADOR adaptador=new ADAPTADOR(PRODUCTOS);
        inicializaDATOS();

    }

    private void inicializaDATOS() {
        PRODUCTOS=new ArrayList<>();
        int i;
        db.collection("PRODUCTOS")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                PRODUCTOS.add(new Producto(document.get("TIPO").toString(),R.drawable.ic_launcher_background));
                            }
                            inicializaADAPTADOR();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
/*
        PRODUCTOS.add(new Producto("hola",R.drawable.ic_launcher_background));
        PRODUCTOS.add(new Producto("como",R.drawable.ic_launcher_background));
        PRODUCTOS.add(new Producto("te ",R.drawable.ic_launcher_background));
        PRODUCTOS.add(new Producto("va",R.drawable.ic_launcher_background));
*/
    }
    private void inicializaADAPTADOR() {
        ADAPTADOR adaptador=new ADAPTADOR(PRODUCTOS);
        LISTAPRODUCTOS.setAdapter(adaptador);
    }
}