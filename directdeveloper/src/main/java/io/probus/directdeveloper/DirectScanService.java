package io.probus.directdeveloper;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

public class DirectScanService extends Service {
    public static DirectScanService backgroundScaner;
    private BleScanner bleScanner;
    public DirectScanService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        backgroundScaner = this;

        bleScanner = new BleScanner(this);
        handler.post(runnable);
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            bleScanner.stopScanning();
            bleScanner.startScanning();
            handler.postDelayed(this, 8000);
        }
    };
}
