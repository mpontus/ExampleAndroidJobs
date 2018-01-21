package app.example.schedulers;

import android.app.Application;
import android.util.Log;
import com.evernote.android.job.JobManager;

public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    Log.v("MainApplication", "onCreate");

    JobManager.create(this).addJobCreator(new NotificationJobCreator());
  }
}
