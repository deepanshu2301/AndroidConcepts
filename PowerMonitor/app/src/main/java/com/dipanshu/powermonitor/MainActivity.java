package com.dipanshu.powermonitor;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.provider.Settings;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyBroadCastReciever mbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbr=new MyBroadCastReciever();


        TextView tv = findViewById(R.id.per);

        BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        tv.setText(batLevel + "%");

        final IntentFilter inf = new IntentFilter();
        inf.addAction(Intent.ACTION_POWER_CONNECTED);
        inf.addAction(Intent.ACTION_POWER_DISCONNECTED);


        Button btn = findViewById(R.id.status);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_POWER_USAGE_SUMMARY);
                startActivityForResult(intent,0);
            }
        });
//        LocalBroadcastManager.getInstance(this).registerReceiver(mbr,inf);
            registerReceiver(mbr,inf);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mbr);
//        unregisterReceiver(mbr);
    }
}
