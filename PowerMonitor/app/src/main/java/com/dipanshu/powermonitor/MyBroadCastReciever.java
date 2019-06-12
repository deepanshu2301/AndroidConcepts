package com.dipanshu.powermonitor;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyBroadCastReciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

//        int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);

        ImageView img=(ImageView) ((Activity) context).findViewById(R.id.normal);
        switch (intent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                img.setImageResource(R.drawable.charge);
                Toast.makeText(context,"Power Connected",Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context,"Power Disconnected",Toast.LENGTH_SHORT).show();
                img.setImageResource(R.drawable.discharge);
                break;
        }
    }
}
