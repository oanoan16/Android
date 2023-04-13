package com.example.chuong4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chuong4.adapter.AdapterCat;

import java.util.ArrayList;
import java.util.List;

public class Cat extends AppCompatActivity implements AdapterCat.ItemListenerCat{
    private RecyclerView recyclerView;
    private AdapterCat adapterCat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        recyclerView = findViewById(R.id.rview);
        adapterCat = new AdapterCat(getList());
        adapterCat.setItemListenerCat(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapterCat);
    }

    private List<com.example.chuong4.model.Cat> getList(){
        List<com.example.chuong4.model.Cat> list = new ArrayList<>();
        list.add(new com.example.chuong4.model.Cat(R.drawable.cho1, "Cho con 1"));
        list.add(new com.example.chuong4.model.Cat(R.drawable.cho2, "Cho con 2"));
        list.add(new com.example.chuong4.model.Cat(R.drawable.heo1, "Heo con 1"));
        list.add(new com.example.chuong4.model.Cat(R.drawable.heo2, "Heo con 2"));
        list.add(new com.example.chuong4.model.Cat(R.drawable.heo3, "Heo con 3"));
        list.add(new com.example.chuong4.model.Cat(R.drawable.heo4, "Heo con 4"));

        return list;
    }

    @Override
    public void onItemClick(View view, int postion) {
        com.example.chuong4.model.Cat c = getList().get(postion);
        Toast.makeText(this, c.getName(), Toast.LENGTH_SHORT).show();
    }
}