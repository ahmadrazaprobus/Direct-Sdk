package io.probus.directdeveloper;

import android.content.Context;
import android.content.Intent;

/**
 * Created by root on 12/6/17.
 */

public class Direct {
    public static void initialize(Context context){
        context.startService(new Intent(context,DirectScanService.class));
    }
}
