package com.inkant1990gmail.ellersproject.homeworks.homework7

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.inkant1990gmail.ellersproject.R
import com.inkant1990gmail.ellersproject.R.layout.activity_home7_main
import java.util.*


class Home7MainActivity : AppCompatActivity() {
    private lateinit var studentRecyclerView: RecyclerView
    private lateinit var editFilter: EditText
    private val studentAdapter: Home7StudentListAdapter = Home7StudentListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home7_main)
        studentRecyclerView = findViewById(R.id.rvHome7Students)
        editFilter = findViewById(R.id.etHome7filter)
        if (DataStudent.getInstance() == null) {
            JsonLoader.execute()
            JsonLoader.get()
        }
        studentAdapter.studentList = DataStudent.getInstance()!!.people
        editFilter.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                val list = ArrayList<Home7Student>()
                var filterQuery = editFilter.text.toString()

                for (student in DataStudent.getInstance()!!.people) {
                    if (filterQuery.isNotEmpty()) student.visible = student.name.equals(filterQuery) || student.surname.equals(filterQuery)
                    else student.visible = true
                    if (student.visible) list.add(student)
                }
                studentAdapter.studentList = list
            }
        })
        studentRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        studentRecyclerView.adapter = studentAdapter
        studentRecyclerView.setHasFixedSize(true)


    }

    override fun onResume() {
        super.onResume()
        studentAdapter.notifyDataSetChanged()

    }


    fun addStudent(view: View) {
        var intent: Intent = Intent(this, Home7EditActivity::class.java)
        intent.putExtra("EXIST", false)
        startActivity(intent)
    }
}

