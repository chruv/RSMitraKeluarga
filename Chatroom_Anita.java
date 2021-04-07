package com.example.rsmitraanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chatroom_Anita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_anita);
    }

    public void back3(View view) {
        Intent intent16 = new Intent(Chatroom_Anita.this, utama.class);
        startActivity(intent16);
        finish();
    }
}
