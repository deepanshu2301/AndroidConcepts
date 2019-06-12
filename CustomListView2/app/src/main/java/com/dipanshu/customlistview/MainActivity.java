package com.dipanshu.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<SuperHeroes> superHeroes = new ArrayList<>();
        superHeroes.add(new SuperHeroes("batman" , "alpha", "flying abilities"));
        superHeroes.add(new SuperHeroes("superman" , "beeta", "super muscular body"));
        superHeroes.add(new SuperHeroes("aquaman" , "gamma", "flying abilities"));
        superHeroes.add(new SuperHeroes("sandman" , "one", "flying abilities"));
        superHeroes.add(new SuperHeroes("fireman" , "two", "flying abilities"));
        superHeroes.add(new SuperHeroes("Thor" , "three", "flying abilities"));
        superHeroes.add(new SuperHeroes("antman" , "four", "flying abilities"));
        superHeroes.add(new SuperHeroes("hulk" , "five", "flying abilities"));
        superHeroes.add(new SuperHeroes("wonder women" , "six", "flying abilities"));
        superHeroes.add(new SuperHeroes("spiderman" , "seven", "flying abilities"));
        superHeroes.add(new SuperHeroes("drstrange" , "eight", "flying abilities"));


        ListView lvsuperheroes= findViewById(R.id.lvsuperheroes);

        final SuperHeroAdapter superheroadapter=new SuperHeroAdapter(superHeroes,this);
        lvsuperheroes.setAdapter(superheroadapter);

        Button btnadd = findViewById(R.id.bvadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addname=((EditText)findViewById(R.id.tviname)).getText().toString();
                String adduniverse=((EditText)findViewById(R.id.tviuniverse)).getText().toString();
                String addpower=((EditText)findViewById(R.id.tvipower)).getText().toString();
                superHeroes.add(new SuperHeroes(addname,adduniverse,addpower));
                superheroadapter.notifyDataSetChanged();
            }
        });


    }
}
