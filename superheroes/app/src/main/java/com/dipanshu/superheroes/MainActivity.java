    package com.dipanshu.superheroes;

    import android.annotation.SuppressLint;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ListView;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.util.ArrayList;
    import java.util.Arrays;

    public class MainActivity extends AppCompatActivity {

    //   String Superheroes[] = {"batman" , "superman" , "hulk" , "thor" , "shaktiman" , "kkrish" , "aquaman", "captain america"};
       ArrayList<String> Superheroes = new ArrayList<>(Arrays.asList("batman" , "superman" , "hulk" , "thor" ,
            "shaktiman" , "kkrish" , "aquaman", "captain america" , "antman" , "fireman" , "123" , "456"));

       @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ListView lvsuperheroes = findViewById(R.id.lvsuperheroes);
            final ArrayAdapter<String> superheroadapter = new ArrayAdapter<>(
                    this,
                    R.layout.list_item_superheroes,
                    R.id.tvname,
                    Superheroes
    //        here static as well as dynamic both type of arraylist can be passed
            );
        lvsuperheroes.setAdapter(superheroadapter);


        lvsuperheroes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = findViewById(R.id.tvname);
                Toast.makeText(MainActivity.this,tv.getText().toString()+"is awsm",Toast.LENGTH_SHORT);
            }
        });



            Button btnaddsuperhero = findViewById(R.id.addhero);
            btnaddsuperhero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newSuperhero = ((EditText) findViewById(R.id.etnewsuperhero)).getText().toString();
                    Superheroes.clear();
                    Superheroes.add(newSuperhero);
                    superheroadapter.notifyDataSetChanged();
                }
            });


        }
    }
