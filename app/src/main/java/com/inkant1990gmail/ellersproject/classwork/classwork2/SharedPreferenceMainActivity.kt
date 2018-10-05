package com.inkant1990gmail.ellersproject.classwork.classwork2

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.inkant1990gmail.ellersproject.R

class SharedPreferenceMainActivity : AppCompatActivity() {
companion object {
    const val SHARED_PREF_NAME ="dsdsdsd"
    const val HELLO ="dsdggrrgrgg"
}

    private lateinit var share:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference_main)
    share=getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)




    }
    override fun onStop(){
    super.onStop()
        share.edit().putString(HELLO,"Hello").apply()
    }

    override fun onStart() {
        super.onStart()
        val text= share.getString("HELLO","not data")
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }
}
