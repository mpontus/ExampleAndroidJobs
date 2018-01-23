package com.example.schedulers.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.example.schedulers.AlarmReceiver;
import com.example.schedulers.BootReceiver;
import java.util.concurrent.TimeUnit;

public class SchedulerUtils {

  private static final int NOTIFICATION_INTERVAL_MILLIS = (int) TimeUnit.MINUTES.toMillis(15);
  private static final int PENDING_INTENT_REQUEST_CODE = 0;

  public static void scheduleJob(Context context) {
    setAlarm(context);
    setBootReceiver(context);
  }

  public static void unscheduleJob(Context context) {
    unsetAlarm(context);
    unsetBootReceiver(context);
  }

  public static void setAlarm(Context context) {
    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

    if (alarmManager == null) {
      return;
    }

    alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
        SystemClock.elapsedRealtime() + NOTIFICATION_INTERVAL_MILLIS,
        NOTIFICATION_INTERVAL_MILLIS,
        getPendingIntent(context));
  }

  public static void unsetAlarm(Context context) {
    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

    if (alarmManager == null) {
      return;
    }

    alarmManager.cancel(getPendingIntent(context));
  }

  private static void setBootReceiver(Context context) {
    ComponentName receiver = new ComponentName(context, BootReceiver.class);
    PackageManager pm = context.getPackageManager();

    pm.setComponentEnabledSetting(receiver,
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP);
  }

  private static void unsetBootReceiver(Context context) {
    ComponentName receiver = new ComponentName(context, BootReceiver.class);
    PackageManager pm = context.getPackageManager();

    pm.setComponentEnabledSetting(receiver,
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        PackageManager.DONT_KILL_APP);
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
