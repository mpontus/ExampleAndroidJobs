package com.example.schedulers.utils;

import android.content.Context;
import com.example.schedulers.NotificationJobService;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;
import java.util.concurrent.TimeUnit;

public class SchedulerUtils {
  private static final String NOTIFICATION_JOB_TAG = "notification-job";
  private static final int REMINDER_INTERVAL_SECONDS = (int) TimeUnit.MINUTES.toSeconds(15);
  private static final int REMINDER_FLEXTIME_SECONDS = (int) TimeUnit.MINUTES.toSeconds(5);

  public static void scheduleJob(Context context) {
    FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));

    Job job = dispatcher.newJobBuilder()
        .setService(NotificationJobService.class)
        .setTag(NOTIFICATION_JOB_TAG)
        .setRecurring(true)
        .setLifetime(Lifetime.FOREVER)
        .setTrigger(Trigger.executionWindow(
            REMINDER_INTERVAL_SECONDS,
            REMINDER_INTERVAL_SECONDS + REMINDER_FLEXTIME_SECONDS))
        .setReplaceCurrent(true)
        .build();

    dispatcher.mustSchedule(job);
  }

  public static void unscheduleJob(Context context) {
    FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));

    dispatcher.cancel(NOTIFICATION_JOB_TAG);
  }
}
