package com.inkant1990gmail.ellersproject.homeworks.homework5

import android.os.AsyncTask
import java.util.concurrent.TimeUnit

class task(hclock:Home5ClockView) : AsyncTask<String, Int, Unit>() {
    var hclock1:Home5ClockView=hclock
    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg p0: String?) {
        while (true) {
            hclock1.clockrun()
        TimeUnit.SECONDS.sleep(1)
        }

    }

    override fun onCancelled(result: Unit?) {
        super.onCancelled(result)
    }

    override fun onCancelled() {
        super.onCancelled()
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }
}