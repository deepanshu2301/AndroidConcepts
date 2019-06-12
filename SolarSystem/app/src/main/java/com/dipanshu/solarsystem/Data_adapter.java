package com.dipanshu.solarsystem;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Data_adapter extends RecyclerView.Adapter<Data_adapter.dataholder> {

    private ArrayList<data> arrayList;
    Context ctx;

    public Data_adapter(ArrayList<data> arrayList) {
        this.arrayList = arrayList;
    }



//    used until recyclable layout is not present
    @NonNull
    @Override
    public dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ctx=parent.getContext();
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View inflatedview=li.inflate(R.layout.layout,parent,false);
        return new dataholder(inflatedview);
    }


//    called everytime
//    use when some work is to be done each and everytime
    @Override
    public void onBindViewHolder(@NonNull final dataholder holder, int position) {

        data data1 =arrayList.get(position);
        holder.title.setText(data1.getName());
        holder.intro.setText(data1.getIntro());
        Picasso.get()
                .load(data1.getUrl())
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class dataholder extends RecyclerView.ViewHolder {

         TextView title,intro;
         ImageView image;

         public dataholder(@NonNull final View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tvname);
            intro=itemView.findViewById(R.id.tvdesc);
            image=itemView.findViewById(R.id.wbview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data currentdata=arrayList.get(getAdapterPosition());
                    Intent i = new Intent(ctx,otheractivity.class);
                    i.putExtra("TITLE",currentdata.getName());
                    i.putExtra("description",currentdata.getIntro());
                    i.putExtra("image",currentdata.getUrl());
                    ctx.startActivity(i);
                }
            });
        }


    }

}
