package org.meicode.appfilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.meicode.appfilm.MovieDetails;
import org.meicode.appfilm.R;
import org.meicode.appfilm.model.CategoryItem;

import java.util.ArrayList;

public class ItemRcViewAdapter extends RecyclerView.Adapter<ItemRcViewAdapter.ItemViewHolder> {
    Context cont;
    ArrayList<CategoryItem> ItemList;

    public ItemRcViewAdapter(Context cont, ArrayList<CategoryItem> itemList) {
        this.cont = cont;
        ItemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(cont).inflate(R.layout.cat_rcview_item_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Glide.with(cont).load(ItemList.get(position).getImgUrl()).into(holder.itemImg);
        holder.itemImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(cont, MovieDetails.class);
                i.putExtra("movieId",ItemList.get(position).getId());
                i.putExtra("movieName",ItemList.get(position).getMovieName());
                i.putExtra("movieImageUrl",ItemList.get(position).getImgUrl());
                i.putExtra("movieFile",ItemList.get(position).getFileUrl());
                cont.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImg;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImg = (ImageView) itemView.findViewById(R.id.item_img);
        }
    }
}
