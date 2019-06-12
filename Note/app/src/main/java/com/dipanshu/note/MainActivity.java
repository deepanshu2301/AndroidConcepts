package com.dipanshu.note;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String data="DATA";
    String titl="TITLE";
     EditText title;
    EditText text;
    String atitle;
    String atext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.ettitle);


        text = findViewById(R.id.ettext);



        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);

        data = sharedPreferences.getString("DATA","");
        titl = sharedPreferences.getString("TITLE","");


        text.setText(data);

        title.setText(titl);



        Button btn = findViewById(R.id.bvdone);
                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                atitle = title.getText().toString();
                atext = text.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("TITLE",atitle);
                editor.putString("DATA",atext);

                editor.apply();


            }
        });
    }
    @Override
    protected void onStop() {

        atitle = title.getText().toString();
        atext = text.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("TITLE",atitle);
        editor.putString("DATA",atext);

        editor.apply();
        super.onStop();
    }


}
