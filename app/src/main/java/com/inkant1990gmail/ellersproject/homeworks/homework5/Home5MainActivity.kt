package com.inkant1990gmail.ellersproject.homeworks.homework5

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.inkant1990gmail.ellersproject.R


class Home5MainActivity : AppCompatActivity() {
    var indicator: Home5ViewIndicator? = null
    var cm: ConnectivityManager? = null
    var network: NetworkInfo? = null
    var state: Boolean = false
    var viewClock: Home5ClockView? = null
    var tas: task? = null
    val wifiReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context, p1: Intent) {
            cm = p0.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            network = cm!!.getActiveNetworkInfo()
            state = if (network != null && network!!.getType() == ConnectivityManager.TYPE_WIFI) true else false
            indicator!!.wificheck(state);


        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home5_main)
        indicator = findViewById(R.id.home5indicator)
        registerReceiver(wifiReceiver, IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"))
        //registerReceiver(timeReceiver, IntentFilter("android.intent.action.TIME_PICK"))
        viewClock = findViewById(R.id.home5Clock)
        tas = task(viewClock!!)
        tas!!.execute()
    }

    override fun onDestroy() {
        super.onDestroy()
        tas!!.cancel(true)
        unregisterReceiver(wifiReceiver)
    }
}
