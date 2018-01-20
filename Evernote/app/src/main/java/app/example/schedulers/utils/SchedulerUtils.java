package app.example.schedulers.utils;

import android.content.Context;
import app.example.schedulers.ExampleJobService;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;
import java.util.concurrent.TimeUnit;

/**
 * Functions for scheduling the job
 */
public class SchedulerUtils {
  private static final String JOB_TAG = "example-job";
  private static final int REMINDER_INTERVAL_SECONDS = (int) TimeUnit.MINUTES.toSeconds(5);
  private static final int REMINDER_FLEXTIME_SECONDS = (int) TimeUnit.MINUTES.toSeconds(1);

  /**
   * Schedule a recurring job which shows a notification every couple of minutes
   *
   * @param context
   */
  public static void scheduleJob(Context context) {
    FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));

    Job job = dispatcher.newJobBuilder()
        .setService(ExampleJobService.class)
        .setTag(JOB_TAG)
        .setRecurring(true)
        .setLifetime(Lifetime.FOREVER)
        .setTrigger(Trigger.executionWindow(
            REMINDER_INTERVAL_SECONDS,
            REMINDER_INTERVAL_SECONDS + REMINDER_FLEXTIME_SECONDS))
        .setReplaceCurrent(true)
        .build();

    dispatcher.mustSchedule(job);
  }

  /**
   * Unschedules the recurring job
   * @param context
   */
  public static void unscheduleJob(Context context) {
    FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));

    dispatcher.cancel(JOB_TAG);
  }
}
