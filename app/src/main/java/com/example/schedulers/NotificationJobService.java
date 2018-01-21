package com.example.schedulers;

import android.util.Log;
import com.example.schedulers.utils.NotificationUtils;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

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
