package com.dipanshu.news_api;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterHolder>{

    private ArrayList<Item>items;

    public Adapter(ArrayList<Item>items){
        this.items=items;
    };


    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlelayout,parent,false);
        return new AdapterHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
        Item currentitem = items.get(position);
        holder.userpublishedat.setText(currentitem.getPublishedAt());
        holder.userdescription.setText(currentitem.getDescription());
        holder.usertitle.setText(currentitem.getTitle());
        holder.usercontent.setText(currentitem.getContent());
        holder.userauthor.setText(currentitem.getAuthor());
        Picasso.get().load(currentitem.getUrltoImage()).into(holder.userimage);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class AdapterHolder extends RecyclerView.ViewHolder {
       ImageView userimage;
       TextView userauthor;
        TextView usertitle;
        TextView userdescription;
        TextView usercontent;
        TextView userpublishedat;



        public AdapterHolder(View view) {
            super(view);

            userimage=view.findViewById(R.id.imview);
            userauthor=view.findViewById(R.id.sauthor);
            usercontent=view.findViewById(R.id.scontent);
            usertitle=view.findViewById(R.id.stitle);
            userdescription=view.findViewById(R.id.description);
            userpublishedat=view.findViewById(R.id.spublished);
        }
    }
}
