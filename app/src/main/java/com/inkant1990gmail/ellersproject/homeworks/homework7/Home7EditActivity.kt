package com.inkant1990gmail.ellersproject.homeworks.homework7

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import com.inkant1990gmail.ellersproject.R

class Home7EditActivity : AppCompatActivity() {
    private lateinit var editName: EditText
    private lateinit var editSurName: EditText
    private lateinit var editAge: EditText
    private lateinit var editPhoto: EditText
    private lateinit var editDegree: EditText
    private lateinit var editID: EditText
    private lateinit var student: Home7Student
    private var exist:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home7_edit)
        init()
        var intent: Intent = getIntent()
        exist=intent.getBooleanExtra("EXIST", true)
        if (exist) {
            student = DataStudent.getInstance()!!.people[intent.getIntExtra("position", 0)]
            setDefaultData()
        } else student = Home7Student()


    }
   fun init() {
        editName = findViewById(R.id.etHome7FirstName)
        editSurName = findViewById(R.id.etHome7SurName)
        editAge = findViewById(R.id.etHome7Age)
        editPhoto = findViewById(R.id.etHome7photo)
        editDegree = findViewById(R.id.etHome7isDegree)
        editID = findViewById(R.id.etHome7StudentID)
    }

    fun setDefaultData() {
        editID.setText(student.id.toString())
        editName.setText(student.name)
        editSurName.setText(student.surname)
        editAge.setText(student.age.toString())
        editPhoto.setText(student.photo)
        editDegree.setText(student.isDegree.toString())

    }


    fun saveData(view: View) {
        student.id = editID.getText().toString().toInt()
        student.name = editName.text.toString()
        student.surname = editSurName.text.toString()
        student.age = editAge.text.toString().toInt()
        student.isDegree = editDegree.text.toString().toBoolean()
        if (editPhoto.text.toString().length > 0) student.photo = editPhoto.text.toString()
       if(!exist) DataStudent.getInstance()!!.people.add(student)
    }

}
