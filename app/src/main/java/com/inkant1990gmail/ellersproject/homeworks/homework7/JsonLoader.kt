package com.inkant1990gmail.ellersproject.homeworks.homework7

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


object JsonLoader : AsyncTask<String, Int, Unit>() {
    override fun onCancelled(result: Unit?) {
        super.onCancelled(result)
    }

    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)
        cancel(true)

    }

    override fun doInBackground(vararg params: String?) {
        setConnection()


    }

    override fun onPreExecute() {
        super.onPreExecute()
    }



    fun setConnection() {
        val url: URL = URL("http://kiparo.ru/t/test.json")
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        try {
            urlConnection.setRequestMethod("GET");
            urlConnection.connect()
            val bufferedReader = BufferedReader(InputStreamReader(urlConnection.getInputStream()))
            convertJsonToObject(bufferedReader)

        } finally {
            urlConnection.disconnect()

        }
    }


    fun convertJsonToObject(reader: BufferedReader) {
        val gson: Gson = Gson()
        var s = gson.fromJson(reader, DataStudent::class.java)
        DataStudent.setInstance(s)
        Log.v("myLogs", DataStudent.getInstance()!!.people.size.toString())
    }
}

