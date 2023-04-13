package com.example.chuong4_catfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuong4_catfinal.model.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CatAdapter.CatItemListener, SearchView.OnQueryTextListener{
    private Spinner sp;
    private RecyclerView recyclerView;
    private CatAdapter adapter;
    private EditText eName,ePrice,eDescription;
    private Button btAdd,btUpdate;
    private int pcurr;
    private SearchView searchView;
    private     int[] imgs={R.drawable.meo,R.drawable.cho,R.drawable.chuot};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initView();
        adapter=new CatAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        searchView.setOnQueryTextListener(this);




        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                String i=sp.getSelectedItem().toString();
                String nameA=eName.getText().toString();
                String priceA=ePrice.getText().toString();
                String description=eDescription.getText().toString();
                int img=R.drawable.meo;
                double price = 0;

                try {
                    img =imgs[Integer.parseInt(i)];
                    price=Double.parseDouble(priceA);

                    cat.setImg(img);
                    cat.setName(nameA);
                    cat.setPrice(price);
                    cat.setDescription(description);
                    adapter.add(cat);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Nhap",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                String i=sp.getSelectedItem().toString();
                String name=eName.getText().toString();
                String price=ePrice.getText().toString();
                String des=eDescription.getText().toString();
                int img=R.drawable.meo;
//                int price=0;
                try {
                    img =imgs[Integer.parseInt(i)];
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setPrice(Integer.parseInt(price));
                    cat.setDescription(des);
                    adapter.update(pcurr,cat);
                    btAdd.setEnabled(true);
                    btUpdate.setEnabled(false);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Please, Re-enter!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void initView(){
        sp=findViewById(R.id.img);
        SpinnerAdapter adapter=new SpinnerAdapter(this);
        sp.setAdapter(adapter);
        recyclerView=findViewById(R.id.recycleView);
        eName=findViewById(R.id.name);
        ePrice=findViewById(R.id.price);
        eDescription=findViewById(R.id.describe);
        btAdd=findViewById(R.id.btAdd);
        btUpdate=findViewById(R.id.btUpdate);
        btUpdate.setEnabled(false);
        searchView=findViewById(R.id.search);
    }

    @Override
    public void onItemClick(View view, int p) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);
        pcurr=p;
        Cat cat=adapter.getitem(p);
        int img= cat.getImg();
        int ps=0;
        for(int i=0;i<imgs.length;i++){
            if(img==imgs[i]){
                ps=i;
                break;
            }
        }
        eName.setText(cat.getName());
        ePrice.setText(cat.getPrice()+"");
        eDescription.setText(cat.getDescription());
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filter(s);
        return false;
    }

    private void filter(String s) {
        List<Cat> filterlist=new ArrayList<>();
        for(Cat i:adapter.getBackup()){
            if(i.getName().toLowerCase(Locale.ROOT).contains(s.toLowerCase())){
                filterlist.add(i);
            }
        }
        if(filterlist.isEmpty()){
            Toast.makeText(this,"Data not found",Toast.LENGTH_SHORT).show();
        }
        else {
            adapter.filterList((filterlist));
        }
    }
}