package com.locationupdateeverysecond.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.locationupdateeverysecond.uc.Const;

import static com.locationupdateeverysecond.LocationActivity.txt_location;

public class UpdateLocationService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        // this.CurrentTime = Utils.millisToDate(System.currentTimeMillis(),
        // "hh:mm:ss");

        if (Const.LATITUDE != null && Const.LONGITUDE != null
                && !Const.LATITUDE.toString().equals("")) {

            Log.i(this.getClass() + " ",
                    " :: UpdateLocationService Start :: ");
            txt_location.setText("Latitude : " + Const.LATITUDE
                    + "\nLogitude : " + Const.LONGITUDE);

//            new UpdateLocationProcess(UpdateLocationService.this).execute();

        }
    }

}