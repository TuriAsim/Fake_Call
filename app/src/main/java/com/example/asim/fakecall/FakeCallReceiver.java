package com.example.asim.fakecall;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Asim on 4/17/2016.
 */
public class FakeCallReceiver extends BroadcastReceiver {
    NotificationManager nm;

    @Override
    public void onReceive(Context context, Intent intent) {



        Intent intentObject = new Intent(context.getApplicationContext(), FakeRingingActivity.class);
        intentObject.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intentObject.putExtra("myfakename", "aso");
        intentObject.putExtra("myfakenumber", "abbas");
        context.startActivity(intentObject);

    }
}
