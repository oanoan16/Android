package com.example.ktra2_sqlite1.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktra2_sqlite1.*;
import com.example.ktra2_sqlite1.Adapter.ItemAdapter;
import com.example.ktra2_sqlite1.data.SQLiteHelper;
import com.example.ktra2_sqlite1.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThirdFragment extends Fragment {

    Button btSearch, btThongKe;
    EditText etSearch, etThongKe;
    Spinner spStatus;

    private final String[] statusList = {
            "Tat ca", "Chua hoan thanh", "Dang lam", "Da hoan thanh",
    };


    RecyclerView recyclerView;
    List<Item> itemList;
    List<Item> itemListSearch;
    List<Item> itemListTK;
    ItemAdapter adapter;

    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        btSearch = v.findViewById(R.id.btSearch);
        spStatus = v.findViewById(R.id.sptk_status);
//        btThongKe = v.findViewById(R.id.bt_thong_ke);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(),
                android.R.layout.simple_spinner_item,
                statusList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spStatus.setAdapter(adapter);
        etSearch = v.findViewById(R.id.et_search);
        etThongKe = v.findViewById(R.id.et_thongke);
        recyclerView = v.findViewById(R.id.rv_search);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
        initListener();
    }

    private void initView() {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(getContext());
        itemList = sqLiteHelper.getAll();
        itemListSearch = new ArrayList<>();
        itemListSearch.addAll(itemList);

        adapter = new ItemAdapter(getContext(), itemListSearch);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private void initListener() {
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListSearch.clear();
                String searchText = etSearch.getText().toString();
                for (Item item : itemList){
                    if(item.getName().toLowerCase().contains(searchText.toLowerCase())
                    ||item.getDetail().toLowerCase().contains(searchText.toLowerCase()))
                        itemListSearch.add(item);
                }
                adapter.notifyDataSetChanged();
            }
        });

//        btThongKe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Map m = new HashMap<String, Integer>();
//
//                for(Item item : itemList){
//                    if(m.get(item.getStatus()) == null){
//                        m.put(item.getStatus(), 0);
//                    }
//
//                    m.put(item.getStatus(), Integer.parseInt(String.valueOf(m.get(item.getStatus()))) + 1);
//                    Log.d("Thong ke", item.getStatus() + " " +m.get(item.getStatus()) + "");
//                }
//
//
//            }
//        });

        spStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View v, int position, long l) {
                String txtsatus = spStatus.getSelectedItem().toString();
                int count = 0;
                if (position == 0){
                    itemListSearch.clear();
                    for (Item item : itemList) {
                        itemListSearch.add(item);
                        count ++;
                    }
                }
                else {
                    itemListSearch.clear();
                    for (Item item : itemList) {
                        Log.d("Thong ke", item.getStatus() + "-" + txtsatus + "-" + Integer.toString(count));
                        if (item.getStatus().contains(txtsatus)) {
                            itemListSearch.add(item);
                            count++;
                        }
                    }
                }
                adapter.notifyDataSetChanged();
                etThongKe.setText(count + " ");
                String msg = "position :" + position + " value :" + spStatus.getSelectedItem().toString();
                Toast.makeText(getView().getContext(), msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getView().getContext(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });

    }
}