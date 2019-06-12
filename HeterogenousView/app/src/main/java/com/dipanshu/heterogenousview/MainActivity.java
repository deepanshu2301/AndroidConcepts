package com.dipanshu.heterogenousview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Object> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    list.add(new Textclass("TITLE","SUBTITLE"));
    list.add(new Imageclaass("TITLE IAMGE","SUBTITLE IMAGE","url"));
        list.add(new Imageclaass("TITLE IAMGE","SUBTITLE IMAGE","url"));

        list.add(new Textclass("TITLE","SUBTITLE"));
        list.add(new Imageclaass("TITLE IAMGE","SUBTITLE IMAGE","url"));

        RecyclerView recyclerView = findViewById(R.id.rvview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        DataAdapter adapter = new DataAdapter(list);
        recyclerView.setAdapter(adapter);
    }

}
