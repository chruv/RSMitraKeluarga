package com.example.rsmitraanak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btnRegis;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        registerUser();
    }

    private void registerUser() {
        btnRegis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //menampung email dan password user
                String emailUser = username.getText().toString().trim();
                String passwordUser = password.getText().toString().trim();

                //validasi email dan password
                if(emailUser.isEmpty()){
                    username.setError("Email tidak boleh kosong");
                }
                //jika email tidak valid
                else if (!Patterns.EMAIL_ADDRESS.matcher(emailUser).matches()){
                    username.setError("email tidak valid");
                }
                //jika password kosong
                else if(passwordUser.isEmpty()){
                    password.setError("password tidak boleh kosong");
                }
                //jika password kurang dari 6 karakter
                else if (passwordUser.length()<6){
                    password.setError("password tidak boleh kurang dari 6");
                }
                else {
                    //membuat user dengan firebase auth
                    auth.createUserWithEmailAndPassword(emailUser,passwordUser).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //jika gagal register
                                    if(!task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this,"Register gagal karena"+task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        //jika sukses akan menuju ke login activity
                                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                    }
                                }
                            });
                }
            }
        });
    }

    private void initView() {
            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            btnRegis = findViewById(R.id.btnRegis);
            auth = FirebaseAuth.getInstance();
    }

}
