package com.example.schedulers.utils;

import android.content.Context;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.example.schedulers.NotificationJobService;
import java.util.concurrent.TimeUnit;

public class SchedulerUtils {

  private static final int NOTIFICATION_INTERVAL_MILLIS = (int) TimeUnit.MINUTES.toMillis(15);
  private static final int NOTIFICATION_FLEX_MILLIS = (int) TimeUnit.MINUTES.toMillis(5);

  public static void scheduleJob(Context context) {
    new JobRequest.Builder(NotificationJobService.TAG)
        .setPeriodic(NOTIFICATION_INTERVAL_MILLIS, NOTIFICATION_FLEX_MILLIS)
        .setUpdateCurrent(true)
        .build()
        .schedule();
  }

  public static void unscheduleJob(Context context) {
    JobManager.instance().cancelAllForTag(NotificationJobService.TAG);
  }
}
