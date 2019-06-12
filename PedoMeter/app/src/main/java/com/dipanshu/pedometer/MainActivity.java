package com.dipanshu.pedometer;

import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements SensorEventListener{


    SensorManager sm;
    long timedisp1,timedisp2;
    Button start,end,go;
    TextView stepview,distance,calories,time,stepsleft,vprogress;
    int steps=10000;
    String dis;
    String target="10000";
    int count=0;
    EditText targetts;
    private int flag=0;
    int flag1=0;

    //    Button start=findViewById(R.id.start);
//    Button end=findViewById(R.id.stop);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        sm= (SensorManager) getSystemService(SENSOR_SERVICE);

        stepview = findViewById(R.id.pstep);
        steps=0;
        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);

        count = sharedPreferences.getInt("COUNT", 0);

        if(count>0 && count<10000){
            stepview.setText("" + count);
        }
        start=findViewById(R.id.start);
        end=findViewById(R.id.stop);
        distance=findViewById(R.id.distance);
        calories=findViewById(R.id.calories);
        time=findViewById(R.id.time);
        stepsleft=findViewById(R.id.stepleft);
        vprogress=findViewById(R.id.percent);
        go=findViewById(R.id.go);
        targetts=findViewById(R.id.targett);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                target= targetts.getText().toString();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timedisp1=(System.currentTimeMillis());
                flag=1;
                flag1=1;
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timedisp2=(System.currentTimeMillis());

                long millis=(timedisp2)-timedisp1;
                int tt= (int) (millis/60000);
                flag=0;
                if(flag1==1)
                time.setText(""+tt +" Min");
                else
                    time.setText(""+"0" +" Min");

            }
        });
        Button resetb=findViewById(R.id.resetbut);
        resetb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                steps=0;
                count=0;
                dis="0.000000000";
                stepview.setText("" + 0);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Sensor pedosense=sm.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        sm.registerListener(this,pedosense,SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] vals=event.values;
        Log.e("Steps",":"+vals[0]);
        if(vals[0]!=0){
            steps++;
        }
        Log.e("AFTER",":"+steps);
//        stepview.setText(""+steps);

        dis = String.valueOf((Integer.parseInt(stepview.getText().toString())*0.768)/1000);
//        distance.setText(dis.substring(0,5) + " Km");
//        calories.setText(""+steps/20 + " Cal");
        int remain=Integer.parseInt(target)-Integer.parseInt(stepview.getText().toString())-1;
//        stepsleft.setText(""+remain);
        int progress=100-((remain*100)/Integer.parseInt(target));
        String ans=String.valueOf(progress);
//        vprogress.setText(ans);


        if(flag==1){
            int answer=count + steps;
            stepview.setText(""+answer);
            distance.setText(dis + " Km");
            calories.setText(""+steps/20 + " Cal");
            stepsleft.setText(""+remain);
            vprogress.setText(ans);
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        sm.unregisterListener(this);
        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("COUNT", Integer.parseInt(stepview.getText().toString()));

        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("COUNT", Integer.parseInt(stepview.getText().toString()));

        editor.apply();
    }
}
