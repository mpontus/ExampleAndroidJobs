package com.example.schedulers.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import com.example.schedulers.MainActivity;
import com.example.schedulers.R;
import java.util.concurrent.TimeUnit;

/**
 * Functions for displaying notification
 */
public class NotificationUtils {
  private static final int NOTIFICATION_ID = 0;
  private static final String CHANNEL_ID = "main";
  private static final int PENDING_INTENT_REQUEST_CODE = 0;

  /**
   * Show the sample notification with the elapsed time
   *
   * @param context
   */
  public static void showNotification(Context context) {
    NotificationManager notificationManager =
        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    if (notificationManager == null) {
      return;
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      NotificationChannel mChannel = new NotificationChannel(
          CHANNEL_ID,
          context.getString(R.string.main_notification_channel_name),
          NotificationManager.IMPORTANCE_HIGH);

      notificationManager.createNotificationChannel(mChannel);
    }

    Builder notificationBuilder =
        new Builder(context, CHANNEL_ID)
            .setContentIntent(getPendingIntent(context))
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(context.getString(R.string.notification_title))
            .setContentText(getNotificationMessage(context))
            .setDefaults(Notification.DEFAULT_VIBRATE);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
        && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
      notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
    }

    notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());

    PreferenceUtils.setLastTimestamp(context, System.currentTimeMillis());
  }

  /**
   * Format the string with the elapsed time
   *
   * @param context
   * @return
   */
  private static String getNotificationMessage(Context context) {
    long start = PreferenceUtils.getLastTimestamp(context);
    long now = System.currentTimeMillis();
    long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(now - start);
    long minutesPassed = TimeUnit.SECONDS.toMinutes(diffInSeconds);
    long secondsLeftover = diffInSeconds - TimeUnit.MINUTES.toSeconds(minutesPassed);

    return context.getString(
        R.string.message_time_elapsed,
        minutesPassed,
        secondsLeftover);
  }

  /**
   * Create pending intent that will open the application when user clicks on notification
   *
   * @param context
   * @return
   */
  private static PendingIntent getPendingIntent(Context context) {
    Intent launchMainActivity = new Intent(context, MainActivity.class);

    return PendingIntent.getActivity(
        context,
        PENDING_INTENT_REQUEST_CODE,
        launchMainActivity,
        PendingIntent.FLAG_UPDATE_CURRENT);
  }
}
