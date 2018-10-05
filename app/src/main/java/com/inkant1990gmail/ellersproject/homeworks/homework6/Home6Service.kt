package com.inkant1990gmail.ellersproject.homeworks.homework6

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.os.Binder
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager

class Home6Service : Service() {
    lateinit var cm: ConnectivityManager
    var network: NetworkInfo? = null
    var state: Boolean = false
    private val mBinder: IBinder = LocalBinder()
    private lateinit var wifi: WifiManager
    private lateinit var intent: Intent
    private val instance: LocalBroadcastManager = LocalBroadcastManager.getInstance(this)

    val wifiReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context, p1: Intent) {
            cm = p0.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            network = cm.getActiveNetworkInfo()
            state = if (network != null && network!!.getType() == ConnectivityManager.TYPE_WIFI) true else false
            intent = Intent("Wifi_State")
            intent.putExtra("State", state)
            instance.sendBroadcast(intent)
        }
    }

    override fun onBind(intent: Intent): IBinder {

        return this.mBinder
    }

    override fun onCreate() {
        super.onCreate()
        wifi = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        registerReceiver(wifiReceiver, IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"))
    }

    fun controlWifi() {
        if (state) wifi.isWifiEnabled = false else wifi.isWifiEnabled = true
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(wifiReceiver)
    }

    inner class LocalBinder : Binder() {
        val binder: Home6Service = this@Home6Service
            get() = field
    }
}
