package app.example.schedulers.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import app.example.schedulers.R;

/**
 * Functions for accessing shared preferences
 */
public class PreferenceUtils {

  /**
   * Returns whether the job is currently scheduled
   *
   * @param context
   * @return
   */
  public static boolean isReminderEnabled(Context context) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    return preferences.getBoolean(
        context.getString(R.string.pref_reminder_enabled_key),
        context.getResources().getBoolean(R.bool.pref_reminder_enabled_default_value));
  }

  /**
   * Record the fact that the job has been scheduled
   *
   * @param context
   * @param isEnabled
   */
  public static void setReminderEnabled(Context context, boolean isEnabled) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    preferences.edit().putBoolean(context.getString(R.string.pref_reminder_enabled_key), isEnabled)
        .commit();
  }

  /**
   * Returns the time elapsed since the job has been scheduled since the last notification
   * @param context
   * @return
   */
  public static long getTimerStart(Context context) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    return preferences.getLong(context.getString(R.string.pref_reminder_start_key), 0);
  }

  /**
   * Sets the time for calculating the elapsed time
   *
   * @param context
   * @param timerStart
   */
  public static void setTimerStart(Context context, long timerStart) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    preferences.edit().putLong(context.getString(R.string.pref_reminder_start_key), timerStart)
        .commit();
  }
}
