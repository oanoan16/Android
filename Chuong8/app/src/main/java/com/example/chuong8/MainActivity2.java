package com.example.chuong8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.home_txt);
        Intent intent = getIntent();
        String usr = intent.getStringExtra("u");
        String pas = intent.getStringExtra("p");
        if (usr != null && pas != null &&
                usr.equals(intent.getStringExtra("user")) &&
                pas.equals(intent.getStringExtra("pass"))) {
            textView.setText("Login successful");
        } else {
            textView.setText("Login fail");
        }
    }
}