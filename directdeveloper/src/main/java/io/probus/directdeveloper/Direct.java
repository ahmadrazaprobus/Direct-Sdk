package io.probus.directdeveloper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by root on 12/6/17.
 */

public class Direct {
    public static void initialize(Activity context){
        new ManagePermission(context).requestPermission();;
        context.startService(new Intent(context,DirectScanService.class));
    }
}
