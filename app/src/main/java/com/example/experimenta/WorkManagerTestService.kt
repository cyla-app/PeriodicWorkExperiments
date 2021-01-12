package com.example.experimenta

import android.app.Service
import android.content.Intent
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.work.*
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

class WorkManagerTestService: Service() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        val pingRequest: PeriodicWorkRequest = PeriodicWorkRequestBuilder<PingWorker>(15, TimeUnit.MINUTES)
            .build()
        WorkManager
            .getInstance(this.applicationContext)
            .enqueueUniquePeriodicWork("ping", ExistingPeriodicWorkPolicy.KEEP, pingRequest)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}
