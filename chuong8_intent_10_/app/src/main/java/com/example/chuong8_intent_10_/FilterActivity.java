package com.example.chuong8_intent_10_;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class FilterActivity extends AppCompatActivity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        txt = findViewById(R.id.txtFilter);
        Uri url = getIntent().getData();
        String s = "Scheme:" + url.getScheme() + "\nHost:"+url.getHost();
        int k = 1;
        for (String i:url.getPathSegments()){
            s+="\n para" + (k++)+ ": " + i;
        }
        s += "\n action" + getIntent().getAction();
        txt.setText(s);
    }
}