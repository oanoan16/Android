package com.example.chuong8_intent_10_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity11_6 extends AppCompatActivity {
    Intent t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main116);
        t = new Intent(this, MyService.class);
    }

    public  void start(View view){
        t.putExtra("r", 1);
        startService(t);
    }

    public  void stop(View view){
        startService(t);
    }

}