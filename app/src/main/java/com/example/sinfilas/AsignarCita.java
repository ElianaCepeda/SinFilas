package com.example.sinfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AsignarCita extends AppCompatActivity {

    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_cita);

        sp1=findViewById(R.id.spinner_horarios);

        String [] bancos = {"08:00 AM", "09:00 AM","10:00 AM","11:00 AM","02:00 PM", "03:00 PM","4:00 pM"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,bancos);
        sp1.setAdapter(adapter);
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