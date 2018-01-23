# Example Android Jobs

> Job scheduler examples for android

This repository demonstrates several approaches for implementing peridic jobs in Android.

Each example is in its own branch:

- [Android JobScheduler](https://github.com/mpontus/ExampleAndroidJobs/tree/AndroidJobScheduler)
- [Firebase JobDispatcher](https://github.com/mpontus/ExampleAndroidJobs/tree/FirebaseJobDispatcher)
- [Evernote Android-Job](https://github.com/mpontus/ExampleAndroidJobs/tree/EvernoteAndroidJob)
- [Android AlarmManager](https://github.com/mpontus/ExampleAndroidJobs/tree/AndroidAlarmManager)

Review diffs between each branch:

|                      |Android JobScheduler|Firebase JobDispatcher|Evernote Android-Job|
|----------------------|--------------------|----------------------|--------------------|
|Android AlarmManager  |[diff](https://github.com/mpontus/ExampleAndroidJobs/compare/AndroidJobScheduler...AndroidAlarmManager)|[diff](https://github.com/mpontus/ExampleAndroidJobs/compare/FirebaseJobDispatcher...AndroidAlarmManager)|[diff](https://github.com/mpontus/ExampleAndroidJobs/compare/EvernoteAndroidJob...AndroidAlarmManager)|
|Evernote Android-Job  |[diff](https://github.com/mpontus/ExampleAndroidJobs/compare/AndroidJobScheduler...EvernoteAndroidJob)|[diff](https://github.com/mpontus/ExampleAndroidJobs/compare/FirebaseJobDispatcher...EvernoteAndroidJob)||
|Firebase JobDispatcher|[diff](https://github.com/mpontus/ExampleAndroidJobs/compare/AndroidJobScheduler...FirebaseJobDispatcher)|||

## Table of Contents

- [Install](#install)
- [Usage](#usage)
- [License](#license)

## Install

Download the source code and checkout the branch you want to use.

Open the project in Android Studio, compile and run the example (`^R`).

## Usage

Press **Schedule Job** to begin the periodic notifications.

Notificaitons will occur approximately every 15 minutes.

You can disable notifications at any time by pressing the button again.

## Implementation Notes

- 15 minutes may seem like a long time for debugging purposes. You can try chaging the interval in [SchedulerUtils.java](app/src/main/java/com/example/schedulers/utils/SchedulerUtils.java). Results may vary depending on the platform version and scheduler implementation. 

- Firebase JobScheduler does not persist jobs through application killing or reboots.
  Rescheduling the job on `android.intent.action.BOOT_COMPLETED` may help address this problem.
  According to [this issue](https://github.com/firebase/firebase-jobdispatcher-android/issues/101) it might be part of the intended library functionality. 

- Android AlarmManager example does not persist the job through application killing.
  Not sure how to go about fixing it without introducing JobScheduler to reschedule an alarm.
  [Ley me know](https://github.com/mpontus/ExampleAndroidJobs/issues/new) if you know a better way. 

## License

MIT © 2018 Mikhail Pontus
