package com.example.sinfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void inicioSesion (View view){

            Intent i = new Intent(this, Login.class);
            //i.putExtra("Nombre",i);
            startActivity(i);

    }
    public void Registro (View view){

        Intent i = new Intent(this, Login.class);
        startActivity(i);

    }


}