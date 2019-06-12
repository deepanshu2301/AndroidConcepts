package com.dipanshu.pokidex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class intentgetter extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon);
//        this is to pass some data from one activity to another using intent
        if(getIntent() != null){
            ((TextView) findViewById(R.id.name)).setText(getIntent().getStringExtra("NAME"));
            ((TextView) findViewById(R.id.height)).setText(getIntent().getStringExtra("HEIGHT"));
            ((TextView) findViewById(R.id.weight)).setText(getIntent().getStringExtra("WEIGHT"));

        }



    }
}
