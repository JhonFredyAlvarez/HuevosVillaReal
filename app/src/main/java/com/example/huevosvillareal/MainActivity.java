package com.example.huevosvillareal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

Button B1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B1=(Button) findViewById(R.id.b1);

        B1.setOnClickListener(new View.OnClickListener(){

            @Override //No se porque no me visualiza la segunda activity
            public void  onClick(View view){

                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }


        });
    }

    }










