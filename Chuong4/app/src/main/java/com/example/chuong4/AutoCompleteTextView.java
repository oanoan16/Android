package com.example.chuong4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AutoCompleteTextView extends AppCompatActivity {
    private Button btSubmit;
    private String[] countries = {"Vietnam","England","Canada", "France","Australia"};
    private String[] languages={"Java ","CSharp","Visual Basic","Swift","C/C++"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
    }
}