package com.dipanshu.heterogenousview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Object> adapterlist;

    DataAdapter(ArrayList<Object> adapterlist) {
        this.adapterlist = adapterlist;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        View view=li.inflate(R.layout.itemrow_image,parent,false);

        return new dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class dataholder extends RecyclerView.ViewHolder {
        TextView title;
        TextView subtitle;

        public dataholder (View view) {
            super(view);
            title=view.findViewById(R.id.tvTitle);
            subtitle=view.findViewById(R.id.tvSubtitle);
        }
    }
}
