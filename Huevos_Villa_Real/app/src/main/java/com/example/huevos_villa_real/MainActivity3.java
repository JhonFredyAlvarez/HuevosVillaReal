package com.example.huevos_villa_real;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    int op=0;
    LinearLayout CONTE;
    Fragment FRAG;
    Button B1,BSAVE;
    EditText E1,E2,E3,E4,E5;
    CheckBox c;
    GestorDB DB;


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
        DB=new GestorDB(this);

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
        DB.insertData(E1.getText().toString(),E2.getText().toString(),E3.getText().toString(),E4.getText().toString(),E5.getText().toString());
        Intent SA=new Intent(view.getContext(),MainActivity2.class);
        startActivity(SA);
        }



    }



