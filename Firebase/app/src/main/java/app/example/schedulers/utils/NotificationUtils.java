package app.example.schedulers.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import app.example.schedulers.R;

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
        new NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("My notification")
            .setContentText("Hello world!")
            .setDefaults(Notification.DEFAULT_VIBRATE);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
        && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
      notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
    }

    notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
  }
}
