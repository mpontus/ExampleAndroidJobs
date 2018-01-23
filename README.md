# Example Android Jobs

> Job scheduler examples for android

This repository demonstrates several approaches for implementing peridic jobs in Android.

Each example blongs to its own branch:

- [Android JobScheduler](https://github.com/mpontus/ExampleAndroidJobs/tree/AndroidJobScheduler) API >= 21 (Lollipop)
- [Firebase JobDispatcher](https://github.com/mpontus/ExampleAndroidJobs/tree/FirebaseJobDispatcher) API >= 9 (Gingerbread)
- [Evernote Android-Job](https://github.com/mpontus/ExampleAndroidJobs/tree/EvernoteAndroidJob) API >= 14 (Ice Cream Sandwich)
- [Android AlarmManager](https://github.com/mpontus/ExampleAndroidJobs/tree/AndroidAlarmManager) API >= 1

Use the following table to review the diffs between branches:

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

1. Download the source code and checkout the branch you want to use.

2. Open the project in Android Studio, compile and run the example on device or emulator (`^R`)

## Usage

Press **Schedule Job** to start the periodic which will display notifications about every 15 minutes.

You might need to reschedule a job after installing different example.

## License

MIT © 2018 Mikhail Pontus
