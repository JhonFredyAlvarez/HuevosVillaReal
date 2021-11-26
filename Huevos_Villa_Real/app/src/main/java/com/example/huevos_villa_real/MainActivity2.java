package com.example.huevos_villa_real;

import android.content.Intent;
import android.database.Cursor;
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
    GestorDB DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        E1=(EditText) findViewById(R.id.e1);
        E2=(EditText) findViewById(R.id.e2);
        B1=(Button) findViewById(R.id.b1);
        TS=(TextView)findViewById(R.id.txtsign);
        registerForContextMenu(TS);
        DB=new GestorDB(this);

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
        Cursor res=DB.getData(E1.getText().toString());
        String user=null;
        String pass=null;
        String username,password;
        int v1,v2;
        username=E1.getText().toString();
        password=E2.getText().toString();
        //validacion
        v1=validarDatos(1,username);
        v2=validarDatos(1,password);
        if (v1!=1 || v2!=1)
        {
            Toast toast= Toast.makeText(this,"",Toast.LENGTH_SHORT);
            toast.setText(R.string.txtok);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        else
        {
            Toast toast= Toast.makeText(this,"",Toast.LENGTH_LONG);
            toast.setText(R.string.txtuserincorrect);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }

        if(res.moveToFirst())
        {
            user=res.getString(4);
            pass=res.getString(5);
        }
        
        if(E1.getText().toString().equals(user) && E2.getText().toString().equals(pass)) {
            Intent SA = new Intent(MainActivity2.this, MainActivity5.class);
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

    private int validarDatos(int i, String cadena) {
        int validacion=1, c, pos;
        switch (i) {
            case 1:
                for (pos = 0; pos < cadena.length(); pos = pos + 1) {
                    c = cadena.charAt(pos);
                    if (c < 65 || c > 90) {
                        validacion = 0;
                        pos = cadena.length();
                    }

                }
                break;

            case 2:
                for (pos = 0; pos < cadena.length(); pos = pos + 1) {
                    c = cadena.charAt(pos);
                    if (c < 48 || c > 57) {
                        validacion = 0;
                        pos = cadena.length();
                    }

                }
                break;
        }
        return validacion;
    }

    }


