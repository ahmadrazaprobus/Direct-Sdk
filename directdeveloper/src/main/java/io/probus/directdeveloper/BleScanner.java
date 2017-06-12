package io.probus.directdeveloper;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/3/17.
 */

public class BleScanner {
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothManager bluetoothManager;
    private Context activity;
    private List<String> scanList;
    public static Boolean welcome = false;


    public BleScanner(Context act) {
        activity = act;
        bluetoothManager = (BluetoothManager) activity.getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();
        scanList = new ArrayList<>();
    }

    public BleScanner startScanning() {
        if (mBluetoothAdapter != null && mBluetoothAdapter.isEnabled()) {
            scanList.clear();
            mBluetoothAdapter.startLeScan(mLeScanCallback);
        }
        return this;
    }

    public void stopScanning() {
        if (mBluetoothAdapter != null) mBluetoothAdapter.stopLeScan(mLeScanCallback);
        scanList.clear();
    }

    private BluetoothAdapter.LeScanCallback mLeScanCallback =
            new BluetoothAdapter.LeScanCallback() {
                @Override
                public void onLeScan(final BluetoothDevice device, int rssi,
                                     byte[] scanRecord) {
                    final int rssiPositive = Math.abs(rssi);
                    String advIndex = String.format("%02x", scanRecord[7]);
                    if (!advIndex.equals("01")) return;
                    if (scanList.indexOf(device.getAddress()) >= 0) return;
                    scanList.add(device.getAddress());

//                    BackgroundScaner.databaseReference.getRoot()
//                            .child("DIRECT_LIST")
//                            .child(device.getAddress())
//                            .addListenerForSingleValueEvent(new ValueEventListener() {
//                                @Override
//                                public void onDataChange(DataSnapshot dataSnapshot) {
//                                    Log.d("DEVICE_FOUND", device.getName() + "=" + device.getAddress()+
//                                            "************* RSSI="+rssiPositive);
//                                    if(!dataSnapshot.exists())return;
//                                    DirectEntity directEntity=dataSnapshot.getValue(DirectEntity.class);
//                                    if(Boolean.valueOf(directEntity.getIsWelcome())){
//                                        if (!BleScanner.welcome)
//                                            showNotification();
//                                        if (BackgroundScaner.backgroundScaner != null) {
//                                            BackgroundScaner.backgroundScaner.fetchActive(device.getAddress(),directEntity.getDirectName());
////                                            new Thread(new AdvertismentThread(device.getAddress(),directEntity.getDirectName())).start();
//                                        }
//
//                                    }else if(rssiPositive<=Integer.valueOf(directEntity.getRssi())){
//                                        if (BackgroundScaner.backgroundScaner != null) {
//                                            BackgroundScaner.backgroundScaner.fetchActive(device.getAddress(),directEntity.getDirectName());
////                                            new Thread(new AdvertismentThread(device.getAddress(),directEntity.getDirectName())).start();
//                                        }
//                                    }
//                                }
//
//                                @Override
//                                public void onCancelled(DatabaseError databaseError) {
//
//                                }
//                            });
                    Log.d("DEVICE_FOUND", device.getName() + "=" + device.getAddress()+
                    "************* RSSI="+rssiPositive);
                }
            };
    public void showNotification() {
//        Notification.Builder builder = new Notification.Builder(BackgroundScaner.backgroundScaner);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            builder.setSmallIcon(R.mipmap.imgpsh_fullsize);
//        } else {
//            builder.setSmallIcon(R.mipmap.imgpsh_fullsize);
//        }
//
//        builder.setLargeIcon(BitmapFactory.decodeResource(BackgroundScaner.backgroundScaner.getResources(), R.mipmap.ic_launcher));
//        builder.setContentTitle("LG Brand Shop");
//        builder.setContentText("LG brand shop is near you. Get spot offers in the app.");
//        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        builder.setSound(alarmSound);
//        int requestID = (int) System.currentTimeMillis();
//        Notification notification = builder.build();
//        NotificationManager mNotifyMgr =
//                (NotificationManager) BackgroundScaner.backgroundScaner.getSystemService(BackgroundScaner.backgroundScaner.NOTIFICATION_SERVICE);
//        mNotifyMgr.notify(requestID, notification);
//        BleScanner.welcome = true;
    }

}
