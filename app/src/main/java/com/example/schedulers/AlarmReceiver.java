package com.example.schedulers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.example.schedulers.utils.NotificationUtils;

public class AlarmReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    Log.v("AlarmReceiver", "onReceive");

    NotificationUtils.showNotification(context);
  }
}
