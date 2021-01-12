package com.example.experimenta

import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.work.*
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class PingWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {


    /*@RequiresApi(Build.VERSION_CODES.N)
    override fun doWork(): Result {
        // define work load
        val queue = Volley.newRequestQueue(this.applicationContext)
        val url = "https://webhook.site/4d493bb3-dd63-4577-bede-14fe7cb6b4f2"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {},
            {})

        queue.add(stringRequest)

        // define execution period
        val currentDate = Calendar.getInstance()
        val dueDate = Calendar.getInstance()

        // set execution time
        dueDate.set(Calendar.HOUR_OF_DAY, 10)
        dueDate.set(Calendar.MINUTE, 15)
        dueDate.set(Calendar.SECOND, 0)

        if (dueDate.before(currentDate)) {
            //dueDate.add(Calendar.HOUR_OF_DAY, 24)
            dueDate.add(Calendar.MINUTE, 5)
        }

        val timeDiff = dueDate.timeInMillis - currentDate.timeInMillis
        val pingRequest = OneTimeWorkRequestBuilder<PingWorker>()
            .setInitialDelay(timeDiff, java.util.concurrent.TimeUnit.MILLISECONDS)
            //.addTag(TAG_OUTPUT)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(pingRequest)
            //.enqueueUniqueWork("ping", ExistingWorkPolicy.KEEP, pingRequest)
        return Result.success()
    }*/

    override fun doWork(): Result {
        val queue = Volley.newRequestQueue(this.applicationContext)
        val url = "https://webhook.site/5f4b763e-9ad8-4ab1-9c4d-2aeddfa76841"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {},
            {})

        queue.add(stringRequest)

        return if (stringRequest.hasHadResponseDelivered()) {Result.success()} else {Result.retry()}
    }
}