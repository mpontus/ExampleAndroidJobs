package com.example.schedulers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.example.schedulers.utils.PreferenceUtils;
import com.example.schedulers.utils.SchedulerUtils;

/**
 * Activity which displays a single button to toggle a scheduled job
 */
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
        boolean nowIsNotificationsEnabled =
            !PreferenceUtils.isNotificationsEnabled(MainActivity.this);

        PreferenceUtils.setNotificationsEnabled(MainActivity.this, nowIsNotificationsEnabled);

        if (nowIsNotificationsEnabled) {
          PreferenceUtils.setLastTimestamp(MainActivity.this, System.currentTimeMillis());
          SchedulerUtils.scheduleJob(MainActivity.this);
        } else {
          SchedulerUtils.unscheduleJob(MainActivity.this);
        }

        showToast(nowIsNotificationsEnabled
            ? getString(R.string.message_notifications_enabled)
            : getString(R.string.message_notifications_disabled));
      }
    });

    PreferenceManager.getDefaultSharedPreferences(this)
        .registerOnSharedPreferenceChangeListener(this);

    updateButtonLabel();
  }

  @Override
  public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    if (key == getString(R.string.pref_notifications_enabled_key)) {
      updateButtonLabel();
    }
  }

  /**
   * Actualize the button label according to current preference value
   */
  private void updateButtonLabel() {
    boolean isNotificationsEnabled = PreferenceUtils.isNotificationsEnabled(this);

    mButton.setText(!isNotificationsEnabled
        ? getString(R.string.button_title_notifications_enable)
        : getString(R.string.button_title_notifications_disable));
  }

  /**
   * Show the message, replace any previous messages
   *
   * @param message
   */
  private void showToast(String message) {
    if (mToast != null) {
      mToast.cancel();
    }

    mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);

    mToast.show();
  }
}
