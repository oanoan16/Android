package com.example.chuong4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chuong4.model.Technology;
import com.example.chuong4.model.TechnologyAdapter;

public class ListView05 extends AppCompatActivity {
    private ListView lvTech;
    TechnologyAdapter adapter;
    private Technology[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view05);

        lvTech = findViewById(R.id.listView);
        initData();
        adapter = new TechnologyAdapter(this, list);
        lvTech.setAdapter(adapter);

        lvTech.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i< lvTech.getAdapter().getCount(); i++){
                    lvTech.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                lvTech.getChildAt(position).setBackgroundColor(Color.BLUE);
                Technology t = adapter.getItem(position);
                Toast.makeText(ListView05.this, t.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        Integer[] imgs = {R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4};
        String[] names = {"Android", "Ios", "Windows", "Pop!"};
        String[] subs = {"Sub Android", "Sub Ios", "Sub Windows", "Sub Pop"};
        String[] describes = {"Text Android", "Text Ios", "Text Windows", "Text Pop"};
        list = new Technology[imgs.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Technology(imgs[i], names[i], subs[i], describes[i]);
        }
    }
}