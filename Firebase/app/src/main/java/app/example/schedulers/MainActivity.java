package app.example.schedulers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import app.example.schedulers.utils.NotificationUtils;
import app.example.schedulers.utils.PreferenceUtils;
import app.example.schedulers.utils.SchedulerUtils;

public class MainActivity extends AppCompatActivity implements OnSharedPreferenceChangeListener {
  private Button mButton;
  private Toast mToast;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mButton = findViewById(R.id.button);

    mButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        boolean nowIsReminderEnabled = !PreferenceUtils.isReminderEnabled(MainActivity.this);

        PreferenceUtils.setReminderEnabled(MainActivity.this, nowIsReminderEnabled);

        if (nowIsReminderEnabled) {
          PreferenceUtils.setTimerStart(MainActivity.this, System.currentTimeMillis());
          SchedulerUtils.scheduleJob(MainActivity.this);
        } else {
          SchedulerUtils.unscheduleJob(MainActivity.this);
        }

        showToast(nowIsReminderEnabled
            ? getString(R.string.message_reminder_enabled)
            : getString(R.string.message_reminder_disabled));
      }
    });

    PreferenceManager.getDefaultSharedPreferences(this)
        .registerOnSharedPreferenceChangeListener(this);

    updateButtonLabel();
  }

  @Override
  public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    if (key == getString(R.string.pref_reminder_enabled_key)) {
      updateButtonLabel();
    }
  }

  private void updateButtonLabel() {
    boolean isReminderEnabled = PreferenceUtils.isReminderEnabled(this);

    mButton.setText(!isReminderEnabled
        ? getString(R.string.button_title_reminder_enable)
        : getString(R.string.button_title_reminder_disable));
  }

  private void showToast(String message) {
    if (mToast != null) {
      mToast.cancel();
    }

    mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);

    mToast.show();
  }
}
