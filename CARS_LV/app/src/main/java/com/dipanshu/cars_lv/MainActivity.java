package com.dipanshu.cars_lv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Cars> cars = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cars.add(new Cars("Ferrari" , "matte black" , "3200cc"));
        cars.add(new Cars("Audi" , "matte black" , "3200cc"));
        cars.add(new Cars("Bmw" , "matte black" , "3200cc"));
        cars.add(new Cars("Porche" , "matte black" , "3200cc"));
        cars.add(new Cars("Skoda" , "matte black" , "3200cc"));
        cars.add(new Cars("F9" , "matte black" , "3200cc"));
        cars.add(new Cars("Astin martin" , "matte black" , "3200cc"));
        cars.add(new Cars("Jaguar" , "matte black" , "3200cc"));
        cars.add(new Cars("Mercedes" , "matte black" , "3200cc"));

        ListView lv = findViewById(R.id.lvcars);
        final Carsadapter carsadapter = new Carsadapter(cars,this);
        lv.setAdapter(carsadapter);

        Button btnadd = findViewById(R.id.bvadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Car Added !",Toast.LENGTH_SHORT).show();
                String addname=((EditText)findViewById(R.id.tviname)).getText().toString();
                String addcolor=((EditText)findViewById(R.id.tvicolour)).getText().toString();
                String addengine=((EditText)findViewById(R.id.tvicapacity)).getText().toString();
                cars.add(new Cars(addname,addcolor,addengine));
                carsadapter.notifyDataSetChanged();
            }
        });
    }
}
