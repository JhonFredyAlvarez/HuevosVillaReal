package com.example.huevos_villa_real;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {
    int op=0;
    LinearLayout CONTE;
    Fragment FRAG;
    Button B1,BSAVE;
    EditText E1,E2,E3,E4,E5;
    CheckBox c;
    //GestorDB DB;
    FirebaseFirestore DB_FIRE;
    Map<String, Object> DATOSALMACENAR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        CONTE=(LinearLayout) findViewById(R.id.contenedor);
        CONTE.setVisibility(View.INVISIBLE);
        B1=(Button) findViewById(R.id.b1);
        BSAVE=(Button) findViewById(R.id.bsave);
        E1=(EditText) findViewById(R.id.e1);
        E2=(EditText) findViewById(R.id.e2);
        E3=(EditText) findViewById(R.id.e3);
        E4=(EditText) findViewById(R.id.e4);
        E5=(EditText) findViewById(R.id.e5);
        c=(CheckBox) findViewById(R.id.c);
        BSAVE.setVisibility(View.INVISIBLE);
        //DB=new GestorDB(this);
        DB_FIRE=FirebaseFirestore.getInstance();
        DATOSALMACENAR= new HashMap<>();

    }

    public void metodopolitica(View view) {
        switch (op)
        {
            case 0:
                CONTE.setVisibility(View.VISIBLE);
                FRAG=new Fragmento1();
                op=1;
                cargarFragmento(FRAG);
                break;
            /*case 1:
                CONTE.setVisibility(View.INVISIBLE);
                op=2;
                break;*/


        }
    }

    private void cargarFragmento(Fragment frag) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fragment,frag);
        transaction.commit();
    }


    public void onClick(View view) {//(view.getId()==R.id.c)
        if(c.isChecked()){
            BSAVE.setVisibility(View.VISIBLE);
        }
        else{
            BSAVE.setVisibility(View.INVISIBLE);
        }

    }

    public void cambio(View view){
        //DB.insertData(E1.getText().toString(),E2.getText().toString(),E3.getText().toString(),E4.getText().toString(),E5.getText().toString());
        DATOSALMACENAR.put("NOMBRE",E1.getText().toString());
        DATOSALMACENAR.put("APELLIDO",E2.getText().toString());
        DATOSALMACENAR.put("EMAIL",E3.getText().toString());
        DATOSALMACENAR.put("USUARIO",E4.getText().toString());
        DATOSALMACENAR.put("CONTRASEÑA",E5.getText().toString());
        DB_FIRE.collection("USUARIOS").document(E4.getText().toString()).set(DATOSALMACENAR);
        Toast toast= Toast.makeText(this,"",Toast.LENGTH_SHORT);
        toast.setText("Registro guardado");
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        Intent SA=new Intent(view.getContext(),MainActivity2.class);
        startActivity(SA);
    }



    }



