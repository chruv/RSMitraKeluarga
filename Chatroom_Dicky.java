package com.example.rsmitraanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chatroom_Dicky extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_dicky);
    }

    public void back4(View view) {
        Intent intent13 = new Intent(Chatroom_Dicky.this, utama.class);
        startActivity(intent13);
        finish();
    }
}
