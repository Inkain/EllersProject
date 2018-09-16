package com.inkant1990gmail.ellersproject.classwork.classwork2

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.inkant1990gmail.ellersproject.classwork.classwork2.action.FOO"
private const val ACTION_BAZ = "com.inkant1990gmail.ellersproject.classwork.classwork2.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.inkant1990gmail.ellersproject.classwork.classwork2.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.inkant1990gmail.ellersproject.classwork.classwork2.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {

        val  link =intent!!.getStringExtra(LINK_EXTRA)
        Log.v("myLogs",link)
        Thread.sleep(3000)
        Log.v("myLogs",link)
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String, param2: String) {
        TODO("Handle action Foo")
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String, param2: String) {
        TODO("Handle action Baz")
    }

    companion object {
        var LINK_EXTRA : String = "Link"

        }



}
