package com.example.recycleview_crud.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_crud.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private Context context;
    private List<Cat> mList;

    public CatAdapter(Context context) {
        this.context = context;
        mList=new ArrayList<>();
    }


    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new CatViewHolder(view);
    }

    public Cat getitem(int p){
        return mList.get(p);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat=mList.get(position);
        if(cat==null) return ;
        holder.img.setImageResource(cat.getImg());
        holder.tvName.setText(cat.getName());
        holder.tvPrice.setText(cat.getPrice()+"");
        holder.tvDescrible.setText(cat.getDescription());
        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("Notify");
                builder.setMessage("Delete "+ cat.getName()+" ?");
                builder.setIcon(R.drawable.meo);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            }
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvPrice,tvName,tvDescrible;
        private Button btRemove;
        public CatViewHolder(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.img);
            tvName=view.findViewById(R.id.txtName);
            tvPrice=view.findViewById(R.id.txtPrice);
            tvDescrible=view.findViewById(R.id.txtDescribe);
            btRemove=view.findViewById(R.id.btRemove);
        }
    }
}
