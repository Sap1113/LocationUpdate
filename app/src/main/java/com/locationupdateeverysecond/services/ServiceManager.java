package com.locationupdateeverysecond.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


public class ServiceManager {

    private AlarmManager amPMR = null;
    private PendingIntent piPMR = null;
    private AppLocationService appLocationService;
    public void start(Context context) {


        appLocationService = new AppLocationService(context);
        appLocationService.getLocation();

        if (!UpdateLocationReceiver.STARTED) {
            // Wake up Service
            amPMR = (AlarmManager) context
                    .getSystemService(Context.ALARM_SERVICE);
            Intent intentPMR = new Intent(context,
                    UpdateLocationReceiver.class);
            piPMR = PendingIntent.getBroadcast(context, 0, intentPMR, 0);
            amPMR.setRepeating(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis(), 60000, piPMR); // 3 second
        }

    }

    public void stopService() {

        amPMR = null;
        amPMR.cancel(piPMR);
        piPMR.cancel();

    }
}
