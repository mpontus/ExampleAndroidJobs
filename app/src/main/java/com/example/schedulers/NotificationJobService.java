package com.example.schedulers;

import android.support.annotation.NonNull;
import android.util.Log;
import com.evernote.android.job.Job;
import com.example.schedulers.utils.NotificationUtils;

public class NotificationJobService extends Job {
  public static final String TAG = "NotificationJobService";

  @NonNull
  @Override
  protected Result onRunJob(@NonNull Params params) {
    Log.v("NotificationJobService", "onRunJob");

    NotificationUtils.showNotification(getContext());

    return Result.SUCCESS;
  }
}
