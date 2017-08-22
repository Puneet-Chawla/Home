package com.example.student.hsar;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.student.hsar.MainActivity;
import com.google.firebase.messaging.RemoteMessage;

//private static final String TAG="MyFirebaseMessagingServ";
public class MyFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService{
    private static final String TAG = "MyFirebaseMessagingService";
    public MyFirebaseMessagingService() {
    }

    @Override
    public void onDeletedMessages() {

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
String title=remoteMessage.getNotification().getTitle();
        String message=remoteMessage.getNotification().getBody();
     //  Log.d(TAG,"onMessageRecieved:"+title+"message"+message);
sendNotification(title,message);

    }

    private void sendNotification(String title,String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}

