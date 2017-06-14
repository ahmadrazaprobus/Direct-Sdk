package io.probus.directdeveloper;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by Mandeep on 11/10/2016.
 */

public class ManagePermission {
    Activity activity;
    public ManagePermission(Activity activity) {
        this.activity = activity;
    }

    public void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (activity.checkSelfPermission(Manifest.permission.LOCATION_HARDWARE) != PackageManager.PERMISSION_GRANTED ||
                    activity.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                    activity.checkSelfPermission( Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.ACCOUNT_MANAGER,
                                Manifest.permission.GET_ACCOUNTS,
                                Manifest.permission.ACCESS_NETWORK_STATE,
                                Manifest.permission.CAMERA,
                                Manifest.permission.WAKE_LOCK,
                                Manifest.permission.LOCATION_HARDWARE,
                                Manifest.permission.SEND_SMS},
                        1);
            }
        }

    }
    public  boolean checkPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (activity.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && activity.checkSelfPermission( Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED
                    && activity.checkSelfPermission( Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED) {
                return true;
            }else return false;

        }else return true;

    }
}
