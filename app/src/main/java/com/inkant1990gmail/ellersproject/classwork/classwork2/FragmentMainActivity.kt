package com.inkant1990gmail.ellersproject.classwork.classwork2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.inkant1990gmail.ellersproject.R

class FragmentMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_main)
        var text:TextView =findViewById(R.id.tvTitle)
    text.setOnClickListener(){
        changeFragment()
    }
    }

    private fun changeFragment() {

    }
}
