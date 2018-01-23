package com.example.schedulers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.example.schedulers.utils.SchedulerUtils;

public class BootReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
      SchedulerUtils.scheduleJob(context);
    }
  }
}
