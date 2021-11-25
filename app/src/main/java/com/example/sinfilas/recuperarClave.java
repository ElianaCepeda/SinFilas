package com.example.sinfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class recuperarClave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_clave);
    }


    public void solicitarcodigo(View view){
        Toast.makeText(this, "Codigo Enviado a su Correo",Toast.LENGTH_LONG).show();
    }
}