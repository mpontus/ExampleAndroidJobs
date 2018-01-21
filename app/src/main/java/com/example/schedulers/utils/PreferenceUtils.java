package com.example.schedulers.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.example.schedulers.R;

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
  public static boolean isNotificationsEnabled(Context context) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    return preferences.getBoolean(context.getString(R.string.pref_notifications_enabled_key), false);
  }

  /**
   * Record the fact that the job has been scheduled
   *
   * @param context
   * @param isEnabled
   */
  public static void setNotificationsEnabled(Context context, boolean isEnabled) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    preferences.edit()
        .putBoolean(context.getString(R.string.pref_notifications_enabled_key), isEnabled)
        .commit();
  }

  /**
   * Returns the time elapsed since the job has been scheduled since the last notification
   * @param context
   * @return
   */
  public static long getLastTimestamp(Context context) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    return preferences.getLong(context.getString(R.string.pref_last_timestamp_key), 0);
  }

  /**
   * Sets the time for calculating the elapsed time
   *
   * @param context
   * @param timerStart
   */
  public static void setLastTimestamp(Context context, long timerStart) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    preferences.edit()
        .putLong(context.getString(R.string.pref_last_timestamp_key), timerStart)
        .commit();
  }
}
