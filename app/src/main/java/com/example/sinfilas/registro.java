package com.example.sinfilas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class registro extends AppCompatActivity {
    private EditText etnombre,etapellido,etcedula,ettelefono,etemail;
    private EditText etusuario,etclave, etclave2;
    private FirebaseAuth autenticacion;
    private String contrasena1, contrasena2;


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

        autenticacion = FirebaseAuth.getInstance();

        contrasena1 = etclave.getText().toString();
        contrasena2 = etclave2.getText().toString();

    }

    // Ingresa y valida los datos de los usuarios registrados
    public void registro ( View view){
        try {
            if (TextUtils.isEmpty(etnombre.getText().toString()))
                throw new Exception("El campo Nombre no puede estar vacio");
            if (TextUtils.isEmpty(etapellido.getText().toString()))
                throw new Exception("El campo Apellido no puede estar vacio");
            if (TextUtils.isEmpty(etcedula.getText().toString()))
                throw new Exception("El campo Cedula no puede estar vacio");
            if (TextUtils.isEmpty(ettelefono.getText().toString()))
                throw new Exception("El campo Telefono no puede estar vacio");
            if (TextUtils.isEmpty(etemail.getText().toString()))
                throw new Exception("El campo e-mail no puede estar vacio");
            if (TextUtils.isEmpty(etclave.getText().toString()))
                throw new Exception("El campo Contraseña no puede estar vacio");
            if (TextUtils.isEmpty(etclave2.getText().toString()))
                throw new Exception("El campo Repetir contraseña no puede estar vacio");
            if (!contrasena1.equals(contrasena2))
                throw new Exception("La contraseña no es igual en ambos campos");

            String correo = etemail.getText().toString();
            String contraseña = etclave.getText().toString();
            autenticacion.createUserWithEmailAndPassword(correo, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast mensaje = Toast.makeText(registro.this, "registro exitoso", Toast.LENGTH_LONG);
                        mensaje.show();
                        Intent i = new Intent(registro.this, miscitas.class);
                        startActivity(i);
                    } else {
                        try {
                            throw task.getException();
                          //contraseña debil
                        } catch (FirebaseAuthWeakPasswordException e) {
                            Toast mensaje = Toast.makeText(registro.this, "Contraseña debil", Toast.LENGTH_LONG);
                            mensaje.show();
                         //Email no valido
                        }catch (FirebaseAuthInvalidCredentialsException e) {
                                Toast mensaje = Toast.makeText(registro.this, "e-mail no valido", Toast.LENGTH_LONG);
                                mensaje.show();
                         // email registrado anteriormente
                        }catch (FirebaseAuthUserCollisionException e) {
                            Toast mensaje = Toast.makeText(registro.this, "el e-mail ya se ha registrado anteriormente, para entrar a SinFilas por favor dirijase a Login", Toast.LENGTH_LONG);
                            mensaje.show();
                        } catch (Exception e) {
                            Toast mensaje = Toast.makeText(registro.this, e.getClass().getName(), Toast.LENGTH_LONG);
                            mensaje.show();
                        }
                    }
                }
            });

        }catch (Exception e) {
            Toast mensaje = Toast.makeText(registro.this, e.getMessage() , Toast.LENGTH_LONG);
            mensaje.show();
        }
    }



}