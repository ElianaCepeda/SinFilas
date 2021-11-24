package com.example.sinfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class recordarClave extends AppCompatActivity {

    TextView etantigua,etnueva,etrenueva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordar_clave);

        etantigua = findViewById(R.id.etclavevieja);
        etnueva = findViewById(R.id.etclavenueva);
        etrenueva = findViewById(R.id.etreclavenueva);

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

    // Ingresa y valida la contraseña usuarios registrados
    public void validar (View view){
        String claveantigua = etantigua.getText().toString();
        String clave = etnueva.getText().toString();
        String reclave = etrenueva.getText().toString();
        //  validacion de datos usuario y contraseña
        if ( claveantigua.equals("12345")){

            if ( clave == reclave){

                Toast.makeText(this, "Clave Actualizada",Toast.LENGTH_LONG).show();

            }else{

                Toast.makeText(this, "la Clave Nueva y la confirmacion NO son iguales" ,Toast.LENGTH_LONG).show();

            }
        }
        else{

            Toast.makeText(this, "Error en la contraseña Antigua" ,Toast.LENGTH_LONG).show();

        }
    }
}