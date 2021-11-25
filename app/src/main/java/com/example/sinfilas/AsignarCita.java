package com.example.sinfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AsignarCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_cita);
    }

    public void CitaAsignada (){
        Toast mensaje = Toast.makeText(this, "su cita se agendó correctamente",Toast.LENGTH_LONG);
        mensaje.show();
    }

    public void miscitas (View view){
        CitaAsignada();
        Intent i = new Intent(this, miscitas.class);
        startActivity(i);
    }
}