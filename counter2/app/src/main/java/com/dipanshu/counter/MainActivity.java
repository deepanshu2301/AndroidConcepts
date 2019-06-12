package com.dipanshu.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void ChangeText(View view) {
//
//        Log.e( "MainActivity" ,  "ChangeText was detected");
////        as a text view is already created we can directly use it
////        it was created at the time of declaration and is stored
//        TextView textView=findViewById(R.id.hello);
//        textView.setText("I am Deepanshu!");
//    }

    int c=0;
    public void decrement(View view) {
     TextView textView = findViewById(R.id.count);
     if(c<=0)
     {
         c=0;
         textView.setText("" +c);
     }else
     {
         c--;
         textView.setText("" + c);
     }

    }

    public void increment(View view) {
        TextView textView = findViewById(R.id.count);

        c++;
        textView.setText("" +c);
    }

    public void reset(View view) {
        TextView textView = findViewById(R.id.count);
        c=0;
        textView.setText(""+c);
    }



    public void ChangeText(View view) {
        TextView textView = findViewById(R.id.button);
        TextView textView1 = findViewById(R.id.email);
        textView.setText(textView1.getText());
    }
}
