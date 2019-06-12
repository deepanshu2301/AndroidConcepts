package com.dipanshu.pokidex;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class pokiadap extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<result> resultArrayList=new ArrayList<>();
    Context ctx;
    View view1;
    public pokiadap(ArrayList<result> pokidetails, MainActivity mainActivity) {
    this.resultArrayList=pokidetails;
    this.ctx=mainActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View view=li.inflate(R.layout.names,parent,false);
        view1=view;
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        result res=resultArrayList.get(position);
        Holder holder1= (Holder) holder;
        holder1.name.setText(res.getName());
    }

    @Override
    public int getItemCount() {
        return resultArrayList.size();
    }

    private class Holder extends RecyclerView.ViewHolder {
        TextView name;
                public Holder(View view) {
            super(view);
        name =view.findViewById(R.id.names);

        }


    }
}
