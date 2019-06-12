package com.dipanshu.pokidex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class specificadap extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Details details  = new Details();

private Context ctx2;
    public specificadap(Details details, MainActivity mainActivity) {
    this.details=details;
    ctx2=mainActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.pokemon,parent,false);
        
        return new Holder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder1 holder2 = (Holder1) holder;
        holder2.Name.setText(details.getName());
        holder2.Height.setText(details.getHeight());
        holder2.Weight.setText(details.getWeight());

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class Holder1 extends RecyclerView.ViewHolder {
        TextView Name,Weight,Height;
//        RecyclerView rv1;
        public Holder1(View view) {
            super(view);
            Name=view.findViewById(R.id.name);
            Weight=view.findViewById(R.id.weight);
            Height=view.findViewById(R.id.height);
//            rv1=view.findViewById(R.id.abilityview);
//            rv2=view.findViewById(R.id.movesview);
        }
    }
}
