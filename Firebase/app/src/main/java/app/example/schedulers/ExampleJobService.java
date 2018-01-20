package app.example.schedulers;

import android.app.NotificationManager;
import android.content.Context;
import app.example.schedulers.utils.NotificationUtils;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class ExampleJobService extends JobService {
  @Override
  public boolean onStartJob(JobParameters job) {
    NotificationUtils.showNotification(this);

    return false; // Answers the question: "Is there still work going on?"
  }

  @Override
  public boolean onStopJob(JobParameters job) {
    return false; // Answers the question: "Should this job be retried?"
  }
}
