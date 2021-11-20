package com.example.huevos_villa_real;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    int op=0;
    LinearLayout CONTE;
    Fragment FRAG;
    Button B1;
    EditText E1,E2,E3,E4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        CONTE=(LinearLayout) findViewById(R.id.contenedor);
        CONTE.setVisibility(View.INVISIBLE);
        B1=(Button) findViewById(R.id.b1);
        E1=(EditText) findViewById(R.id.e1);
        E2=(EditText) findViewById(R.id.e2);
        E3=(EditText) findViewById(R.id.e3);
        E4=(EditText) findViewById(R.id.e4);
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
            case 1:
                CONTE.setVisibility(View.INVISIBLE);
                op=2;
                break;


        }
    }

    private void cargarFragmento(Fragment frag) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fragment,frag);
        transaction.commit();
    }
}