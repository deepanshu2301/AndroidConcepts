package com.dipanshu.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SuperHeroAdapter extends BaseAdapter {

    private ArrayList<SuperHeroes> arrayList;
    private Context ctx;
    public SuperHeroAdapter(@NonNull ArrayList<SuperHeroes> arrayList, Context context) {
        this.arrayList = arrayList;
        this.ctx = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater li = LayoutInflater.from(ctx);

//        this method is also right
//        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());



        View inflatedview=li.inflate(R.layout.layout, viewGroup,false);

        SuperHeroes currenthero= (SuperHeroes) getItem(i);

        Superheroholder holder ;

        if(convertView==null){
            holder=new Superheroholder();
            holder.initialize(inflatedview);
        }
        else {

        }
        TextView name=inflatedview.findViewById(R.id.tvname);
        TextView universe =inflatedview.findViewById(R.id.tvuniverse);
        TextView power=inflatedview.findViewById(R.id.tvpowers);

        name.setText(currenthero.getName());
        universe.setText(currenthero.getUniverse());
        power.setText(currenthero.getPowers());

        Button btndelete = inflatedview.findViewById(R.id.bvdelete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(i);
                notifyDataSetChanged();
            }
        });
        return inflatedview;
    }

    class Superheroholder{
        TextView name,universe,power;

        public void initialize(View view) {

        }
    }

}
