package com.example.huevos_villa_real;

import android.content.Intent;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity2 extends AppCompatActivity {
    EditText E1, E2;
    Button B1;
    TextView TS;
    //GestorDB DB;
    FirebaseFirestore DB_FIRE;
    TextView TP,TP1,TS1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        E1 = (EditText) findViewById(R.id.e1);
        E2 = (EditText) findViewById(R.id.e2);
        B1 = (Button) findViewById(R.id.b1);
        TS = (TextView) findViewById(R.id.txtsign2);
        TS1 = (TextView) findViewById(R.id.txtsign);
        TP =(TextView)findViewById(R.id.txtpolitica2);
        TP1 =(TextView)findViewById(R.id.txtpolitica);
        registerForContextMenu(TS1);
        //DB = new GestorDB(this);

        DB_FIRE=FirebaseFirestore.getInstance();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Create new account");
        menu.add(0, v.getId(), 0, "Create");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle() == "Create") {
            Intent SA = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(SA);
        }
        return true;
    }

    public void onClick(View view) {
        String user =null;
        String pass = null;
        String username, password;
        boolean v1, v2;
        username = E1.getText().toString();
        password = E2.getText().toString();
        if(username==user && password==pass) {
            Toast toast= Toast.makeText(this,"",Toast.LENGTH_LONG);
            toast.setText("Debe de ingresar datos");
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();

        }
        /*else
        {

                    Toast toast= Toast.makeText(this,"",Toast.LENGTH_LONG);
                    toast.setText(R.string.txtuserincorrect);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();


        }*/

        DB_FIRE.collection("USUARIOS").document(username)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
            TP.setText(documentSnapshot.get("USUARIO").toString());
            TS.setText(documentSnapshot.get("CONTRASEÑA").toString());
                if(E1.getText().toString().equals(TP.getText().toString()) && E2.getText().toString().equals(TS.getText().toString())) {
                    Intent SA = new Intent(MainActivity2.this, MainActivity4.class);
                    startActivity(SA);

                }
                else
                {
                    TP1.setText("Usuario y/o contraseña incorrecta");
                    /*Toast toast= Toast.makeText(this,"",Toast.LENGTH_LONG);
                    toast.setText(R.string.txtuserincorrect);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();*/


                }
            }
        });

        //Cursor res=DB.getData(E1.getText().toString());


        /*//validacion
        v1=username.matches("[A-Z.*]");
        v2=password.matches("[A-Z.*]");
        if(v1!=true || v2!=true)
        {
            Toast toast= Toast.makeText(this,"",Toast.LENGTH_LONG);
            toast.setText(R.string.txtuserincorrect);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        else
            {
                Toast toast= Toast.makeText(this,"",Toast.LENGTH_SHORT);
                toast.setText(R.string.txtok);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }*/


        /*v1=validarDatos(1,username);
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


        }*/

       /* if(res.moveToFirst())
        {
            user=res.getString(4);
            pass=res.getString(5);
        }
        
        if(E1.getText().toString().equals(user) && E2.getText().toString().equals(pass)) {
            Intent SA = new Intent(MainActivity2.this, MainActivity5.class);
            startActivity(SA);
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

        }*/

    /*private int validarDatos(int i, String cadena) {
        int validacion=1, c, pos;
        switch (i) {
            case 1:
                for (pos = 0; pos < cadena.length(); pos = pos + 1) {
                    c = cadena.charAt(pos);
                    if (c < 65 || c > 90 && c < 97 || c > 122 && c < 48 || c > 57) {
                        validacion = 0;
                        pos = cadena.length();
                    }

                }
                break;


        }
        return validacion;
    }*/

    }
}


