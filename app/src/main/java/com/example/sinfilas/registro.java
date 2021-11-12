package com.example.sinfilas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registro extends AppCompatActivity {
    private EditText etnombre,etapellido,etcedula,ettelefono,etemail;
    private EditText etusuario,etclave, etclave2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etnombre = findViewById(R.id.etnombres);
        etapellido = findViewById(R.id.etapellidos);
        etcedula = findViewById(R.id.etcedula);
        ettelefono = findViewById(R.id.ettelefono);
        etemail = findViewById(R.id.etRegEmail);
        etusuario = findViewById(R.id.etRegUsuario);
        etclave = findViewById(R.id.etRegClave);
        etclave2 = findViewById(R.id.etRegClave2);

    }

    // Ingresa y valida los datos de los usuarios registrados
    public void registro (){

            Toast mensaje = Toast.makeText(this, "registro exitoso",Toast.LENGTH_LONG);
            mensaje.show();

    }

    public void validarclave(View view){
        String clave1 = etclave.getText().toString();
        String clave2 = etclave2.getText().toString();

        // validacion si las contraselas son iguales
        if (clave1.equals(clave2)){

            // realiza el llamada a el metodo registrar  datos
            registro();

            //envia a la activity mis citas
            Intent i = new Intent(this, miscitas.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Contraseña Incorrecta",Toast.LENGTH_LONG).show();
        }
    }

}