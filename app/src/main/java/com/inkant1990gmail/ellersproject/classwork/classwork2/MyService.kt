package com.inkant1990gmail.ellersproject.classwork.classwork2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
        Log.v("myLogs","onBind ")
    }

    override fun onCreate() {
        Log.v("myLogs","create ")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v("myLogs","startcommand ")
        return super.onStartCommand(intent, flags, startId)
    }


    override fun onDestroy() {
        Log.v("myLogs","destroy")
        super.onDestroy()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.v("myLogs","unbind ")
        return super.onUnbind(intent)
    }


}
