package com.dipanshu.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.tv);
        Button btn=findViewById(R.id.bv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mytask mytask=new Mytask();
                mytask.execute(5000000);
            }
        });
    }

    private class Mytask extends AsyncTask<Integer,Float,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Work is started !");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
            textView.setText(values[0].toString());
        }

        @Override
        protected String doInBackground(Integer... integers) {

            int input = integers[0];

            Log.e("TAG", "doInBackground: " );

            for (int i = 0; i < input; i++) {
                if (i % 100 == 0) {
                    publishProgress((float) i);
                }
            }
            return "Counting done!";


        }
    }
}
