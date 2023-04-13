package com.example.chuong4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuong4.R;
import com.example.chuong4.model.Cat;

import java.util.List;

public class AdapterCat extends RecyclerView.Adapter<AdapterCat.ViewHolderCat>{
    // private Context context;
    private List<com.example.chuong4.model.Cat> mList;
    private ItemListenerCat itemListenerCat;

    public AdapterCat(List<Cat> mList) {
        this.mList = mList;
    }

    public void setItemListenerCat(ItemListenerCat itemListenerCat) {
        this.itemListenerCat = itemListenerCat;
    }

    //    public AdapterCat(Context context, List<Cat> mList) {
//        this.context = context;
//        this.mList = mList;
//    }

    @NonNull
    @Override
    public ViewHolderCat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat, parent, false);
        return new ViewHolderCat(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCat holder, int position) {
        Cat cat = mList.get(position);
        if (cat == null)
            return;
        holder.img.setImageResource(cat.getImg());
        holder.tv.setText(cat.getName());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context.getApplicationContext(), cat.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        if (mList != null)
            return mList.size();
        return 0;
    }

    public class ViewHolderCat extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tv;
        //private CardView cardView;
        public ViewHolderCat(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.img);
            tv = view.findViewById(R.id.tname);
            view.setOnClickListener(this);
        //    cardView = view.findViewById(R.id.cview);
        }

        @Override
        public void onClick(View view) {
            if (itemListenerCat != null){
                itemListenerCat.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface ItemListenerCat{
        public void onItemClick(View view, int postion);

    }
}
