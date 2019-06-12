package com.dipanshu.cars_lv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Carsadapter extends BaseAdapter {

    private ArrayList<Cars> cars;
    private Context ctx;
    public Carsadapter(ArrayList<Cars> cars1, Context context) {
    this.cars=cars1;
    this.ctx=context;
    }


    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int i) {
        return cars.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater li =  LayoutInflater.from(ctx);
        View iview = li.inflate(R.layout.layout , viewGroup , false);

        Cars currentcar = cars.get(i);
        TextView name=iview.findViewById(R.id.tvname);
        TextView color=iview.findViewById(R.id.tvcolour);
        TextView engine=iview.findViewById(R.id.tvcapacity);

        name.setText(currentcar.getName());
        color.setText(currentcar.getColour());
        engine.setText(currentcar.getCapacity());
        return  iview;
    }
}
