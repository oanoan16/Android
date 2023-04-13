package com.example.chuong4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TechListView extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_list_view);

        String[] listTech = getResources().getStringArray(R.array.technology);
        ArrayAdapter<String> adapterTech = new ArrayAdapter<>(this, R.layout.item, listTech);
        lv = findViewById(R.id.listObjView);
        lv.setAdapter(adapterTech);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String o = adapterTech.getItem(position);
                Toast.makeText((TechListView.this), ("Tech '" + o + "' has selected!"), Toast.LENGTH_LONG).show();
            }
        });
    }
}