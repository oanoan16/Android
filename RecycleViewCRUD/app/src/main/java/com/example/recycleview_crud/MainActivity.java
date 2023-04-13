package com.example.recycleview_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.recycleview_crud.model.SpinnerAdapter;


public class MainActivity extends AppCompatActivity {
    private Spinner sp;
    private int[] imgs = {R.drawable.cho1, R.drawable.cho2,
            R.drawable.heo1, R.drawable.heo2,
            R.drawable.heo3, R.drawable.heo4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intView();
    }

    private void intView() {
        sp = findViewById(R.id.simg);
        SpinnerAdapter adapter = new SpinnerAdapter(this);
        sp.setAdapter(adapter);
    }
}