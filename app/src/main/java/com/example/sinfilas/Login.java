package com.example.sinfilas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText etusuario, etclave;
    private FirebaseAuth autenticacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etusuario = findViewById(R.id.etusuario);
        etclave = findViewById(R.id.etclave);
        autenticacion = FirebaseAuth.getInstance();
    }


    // Ingresa y valida los datos de los usuarios registrados
    public void login(View view){
        try {
            if (TextUtils.isEmpty(etusuario.getText().toString()))
                throw new Exception("El campo Usuario no puede estar vacio");
            if (TextUtils.isEmpty(etclave.getText().toString()))
                throw new Exception("El campo Contraseña no puede estar vacio");
            String usuario = etusuario.getText().toString();
            String contraseña = etclave.getText().toString();

            autenticacion.signInWithEmailAndPassword(usuario, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast mensaje = Toast.makeText(Login.this, "Ingreso exitoso", Toast.LENGTH_LONG);
                        mensaje.show();
                        Intent i = new Intent(Login.this, miscitas.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Login.this, "Ingreso fallido, si aún no se ha registrado por favor hagalo antes de ingresar", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } catch (Exception e) {
            Toast mensaje = Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_LONG);
            mensaje.show();
        }
    }



    // Ingresa a la activity de inicio
    public void inicio (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


    // Ingresa a la activity recuperar clave
    public void recuperarclave (View view){
        Intent i = new Intent(this, recuperarClave.class);
        startActivity(i);
    }


    // Ingresa a la activity regitro
    public void nuevoregistro (View view){
        Intent i = new Intent(this, registro.class);
        startActivity(i);

    }
}