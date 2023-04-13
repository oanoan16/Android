package com.example.chuong8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chuong8.model.Student;

public class OpenActivity extends AppCompatActivity {
    private Button bt;
    private TextView tv;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        bt = findViewById(R.id.openAct_btn_backMain);
        tv = findViewById(R.id.openAct_txt);
        img = findViewById(R.id.openAct_img);

        Intent t = getIntent();
        String name = t.getStringExtra("name");
        String st = "Hello " + name;
        int age = t.getIntExtra("age", 20);
        st += "\nage: " + age;
        String[] subs = t.getStringArrayExtra("subs");
        st += "\nSubs:";
        for (String s :
                subs) {
            st += "\n- " + s;
        }
        Student stu = (Student) t.getSerializableExtra("stu1");

        tv.setText(stu.getName());
        img.setImageResource(stu.getImage());

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}