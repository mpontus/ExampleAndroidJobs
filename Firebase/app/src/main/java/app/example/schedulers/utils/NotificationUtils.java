package app.example.schedulers.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import app.example.schedulers.R;

public class NotificationUtils {
  private static final int NOTIFICATION_ID = 0;
  private static final String CHANNEL_ID = "main";

  public static void showNotification(Context context) {
    NotificationCompat.Builder notificationBuilder =
        new NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("My notification")
            .setContentText("Hello world!")
            .setDefaults(Notification.DEFAULT_VIBRATE);

    NotificationManager notificationManager =
        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    if (notificationManager != null) {
      notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
    }
  }
}
