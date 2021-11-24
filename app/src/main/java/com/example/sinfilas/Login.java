package com.example.sinfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText etusuario, etclave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etusuario = findViewById(R.id.etusuario);
        etclave = findViewById(R.id.etclave);
    }
    // Ingresa y valida los datos de los usuarios registrados
    public void validar (View view){
        String usuario = etusuario.getText().toString();
        String clave = etclave.getText().toString();
        //  validacion de datos usuario y contraseña
        if ( usuario.equals("admin") && clave.equals("12345")){
            Intent i = new Intent(this, miscitas.class);
            i.putExtra("Nombre",usuario);
            startActivity(i);
        }else{
            Toast mensaje = Toast.makeText(this, "Por favor Verifique el usuario y contraseña",Toast.LENGTH_LONG);
            mensaje.show();

        }
    }

    // Ingresa a la activity de inicio
    public void inicio (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    // Ingresa a la activity mis citas
    public void recordarclave (View view){
        Intent i = new Intent(this, recordarClave.class);
        startActivity(i);
    }

    // Ingresa a la activity regitro
    public void nuevoregistro (View view){

        Intent i = new Intent(this, registro.class);
        startActivity(i);

    }
}