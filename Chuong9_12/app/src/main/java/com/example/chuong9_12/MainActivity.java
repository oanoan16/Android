package com.example.chuong9_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.chuong9_12.database.Database;
import com.example.chuong9_12.model.Category;
import com.example.chuong9_12.model.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.sp);
        txt = findViewById(R.id.txt);
        Database db = new Database(this);
        db.insertCate(new Category("Su that"));
        db.insertCate(new Category("Giao duc"));
        db.insertCate(new Category("KHCN"));
        List<Category> list db.getCates();
        String[] st = new String[list.size()];
        int k = 0;
        for (Category i:list){
            st[k++] = i.getId()+ "-" + i.getName();
        }
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.item, st);
        spinner.setAdapter(adapter);
        db.insertItem(new Item("Mat Biec", 1000, "12/04/2023",
                new Category(1, "")));

        db.insertItem(new Item("LTTBDD", 400, "12/05/2020",
                new Category(2, "")));

        db.insertItem(new Item("LTM", 200, "06/10/2023",
                new Category(1, "")));

        db.insertItem(new Item("PTIT ", 1000, "02/02/2021",
                new Category(3, "")));
        //List<Item> items = db.getItems();
        List<Item> items = db.searchItemByKey();
        String ss = "Cac dong sach:";
        for (Item i:items){
            ss +="\n" + i.getId() + "-" + i.getName()+ "-" + i.getCategory().getName();
        }
        txt.setText(ss);




    }
}