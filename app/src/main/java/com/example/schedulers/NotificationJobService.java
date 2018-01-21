package com.example.schedulers;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import com.example.schedulers.utils.NotificationUtils;

public class NotificationJobService extends JobService {

  @Override
  public boolean onStartJob(JobParameters params) {
    Log.v("NotificationJobService", "onStartJob");

    NotificationUtils.showNotification(this);

    return false;
  }

  @Override
  public boolean onStopJob(JobParameters params) {
    return false;
  }
}
