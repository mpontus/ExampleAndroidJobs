package app.example.schedulers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

class NotificationJobCreator implements JobCreator {

  @Nullable
  @Override
  public Job create(@NonNull String tag) {
    switch (tag) {
      case NotificationJob.TAG:
        Log.v("NotificationJobCreator", NotificationJob.TAG);

        return new NotificationJob();

      default:
        return null;
    }
  }
}
