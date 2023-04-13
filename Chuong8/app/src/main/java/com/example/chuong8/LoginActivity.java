package com.example.chuong8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chuong8.model.Student;

public class LoginActivity extends AppCompatActivity {
    private final static int REQUEST_CODE = 10000;
    private Button btnLogin, btnSignup;
    private EditText txtUsrname, txtPssword;
    private String usr, pas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.login_btnSignin);
        btnSignup = findViewById(R.id.login_btnSignup);
        txtUsrname = findViewById(R.id.login_username);
        txtPssword = findViewById(R.id.login_password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(LoginActivity.this, MainActivity2.class);
                t.putExtra("user", txtUsrname.getText().toString());
                t.putExtra("pass", txtPssword.getText().toString());
                t.putExtra("u", usr);
                t.putExtra("p", pas);
                startActivity(t);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(LoginActivity.this, com.example.chuong8.RegisterActivity.class);
                startActivityForResult(t, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if (data == null) {
                    Toast.makeText(getApplicationContext(), "Huy dang ki", Toast.LENGTH_SHORT).show();
                } else {
                    usr = data.getStringExtra("usr");
                    pas = data.getStringExtra("pas");
                }
            }
        }
    }
}