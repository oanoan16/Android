package com.example.chuong8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private final static int REQUEST_CODE = 10000;
    private Button btnRegis, btnCancel;
    private EditText txtUsrname, txtPssword;
    private String usr, pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegis = findViewById(R.id.regis_btnRegis);
        btnCancel = findViewById(R.id.regis_btnCancel);
        txtUsrname = findViewById(R.id.regis_username);
        txtPssword = findViewById(R.id.regis_password);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(RegisterActivity.this, MainActivity2.class);
                t.putExtra("usr", txtUsrname.getText().toString());
                t.putExtra("pas", txtPssword.getText().toString());
                setResult(RESULT_OK, t);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });
    }
}