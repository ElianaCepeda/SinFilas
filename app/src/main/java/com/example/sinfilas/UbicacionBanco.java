package com.example.sinfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class UbicacionBanco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion_banco);
    }

    // Ir al activiy asignar cita
    public void asignarcita (View view){
        Intent i = new Intent(this, AsignarCita.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }
    public boolean  onOptionsItemSelected(MenuItem item){
        int id =item.getItemId();

        if (id== R.id.menu_perfil){
            Intent i = new Intent(this, miperfil.class);
            startActivity(i);

        }else if (id== R.id.menu_nuevacita){
            Intent i = new Intent(this, UbicacionBanco.class);
            startActivity(i);

        }else if (id==R.id.menu_miscitas) {
            Intent i = new Intent(this, miscitas.class);
            startActivity(i);

        }else{
            if (id==R.id.menu_cerrarsesion){
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                }
        }
        return super.onOptionsItemSelected(item);
    }
}