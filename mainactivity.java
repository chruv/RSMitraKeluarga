package com.example.rsmitraanak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    private Button btnLogin,btnRegis;
    private FirebaseAuth auth;
    private CheckBox cRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        login();
    }

    private void login() {
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menampung inputan dari user
                final String emailUser = username.getText().toString().trim();
                final String passwordUser = password.getText().toString().trim();

                //validasi email dan password
                //jika email kosong
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
                } else {
                    auth.signInWithEmailAndPassword(emailUser,passwordUser)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //ketika gagal maka akan
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this,"Gagal Login Karena " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                    } else {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("Email",emailUser);
                                        bundle.putString("pass", passwordUser);
                                        startActivity(new Intent(MainActivity.this,utama.class).putExtra("emailpass",bundle));
                                        finish();
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
        btnLogin = findViewById(R.id.btnLogin);
        btnRegis = findViewById(R.id.btnRegis);
        auth = FirebaseAuth.getInstance();
    }
}
