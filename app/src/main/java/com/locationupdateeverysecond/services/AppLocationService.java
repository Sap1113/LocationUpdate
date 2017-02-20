package com.locationupdateeverysecond.services;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.locationupdateeverysecond.uc.Const;

public class AppLocationService extends Service implements LocationListener {

    protected LocationManager locationManager;
    Location location;

    private static final long MIN_DISTANCE_FOR_UPDATE = 0; // 500 meter
    private static final long MIN_TIME_FOR_UPDATE = 30000; // 30 seconds

    String NetworkProvider = LocationManager.NETWORK_PROVIDER;
    String GPSProvider = LocationManager.GPS_PROVIDER;
    Context context;
    int MY_PERMISSION_LOCATION = 111;

    public AppLocationService(Context context) {
        this.context = context;
        locationManager = (LocationManager) this.context.getSystemService(LOCATION_SERVICE);
    }

    public Location getLocation() {

        if (locationManager.isProviderEnabled(NetworkProvider)) {
            Log.i("NetworkProvider ", locationManager + "");

            locationManager.requestLocationUpdates(NetworkProvider, MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);

            if (locationManager != null) {
                location = locationManager.getLastKnownLocation(NetworkProvider);
                if (location != null) {
                    Const.LATITUDE = String.valueOf(location.getLatitude());
                    Const.LONGITUDE = String.valueOf(location.getLongitude());
                    Const.location = location;
                    Const.speed = (int) location.getSpeed();

                    Log.i(NetworkProvider + " Reading :: ",
                            "Longitude : " + Const.LONGITUDE + " <br/>Laitude : " + Const.LATITUDE + "<br/>Time :"
                                    + System.currentTimeMillis() + "<br/>Speed :" + Const.speed + "<br/>Speed MPH :"
                                    + (int) (location.getSpeed() * 2.2369) + "<br/>Speed km/h :"
                                    + (int) ((location.getSpeed() * 3600) / 1000));

                    Log.i(NetworkProvider + " Reading :: ", "============================================");
                    Log.i(NetworkProvider + " Reading :: ", "Longitude : " + Const.LONGITUDE);
                    Log.i(NetworkProvider + " Reading :: ", "Laitude : " + Const.LATITUDE);
                    Log.i(NetworkProvider + " Reading :: ", "Speed : " + Const.speed);
                    Log.i(NetworkProvider + " Reading :: ", "Speed MPH: " + (int) (location.getSpeed() * 2.2369));
                    Log.i(NetworkProvider + " Reading :: ",
                            "Speed km/h: " + (int) ((location.getSpeed() * 3600) / 1000));
                    Log.i(NetworkProvider + " Reading :: ", "============================================");

                    //Prefs.setValue(context, "IS_LOCATION_AVAILABLE", "1");
                }
            }
        }
        if (locationManager.isProviderEnabled(GPSProvider)) {
            Log.i("GPSProvider", locationManager + "");

            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            }
            locationManager.requestLocationUpdates(GPSProvider, MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
            if (locationManager != null) {
                location = locationManager.getLastKnownLocation(GPSProvider);
                if (location != null) {
                    Const.LATITUDE = String.valueOf(location.getLatitude());
                    Const.LONGITUDE = String.valueOf(location.getLongitude());
                    Const.location = location;
                    Const.speed = (int) location.getSpeed();

                    Log.i(GPSProvider + " Reading :: ",
                            "Longitude : " + Const.LONGITUDE + " <br/>Laitude : " + Const.LATITUDE + "<br/>Time :"
                                    + System.currentTimeMillis() + "<br/>Speed :" + Const.speed + "<br/>Speed MPH :"
                                    + (int) (location.getSpeed() * 2.2369) + "<br/>Speed km/h :"
                                    + (int) ((location.getSpeed() * 3600) / 1000));

                    Log.i(GPSProvider + " Reading :: ", "============================================");
                    Log.i(GPSProvider + " Reading :: ", "Longitude : " + Const.LONGITUDE);
                    Log.i(GPSProvider + " Reading :: ", "Laitude : " + Const.LATITUDE);
                    Log.i(GPSProvider + " Reading :: ", "Speed : " + Const.speed);
                    Log.i(GPSProvider + " Reading :: ", "Speed MPH: " + (int) (location.getSpeed() * 2.2369));
                    Log.i(GPSProvider + " Reading :: ",
                            "Speed km/h: " + (int) ((location.getSpeed() * 3600) / 1000));
                    Log.i(GPSProvider + " Reading :: ", "============================================");

                    //Prefs.setValue(context, "IS_LOCATION_AVAILABLE", "1");
                }
            }
        }

        return location;
    }

    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }


//
}
