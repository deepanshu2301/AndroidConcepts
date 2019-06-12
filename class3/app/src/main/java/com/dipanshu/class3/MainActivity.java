package com.dipanshu.class3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnother = findViewById(R.id.button);
        btnother.setOnClickListener(this);
        {
            //           @Override
//           public void onClick(View v){

//             Toast.makeText(MainActivity.this , "button is clicked" , Toast.LENGTH_SHORT).show();
//            Intent i = new Intent(MainActivity.this, otheractivity.class);
//               i.putExtra("hello" , "world");
//               startActivity(i);
//           }

//        });
//        Button btnother1 = findViewById(R.id.button1);
//        btnother1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                new AlertDialog.Builder(MainActivity.this)
//
//                        .setTitle("SOME ALERT")
//                        .setMessage("this is to tell something")
//                        .setCancelable(false)
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Toast.makeText(MainActivity.this , "ok clicked" , Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Toast.makeText(MainActivity.this , "cancel clicked" , Toast.LENGTH_SHORT).show();
//                            }
//                        })
//
//
//                        .show();
//
//            }
//        });

        }
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent();
        i.setAction(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel://8587896036"));

//        this needs calling permission so it will crash
//        i.setAction(Intent.ACTION_CALL);
//        i.setData(Uri.parse("tel://100"));
        startActivity(i);
    }
}
