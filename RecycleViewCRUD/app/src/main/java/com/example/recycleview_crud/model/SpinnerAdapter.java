package com.example.recycleview_crud.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.recycleview_crud.R;

public class SpinnerAdapter extends BaseAdapter {
    private int[] imgs = {R.drawable.cho1, R.drawable.cho2,
            R.drawable.heo1, R.drawable.heo2,
            R.drawable.heo3, R.drawable.heo4};

    private Context context;

    public SpinnerAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_image, viewGroup, false);
        ImageView img = item.findViewById(R.id.img);
        img.setImageResource(imgs[i]);
        return item;
    }

}
