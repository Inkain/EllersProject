package com.inkant1990gmail.ellersproject.homeworks.homework7

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.inkant1990gmail.ellersproject.R
import com.inkant1990gmail.ellersproject.R.layout.activity_home7_main


class MainActivity : AppCompatActivity() {
    var mTwoPane: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home7_main)
        if (DataStudent.getInstance() == null) {
            JsonLoader.execute()
            JsonLoader.get()
        }
        mTwoPane = checkLand()
        val fragment: MainFragment = MainFragment.getInstance()
        val bundle: Bundle = Bundle()
        bundle.putBoolean("mTwoPane", mTwoPane)
        fragment.arguments = bundle
        this.supportFragmentManager.beginTransaction().replace(R.id.hm7MainContainer, fragment).commit()


    }

    fun checkLand(): Boolean = findViewById<View>(R.id.hm7studentDetailConteiner) != null

    fun addStudent(view: View) {
        val bundle: Bundle = Bundle()
        bundle.putBoolean("EXIST", false)
        bundle.putBoolean("mTwoPane", mTwoPane)
        val fragment: StudentDetailFragment = StudentDetailFragment.getInstance()
        fragment.arguments = bundle
        if (mTwoPane) this.supportFragmentManager.beginTransaction().replace(R.id.hm7studentDetailConteiner, fragment).commit()
        else this.supportFragmentManager.beginTransaction().replace(R.id.hm7MainContainer, fragment).commit()
    }

    override fun onResume() {
        super.onResume()
     //   if (findViewById<View>(R.id.hm7studentDetailConteiner) == null)supportFragmentManager.beginTransaction().remove(supportFragmentManager.findFragmentById(R.id.hm7studentDetailConteiner)!!).commit()
    }
}


