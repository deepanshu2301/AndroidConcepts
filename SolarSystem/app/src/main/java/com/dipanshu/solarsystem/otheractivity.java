package com.dipanshu.solarsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class otheractivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otheractivity);
//        this is to pass some data from one activity to another using intent
        if(getIntent() != null){
            ((TextView) findViewById(R.id.tvname1)).setText(getIntent().getStringExtra("TITLE"));
            ((TextView) findViewById(R.id.tvdesc1)).setText(getIntent().getStringExtra("description"));
//            ((ImageView) findViewById(image)).setImageURI(Uri.parse(getIntent().getStringExtra("image")));
//            Picasso.get()
//                    .load(getIntent().getStringExtra("image"))
//                    .into(image);
            ImageView imview=findViewById(R.id.image);
            Picasso.get()
                    .load(getIntent().getStringExtra("image"))
                    .into(imview);
        }


    }
}
