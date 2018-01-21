package app.example.schedulers;

import android.util.Log;
import app.example.schedulers.utils.NotificationUtils;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import java.util.concurrent.TimeUnit;

public class NotificationJob extends Job {
  static final String TAG = "NotificationJob";

  private static final int NOTIFICATION_INTERVAL_MILLIS = (int) TimeUnit.MINUTES.toMillis(15);
  private static final int NOTIFICATION_FLEX_MILLIS = (int) TimeUnit.MINUTES.toMillis(5);

  static void schedulePeriodicJob() {
    new JobRequest.Builder(TAG)
        .setPeriodic(NOTIFICATION_INTERVAL_MILLIS, NOTIFICATION_FLEX_MILLIS)
        .setUpdateCurrent(true)
        .build()
        .schedule();
  }

  static void cancelPeriodicJob() {
    JobManager.instance().cancelAllForTag(TAG);
  }

  protected Result onRunJob(Params params) {
    Log.v("NotificationJob", "onRunJob");

    NotificationUtils.showNotification(getContext());

    return Result.SUCCESS;
  }
}
