package com.dipanshu.browserapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText btet = findViewById(R.id.etview);
        btet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("ALERT")
                        .setMessage("This app requires an active internet connection")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("OK",new  DialogInterface.OnClickListener(){
                   @Override

                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this , "ok clicked" , Toast.LENGTH_SHORT).show();
                            }
                })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "cancel clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

            }
        });

        Button btgo = findViewById(R.id.btview);
        final WebView wbview = findViewById(R.id.wvview);
        btgo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this , "Searching..." , Toast.LENGTH_SHORT).show();
                EditText text = findViewById(R.id.etview);
                String data = text.getText().toString();

                String start=data.substring(0,7);
                String data1=data;
                if(!start.contentEquals("http://")){
                     data1="http://" + data;
                }
                data=data1;

                wbview.loadUrl(data);


            }
        });
//        WebView wbview = findViewById(R.id.wvview);
//        wbview.getSettings().setJavaScriptEnabled(true);
        wbview.setWebViewClient(new webviewclient());

    }
    private class webviewclient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

