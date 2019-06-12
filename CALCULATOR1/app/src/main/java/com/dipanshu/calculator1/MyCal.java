package com.dipanshu.calculator1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MyCal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cal);
    }

    public void dot(View view) {

        TextView textView = findViewById(R.id.input1);
        textView.setText("" +".");
    }



    public void del(View view) {
        TextView textView = findViewById(R.id.action);
        textView.setText("" +"(.)");
        TextView textView1 = findViewById(R.id.input1);
        textView1.setText("INPUT1");
        TextView textView2 = findViewById(R.id.input2);
        textView2.setText("INPUT2");
        TextView textView3 = findViewById(R.id.solution);
        textView3.setText("0.00");
    }

    int a=0;
    public void take1(View view) {
        a=1;
    }
    public void take2(View view) {
        a=2;
    }
    public void zero(View view) {
        if(a==1){
            TextView textView = findViewById(R.id.input1);
            textView.setText(textView.getText() +"0");
        }
        else if(a==2){
            TextView textView = findViewById(R.id.input2);
            textView.setText("" +0);
        }
    }
    public void one(View view) {
        if(a==1){
            TextView textView = findViewById(R.id.input1);
            textView.setText(textView.getText() +"1");


        }
        else if(a==2){
            TextView textView = findViewById(R.id.input2);
            textView.setText("" +1);
        }

    }

    public void two(View view) {
        if(a==1){
            TextView textView = findViewById(R.id.input1);
            textView.setText("" +2);
        }
        else if(a==2){
            TextView textView = findViewById(R.id.input2);
            textView.setText("" +2);
        }
    }

    public void three(View view) {
        if(a==1){
            TextView textView = findViewById(R.id.input1);
            textView.setText("" +3);
        }
        else if(a==2){
            TextView textView = findViewById(R.id.input2);
            textView.setText("" +3);
        }
    }

    public void four(View view) {
        if(a==1){
            TextView textView = findViewById(R.id.input1);
            textView.setText("" +4);
        }
        else if(a==2){
            TextView textView = findViewById(R.id.input2);
            textView.setText("" +4);
        }
    }

    public void five(View view) {
        if(a==1){
            TextView textView = findViewById(R.id.input1);
            textView.setText("" +5);
        }
        else if(a==2){
            TextView textView = findViewById(R.id.input2);
            textView.setText("" +5);
        }
    }

    public void six(View view) {
        if(a==1){
            TextView textView = findViewById(R.id.input1);
            textView.setText("" +6);
        }
        else if(a==2){
            TextView textView = findViewById(R.id.input2);
            textView.setText("" +6);
        }
    }

    public void seven(View view) {
        if(a==1){
            TextView textView = findViewById(R.id.input1);
            textView.setText("" +7);
        }
        else if(a==2){
            TextView textView = findViewById(R.id.input2);
            textView.setText("" +7);
        }
    }

    public void eight(View view) {
        if(a==1){
            TextView textView = findViewById(R.id.input1);
            textView.setText("" +8);
        }
        else if(a==2){
            TextView textView = findViewById(R.id.input2);
            textView.setText("" +8);
        }
    }

    public void nine(View view) {
        if(a==1){
            TextView textView = findViewById(R.id.input1);
            textView.setText("" +9);
        }
        else if(a==2){
            TextView textView = findViewById(R.id.input2);
            textView.setText("" +9);
        }
    }

    public void equal(View view) {
        TextView textView = findViewById(R.id.input1);
        String a = textView.getText().toString();
        float number1 = Integer.parseInt(a);

        TextView textView1 = findViewById(R.id.input2);
        String b = textView1.getText().toString();
        Log.e("MyCal","change");
        float number2;
        if(b.contentEquals("NULL")){
            number2=0;
        }else
        {
            number2 = Integer.parseInt(b);
        }


        TextView textView2 = findViewById(R.id.action);
        String c = textView2.getText().toString();

        float ans=0;
        if(c.substring(0,1)=="+") {
            float num3=number1+number2;
            ans=num3;
        }
        else if(c.substring(0,1)=="-") {
            float num3=number1-number2;
            ans=num3;
        }
        else if(c.substring(0,1)=="*") {
            float num3=number1*number2;
            ans=num3;
        }
        else if(c.substring(0,1)=="/") {
            float num3=(number1/number2);
            ans=num3;
        }
        else if(c.substring(0,1)=="%") {
            float num3=(number1%number2);
            ans=num3;
        }
        else if(c.substring(0,1)=="!") {
            Log.e("MyCal" , "change was detected");
            float num3=factorial(number1);
            ans=num3;
        }
        else if(c.substring(0,1)=="^") {
            float num3=(float)Math.pow(number1,number2);
            ans=num3;
        }
        else if(c.contentEquals("sqrt")) {
            float num3=(float)Math.sqrt(number1);
            ans=num3;
        }

        TextView textView3 = findViewById(R.id.solution);
        textView3.setText(""+ans);
    }

    private float factorial(float a) {
        float b=a;
        for(float i=a-1;i>0;i=i-1){
            b=b*i;
        }
        return b;
    }

    public void plus(View view) {
        TextView textView = findViewById(R.id.action);
        textView.setText("" +"+");
    }

    public void minus(View view) {
        TextView textView = findViewById(R.id.action);
        textView.setText("" +"-");
    }

    public void multiply(View view) {
        TextView textView = findViewById(R.id.action);
        textView.setText("" +"*");
    }

    public void divide(View view) {
        TextView textView = findViewById(R.id.action);
        textView.setText("" +"/");
    }


    public void mod(View view) {
        TextView textView = findViewById(R.id.action);
        textView.setText("" +"%");
    }

    public void fact(View view) {
        TextView textView = findViewById(R.id.action);
        textView.setText("" +"!");
    }

    public void power(View view) {
        TextView textView = findViewById(R.id.action);
        textView.setText("" +"^");
    }

    public void sqrt(View view) {
        TextView textView = findViewById(R.id.action);
        textView.setText("" +"sqrt");
    }
}
