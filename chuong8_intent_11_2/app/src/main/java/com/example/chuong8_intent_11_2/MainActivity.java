package com.example.chuong8_intent_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chuong8_intent_11_2.model.Account;

public class MainActivity extends AppCompatActivity {
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txtInfo);
        Intent intent=getIntent();
        if(intent.getSerializableExtra("account")!=null&&intent.getSerializableExtra("user")!=null){
            Account log=(Account)intent.getSerializableExtra("account");
            Account user=(Account)intent.getSerializableExtra("user");
            if(log.getUsername().equalsIgnoreCase(user.getUsername()) && log.getPassword().equalsIgnoreCase(user.getPassword())) {
                txt.setText("Login Successfully");
            }else{
                txt.setText("Account not exist");
            }
        }
    }
}