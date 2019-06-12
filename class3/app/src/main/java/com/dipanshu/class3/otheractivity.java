package com.dipanshu.class3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class otheractivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otheractivity);
//        this is to pass some data from one activity to another using intent
//        if(getIntent() != null){
//            ((TextView) findViewById(R.id.textview)).setText(getIntent().getStringExtra("hello"));
//        }
    }
}
