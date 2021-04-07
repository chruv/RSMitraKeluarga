package com.example.rsmitraanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chatroom_Lydiawati extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_lydiawati);
    }

    public void back6(View view) {
        Intent intent15 = new Intent(Chatroom_Lydiawati.this, utama.class);
        startActivity(intent15);
        finish();
    }
}
