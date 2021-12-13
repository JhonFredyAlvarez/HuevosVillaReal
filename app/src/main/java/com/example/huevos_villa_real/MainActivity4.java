package com.example.huevos_villa_real;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView T1;
    ImageView IMG;
    AnimationDrawable ANIMACION;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        T1=(TextView)findViewById(R.id.t1);
        IMG=(ImageView)findViewById(R.id.img);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toogle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.apertura,R.string.cierre);
        toogle.syncState();
        NavigationView navigationView=(NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.op1Nav:
                Intent SA = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(SA);

            case R.id.op2Nav:
                IMG.setBackgroundResource(R.drawable.animacion1);
                ANIMACION=(AnimationDrawable)IMG.getBackground();
                ANIMACION.setOneShot(false);
                ANIMACION.start();
                T1.setText("Aplicación en construcción");
                break;
            case R.id.op3Nav:
                Intent S = new Intent(MainActivity4.this, MainActivity6.class);
                startActivity(S);

        }
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}