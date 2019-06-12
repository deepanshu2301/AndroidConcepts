package com.dipanshu.menusprac;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomnavigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.storage:
//                        Toast.makeText(getBaseContext(),"storage",Toast.LENGTH_SHORT).show();
//                    case  R.id.storage2:
//                        Toast.makeText(getBaseContext(),"storage2",Toast.LENGTH_SHORT).show();
//                }
//
//                return true;
//            }
//        });


    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return true;
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.storage:
//                Toast.makeText(getBaseContext(),"Temporary",Toast.LENGTH_SHORT).show();
//            case R.id.storage2:
//                Toast.makeText(getBaseContext(),"Temporarystore",Toast.LENGTH_SHORT).show();
//        }
//        return false;
//    }
}
