package com.example.experimenta

import android.app.Service
import android.content.Intent
import android.icu.util.Calendar
import android.icu.util.TimeUnit
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.work.*
import java.time.Duration
import java.time.LocalDateTime

class OneTimeWorkManagerTestService : Service() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        // define execution period
        val currentDate = Calendar.getInstance()
        val dueDate = Calendar.getInstance()

        // set execution time
        dueDate.set(Calendar.HOUR_OF_DAY, 10)
        dueDate.set(Calendar.MINUTE, 35)
        dueDate.set(Calendar.SECOND, 0)

        if (dueDate.before(currentDate)) {
            dueDate.add(Calendar.HOUR_OF_DAY, 24)
        }

        val timeDiff = Duration.ofMillis(dueDate.timeInMillis - currentDate.timeInMillis)
        val pingRequest: OneTimeWorkRequest = OneTimeWorkRequestBuilder<PingWorker>()
            .setInitialDelay(timeDiff)
            .build()
        WorkManager
            .getInstance(this.applicationContext)
            .enqueue(pingRequest)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun differenceBetween(time1: LocalDateTime, time2: LocalDateTime): Duration {
        val nano1 = time1.nano
        val nano2 = time2.nano
        val longDifference = (nano2 - nano1).toLong()
        return Duration.ofNanos((time2.nano - time1.nano).toLong())
    }
}
