package com.example.sinfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class miperfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miperfil);
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
            //Toast.makeText(this, "selecccion menu mi perfil "+ id, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, miperfil.class);
            startActivity(i);
        } else {
            if (id== R.id.menu_nuevacita){
                Intent i = new Intent(this, asignarcitas.class);
                startActivity(i);

            }else if (id==R.id.menu_miscitas){
                    Intent i = new Intent(this, miscitas.class);
                    startActivity(i);
            }else{
                if (id==R.id.menu_cerrarsesion){
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
    // Ingresa a la activity mis citas
    public void recordarclave2 (View view){
        Intent i = new Intent(this, recordarClave.class);
        startActivity(i);
    }
    public void actualizardatos(View view){
        Toast.makeText(this, "Datos Actualizados",Toast.LENGTH_LONG).show();
    }
}