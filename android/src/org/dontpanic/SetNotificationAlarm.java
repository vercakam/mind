package org.dontpanic;

import android.app.AlarmManager;
import android.content.Context;
import java.util.Calendar;
import android.app.Activity;
import android.content.Intent;
import android.app.PendingIntent;

public class SetNotificationAlarm
{
    public SetNotificationAlarm() {}
    private static int ALARM1_ID = 10000;

    public static void setAlarm(Context context, String title, String message) {
            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY, 15);
            calendar.set(Calendar.MINUTE, 28);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            Calendar cur = Calendar.getInstance();

            if (cur.after(calendar)) {
                calendar.add(Calendar.DATE, 1);
            }

            Intent myIntent = new Intent(context, NotificationReceiver.class);
            myIntent.putExtra("title", title);
            myIntent.putExtra("message", message);
            myIntent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);           
            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    context, ALARM1_ID, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
            }

    public static void cancelAlarm(Context context)
    {
        Intent myIntent = new Intent(context, NotificationReceiver.class);
        myIntent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, ALARM1_ID, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }
}
