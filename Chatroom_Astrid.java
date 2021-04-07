package com.example.rsmitraanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chatroom_Astrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_astrid);
    }

    public void back5(View view) {
        Intent intent11 = new Intent(Chatroom_Astrid.this, utama.class);
        startActivity(intent11);
        finish();
    }
}
