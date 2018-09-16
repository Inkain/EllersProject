package com.inkant1990gmail.ellersproject.classwork.classwork2

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.inkant1990gmail.ellersproject.R

class ServiceMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_main)
    }


    override fun onResume() {
        super.onResume()
        // bindService(Intent(this,MyIntentService::class.java),ServiceConnection, Context.BIND_AUTO_CREATE)
        val intent: Intent = Intent(this, MyIntentService::class.java)
        intent.putExtra(MyIntentService.LINK_EXTRA, "2")
        startService(intent)
        val intent1: Intent = Intent(this, MyIntentService::class.java)
        intent1.putExtra(MyIntentService.LINK_EXTRA, "3")
        startService(intent1)
        val intent2: Intent = Intent(this, MyIntentService::class.java)
        intent2.putExtra(MyIntentService.LINK_EXTRA, "4")
        startService(intent2)
        val intent3: Intent = Intent(this, MyIntentService::class.java)
        intent3.putExtra(MyIntentService.LINK_EXTRA, "5")
        startService(intent3)

    }

    override fun onPause() {
        super.onPause()
        // unbindService(ServiceConnection)
    }

    private val ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            Log.v("myLogs", "start")
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            Log.v("myLogs", "stop")
        }

    }
}
