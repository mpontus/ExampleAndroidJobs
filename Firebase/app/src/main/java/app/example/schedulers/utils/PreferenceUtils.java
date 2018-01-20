package app.example.schedulers.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import app.example.schedulers.R;

/**
 * Created by michael on 20/01/2018.
 */

public class PreferenceUtils {
  public static boolean isReminderEnabled(Context context) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    return preferences.getBoolean(
        context.getString(R.string.pref_reminder_enabled_key),
        context.getResources().getBoolean(R.bool.pref_reminder_enabled_default_value));
  }

  public static void setReminderEnabled(Context context, boolean isEnabled) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    preferences.edit().putBoolean(context.getString(R.string.pref_reminder_enabled_key), isEnabled)
        .commit();
  }

  public static long getTimerStart(Context context) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    return preferences.getLong(context.getString(R.string.pref_reminder_start_key), 0);
  }

  public static void setTimerStart(Context context, long timerStart) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

    preferences.edit().putLong(context.getString(R.string.pref_reminder_start_key), timerStart)
        .commit();
  }
}
