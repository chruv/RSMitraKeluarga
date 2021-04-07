package com.example.rsmitraanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chatroom_deasy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_deasy);
    }

    public void back1(View view) {
        Intent intent12 = new Intent(Chatroom_deasy.this, utama.class);
        startActivity(intent12);
        finish();
    }
}
