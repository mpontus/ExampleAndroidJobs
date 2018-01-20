package app.example.schedulers.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import app.example.schedulers.R;
import java.util.concurrent.TimeUnit;

public class NotificationUtils {
  private static final int NOTIFICATION_ID = 0;
  private static final String CHANNEL_ID = "main";

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

    NotificationCompat.Builder notificationBuilder =
        new Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(context.getString(R.string.notification_title))
            .setContentText(getNotificationMessage(context))
            .setDefaults(Notification.DEFAULT_VIBRATE);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
        && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
      notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
    }

    notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());

    PreferenceUtils.setTimerStart(context, System.currentTimeMillis());
  }

  private static String getNotificationMessage(Context context) {
    long start = PreferenceUtils.getTimerStart(context);
    long now = System.currentTimeMillis();
    long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(now - start);
    long minutesPassed = TimeUnit.SECONDS.toMinutes(diffInSeconds);
    long secondsLeftover = diffInSeconds - TimeUnit.MINUTES.toSeconds(minutesPassed);

    return context.getString(
        R.string.message_time_elapsed,
        minutesPassed,
        secondsLeftover);
  }
}
