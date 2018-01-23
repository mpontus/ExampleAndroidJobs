package com.example.schedulers.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.example.schedulers.AlarmReceiver;
import java.util.concurrent.TimeUnit;

public class SchedulerUtils {

  private static final int NOTIFICATION_INTERVAL_MILLIS = (int) TimeUnit.MINUTES.toMillis(15);
  private static final int PENDING_INTENT_REQUEST_CODE = 0;

  public static void scheduleJob(Context context) {
    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

    if (alarmManager == null) {
      return;
    }

    alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
        SystemClock.elapsedRealtime() + NOTIFICATION_INTERVAL_MILLIS,
        NOTIFICATION_INTERVAL_MILLIS,
        getPendingIntent(context));
  }

  public static void unscheduleJob(Context context) {
    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

    if (alarmManager == null) {
      return;
    }

    alarmManager.cancel(getPendingIntent(context));
  }

  private static PendingIntent getPendingIntent(Context context) {
    Intent intent = new Intent(context, AlarmReceiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
        PENDING_INTENT_REQUEST_CODE,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT);

    return pendingIntent;
  }
}
