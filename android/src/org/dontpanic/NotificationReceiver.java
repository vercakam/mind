package org.dontpanic;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent;
import android.graphics.Color;
import android.graphics.BitmapFactory;
import android.app.NotificationChannel;
import android.content.BroadcastReceiver;
import android.media.RingtoneManager;
import android.net.Uri;


public class NotificationReceiver extends BroadcastReceiver {
private static NotificationManager m_notificationManager;
private static Notification.Builder m_builder;

@Override
public void onReceive(Context context, Intent intent) {
  /*  long when = System.currentTimeMillis();
    NotificationManager notificationManager = (NotificationManager) context
            .getSystemService(Context.NOTIFICATION_SERVICE);

    Intent notificationIntent = new Intent(context, DailySpecialActivity.class);
    notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
            notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);*/

    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    try {
        m_notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("Qt", "Qt Notifier", importance);
            m_notificationManager.createNotificationChannel(notificationChannel);
            m_builder = new Notification.Builder(context, notificationChannel.getId());
        } else {
            m_builder = new Notification.Builder(context);
        }

        m_builder.setSmallIcon(R.drawable.icon)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.icon))
                .setContentTitle("A message from Qt!")
                .setContentText("message").setSound(alarmSound)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setColor(Color.GREEN)
                .setAutoCancel(true);

        m_notificationManager.notify(0, m_builder.build());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
