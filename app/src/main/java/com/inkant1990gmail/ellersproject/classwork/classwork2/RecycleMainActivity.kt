package com.inkant1990gmail.ellersproject.classwork.classwork2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import com.inkant1990gmail.ellersproject.R

class RecycleMainActivity : AppCompatActivity() {
    private val adapter:StudentListAdapter= StudentListAdapter()
    lateinit var recycle: RecyclerView
    private lateinit var progres: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_main)
        recycle = findViewById(R.id.recycle)
        progres = findViewById(R.id.progress)
        recycle.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        recycle.setHasFixedSize(true)
        recycle.adapter=adapter
        val listData= listOf<Students>(
                Students("erhhrerhe","erhhrerhe"),
                Students("erhhrerhe","erhhrerhe"),
                Students("erhhrerhe","erhhrerhe")




        )

    adapter.listData=listData

    }
}
