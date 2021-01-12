package com.example.experimenta

import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.JobIntentService
import java.time.Duration
import java.time.LocalDateTime

class AlarmManagerTestService: JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        TODO("Not yet implemented")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        TODO()
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