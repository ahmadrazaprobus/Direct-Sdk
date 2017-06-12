package io.probus.directdeveloper;;

/**
 * Created by root on 12/6/17.
 */

public class Advertisement {
    public void fetchActive(){

    }
    public void updateHistory(){

    }
//    public void showNotification(final AdvertisementEntity advertisementEntity, final String advertisementId) {
//        if (advertisementEntity.getAdvertisementImage() == null) return;
//        StorageReference islandRef = storage.getReferenceFromUrl(advertisementEntity.getAdvertisementImage());
//        final long ONE_MEGABYTE = 1024 * 1024 * 5;
//        islandRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//            @Override
//            public void onSuccess(byte[] bitmapdata) {
//                Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length);
//                Notification.Builder builder = new Notification.Builder(DirectScanService.backgroundScaner);
//                builder.setSmallIcon(R.mipmap.logo_small);
//                builder.setLargeIcon(BitmapFactory.decodeResource(BackgroundScaner.backgroundScaner.getResources(), R.mipmap.ic_launcher));
//                builder.setContentTitle(advertisementEntity.getAdvertisementTitle());
//                builder.setContentText(advertisementEntity.getAdvertisementDesc());
//
//                if (bitmap != null)
//                    builder.setStyle(new Notification.BigPictureStyle()
//                            .bigPicture(bitmap));
//                Intent activityIntent = new Intent(BackgroundScaner.this, AdvertisementInfoActivity.class);
//                activityIntent.putExtra("ADV", advertisementEntity);
//                activityIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                int requestID = (int) System.currentTimeMillis();
//                PendingIntent contentIntent = PendingIntent.getActivity(BackgroundScaner.this, requestID,
//                        activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//                builder.setContentIntent(contentIntent);
//                Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//                builder.setSound(alarmSound);
//
//                Notification notification = builder.build();
//
//                NotificationManager mNotifyMgr =
//                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                mNotifyMgr.notify(advertisementId.hashCode(), notification);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle any errors
//            }
//        });
//
//
//    }
}
