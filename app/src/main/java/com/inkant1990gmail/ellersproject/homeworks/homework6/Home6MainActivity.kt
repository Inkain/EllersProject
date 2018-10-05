package com.inkant1990gmail.ellersproject.homeworks.homework6

import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.inkant1990gmail.ellersproject.R
import com.inkant1990gmail.ellersproject.homeworks.homework5.Home5ViewIndicator


class Home6MainActivity : AppCompatActivity() {
    private lateinit var instance: LocalBroadcastManager
    private var state: Boolean = false
    private lateinit var indicator: Home5ViewIndicator
    private val wifiStateReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context, p1: Intent) {
            state = p1.getBooleanExtra("State", false)
            indicator.wificheck(state)

        }
    }

    lateinit var wifiService: Home6Service
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            var binder = p1 as Home6Service.LocalBinder
            wifiService = p1.binder
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home6_main)
        instance = LocalBroadcastManager.getInstance(this)
        indicator = findViewById(R.id.home6indicator)


    }

    override fun onResume() {
        super.onResume()
        instance.registerReceiver(wifiStateReceiver, IntentFilter("Wifi_State"))
        bindService(Intent(this, Home6Service::class.java), serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onPause() {
        super.onPause()
        unbindService(serviceConnection)
        instance.unregisterReceiver(wifiStateReceiver)
    }

    fun wifiControl(view: View) {
        wifiService.controlWifi()

    }
}


