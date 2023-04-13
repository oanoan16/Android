package com.example.chuong8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chuong8.model.Student;

public class MainActivity extends AppCompatActivity {
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.main_btn_openAct);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(MainActivity.this, OpenActivity.class);
                t.putExtra("name", "Code rat bug");
                int age = 22;
                t.putExtra("age", age);
                String[] subs = {"Chan", "Vax", "Onf"};
                t.putExtra("subs", subs);
                Student stu = new Student(R.drawable.asset02, "Con ...");
                t.putExtra("stu1", stu);
                startActivity(t);
            }
        });
    }
}