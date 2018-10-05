package com.inkant1990gmail.ellersproject.homeworks.homework7

import android.os.AsyncTask
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


object JsonLoader : AsyncTask<String, Int, Unit>() {

    override fun doInBackground(vararg params: String?) {
        setConnection()
    }

    fun setConnection() {
        val url: URL = URL("http://kiparo.ru/t/test.json")
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        var bufferedReader: BufferedReader? = null
        try {
            urlConnection.setRequestMethod("GET");
            urlConnection.connect()
            bufferedReader = BufferedReader(InputStreamReader(urlConnection.getInputStream()))
            convertJsonToObject(bufferedReader)
            bufferedReader.close()

        } finally {
            bufferedReader!!.close()
            urlConnection.disconnect()
        }
    }

    fun convertJsonToObject(reader: BufferedReader) {
        val gson: Gson = Gson()
        var s = gson.fromJson(reader, DataStudent::class.java)
        DataStudent.setInstance(s)
    }
}

