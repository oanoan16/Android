package com.example.chuong8_intent_11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chuong8_intent_11_2.model.Account;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvUser, tvPass;
    private Button btCancel, btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        InitView();
        btCancel.setOnClickListener(this);
        btRegister.setOnClickListener(this);
    }
    private void InitView() {
        tvUser=findViewById(R.id.txtUsername);
        tvPass=findViewById(R.id.txtPassword);
        btCancel=findViewById(R.id.btnCancel);
        btRegister=findViewById(R.id.btnRegister);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnRegister:
                Account account=new Account(tvUser.getText().toString(),tvPass.getText().toString());
                Intent intent=new Intent();
                intent.putExtra("data",account);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.btnCancel:
                setResult(RESULT_CANCELED,null);
                finish();
                break;
        }
    }
}