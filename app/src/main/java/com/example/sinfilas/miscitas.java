package com.example.sinfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class miscitas extends AppCompatActivity {
    public EditText bienvenidausuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscitas);

    }

    public void asignarcita (View view){

        Intent i = new Intent(this, asignarcitas.class);
        //i.putExtra("Nombre",i);
        startActivity(i);

    }
}