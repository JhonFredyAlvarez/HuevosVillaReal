package com.example.huevos_villa_real;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText E1,E2;
    Button B1;
    TextView TS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        E1=(EditText) findViewById(R.id.e1);
        E2=(EditText) findViewById(R.id.e2);
        B1=(Button) findViewById(R.id.b1);
        TS=(TextView)findViewById(R.id.txtsign);
        registerForContextMenu(TS);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Create new account");
        menu.add(0,v.getId(),0,"Create");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle()=="Create")
        {
            Intent SA = new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(SA);
        }
        return true;
    }

    public void onClick(View view) {
        if(E1.getText().toString().equals("jhon377") && E2.getText().toString().equals("1234")) {
            Intent SA = new Intent(MainActivity2.this, MainActivity4.class);
            startActivity(SA);
        }
        else
            {
                Toast toast= Toast.makeText(this,"",Toast.LENGTH_LONG);
                toast.setText(R.string.txtuserincorrect);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();


            }
        }
    }


