package com.luis_santiago.aigol.utils.tools.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.luis_santiago.aigol.MainActivity;
import com.luis_santiago.aigol.R;

/**
 * Created by Luis Fernando Santiago Ruiz on 9/24/17.
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    private int currentNotificationID = 0;
    private NotificationManager notificationManager;
    private Bitmap icon;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.e("NOTIFCAION2", from);

        if(remoteMessage.getNotification()!=null){
            Log.e("MESSAGE NOTIFIACIONE", remoteMessage.getNotification().getBody());
            showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        }
    }

    private void showNotification(String title, String body) {

        icon =   BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_launcher_app);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder notificaionBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_ic_launcher_app)
                .setColor(getResources().getColor(R.color.colorPrimaryDark))
                .setLargeIcon(icon)
                .setVibrate(new long[] { 100, 250 })
                .setDefaults(Notification.DEFAULT_SOUND).setAutoCancel(true)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setContentText(body);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        notificaionBuilder.setContentIntent(contentIntent);
        Notification notification = notificaionBuilder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_SOUND;
        // In order to send notification we have to create a unique id for each one
        currentNotificationID++;

        int notificationId = currentNotificationID;
        if (notificationId == Integer.MAX_VALUE - 1)
            notificationId = 0;
        // setting our notification to just be send!
        notificationManager.notify(notificationId, notification);
    }
}
