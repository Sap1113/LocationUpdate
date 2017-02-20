package com.locationupdateeverysecond.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class UpdateLocationReceiver extends BroadcastReceiver {

    public static boolean STARTED = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        UpdateLocationReceiver.STARTED = true;

        this.doProcess(context);
    }

    public void doProcess(Context context) {

        Intent intent;
        try {
            // new GetLocation().start(context);

            intent = new Intent(context, UpdateLocationService.class);
            context.startService(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
