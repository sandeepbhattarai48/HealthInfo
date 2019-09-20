package com.example.healthinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.healthinfo.DismissAlarmActivity;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    public static final String ONE_TIME = "onetime";

    @Override
    public void onReceive(Context context, Intent intent) {
//        Intent dismissAlarmIntent = new Intent(context, DismissAlarmActivity.class);
//        context.startActivity(dismissAlarmIntent);
        Intent i = new Intent(context, DismissAlarmActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

}