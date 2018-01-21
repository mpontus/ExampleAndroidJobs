# Example Android Jobs

> Job scheduler examples for android

Branches show usage of following libraries:

- [Android JobScheduler](https://github.com/mpontus/ExampleAndroidJobs/tree/AndroidJobScheduler) API >= 21 (Lollipop)
- [Firebase JobDispatcher](https://github.com/mpontus/ExampleAndroidJobs/tree/FirebaseJobDispatcher) API >= 9 (Gingerbread)
- [Evernote Android-Job](https://github.com/mpontus/ExampleAndroidJobs/tree/EvernoteAndroidJob) API >= 14 (Ice Cream Sandwich)

Here are the differences between each implementation:

|                      |Firebase JobDispatcher|Evernote Android-Job|
|----------------------|----------------------|--------------------|
|Android JobScheduler  |[diff](https://github.com/mpontus/ExampleAndroidJobs/compare/AndroidJobScheduler...FirebaseJobDispatcher)|[diff](https://github.com/mpontus/ExampleAndroidJobs/compare/AndroidJobScheduler...EvernoteAndroidJob) |
|Firebase JobDispatcher||[diff](https://github.com/mpontus/ExampleAndroidJobs/compare/FirebaseJobDispatcher...EvernoteAndroidJob)|

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
