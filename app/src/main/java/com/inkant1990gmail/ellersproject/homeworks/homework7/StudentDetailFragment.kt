package com.inkant1990gmail.ellersproject.homeworks.homework7

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.inkant1990gmail.ellersproject.R


class StudentDetailFragment : Fragment(), View.OnClickListener {
    companion object {
        fun getInstance(): StudentDetailFragment {
            return StudentDetailFragment()
        }
    }

    private lateinit var editName: EditText
    private lateinit var editSurName: EditText
    private lateinit var editAge: EditText
    private lateinit var editPhoto: EditText
    private lateinit var editDegree: EditText
    private lateinit var editID: EditText
    private lateinit var student: Student
    private lateinit var save: Button
    private var exist: Boolean = true

    fun init(view: View) {
        editName = view.findViewById(R.id.etHome7FirstName)
        editSurName = view.findViewById(R.id.etHome7SurName)
        editAge = view.findViewById(R.id.etHome7Age)
        editPhoto = view.findViewById(R.id.etHome7photo)
        editDegree = view.findViewById(R.id.etHome7isDegree)
        editID = view.findViewById(R.id.etHome7StudentID)
        save = view.findViewById(R.id.btSaveStudent)
    }

    fun setDefaultData() {
        editID.setText(student.id.toString())
        editName.setText(student.name)
        editSurName.setText(student.surname)
        editAge.setText(student.age.toString())
        editPhoto.setText(student.photo)
        editDegree.setText(student.isDegree.toString())

    }


    override fun onClick(v: View?) {
        if (editID.getText().toString().isEmpty() || editAge.getText().toString().isEmpty()) return
        student.id = editID.getText().toString().toInt()
        student.name = editName.text.toString()
        student.surname = editSurName.text.toString()
        student.age = editAge.text.toString().toInt()
        student.isDegree = editDegree.text.toString().toBoolean()
        if (editPhoto.text.toString().length > 0) student.photo = editPhoto.text.toString()
        if (!exist) DataStudent.getInstance()!!.people.add(student)
        val fragment: MainFragment = MainFragment.getInstance()
        val bundle: Bundle = Bundle()
        bundle.putBoolean("mTwoPane", arguments!!.getBoolean("mTwoPane"))
        fragment.arguments = bundle
        if (arguments!!.getBoolean("mTwoPane")) {
            fragmentManager!!.beginTransaction().remove(fragmentManager?.findFragmentById(R.id.hm7studentDetailConteiner)!!).commit()
            fragmentManager!!.beginTransaction().replace(R.id.hm7MainContainer, fragment).commit()
        } else fragmentManager!!.beginTransaction().replace(R.id.hm7MainContainer, fragment).commit()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.activity_home7_edit, container, false)
        init(view)
        save.setOnClickListener(this)
        exist = arguments!!.getBoolean("EXIST")
        if (exist) {
            student = DataStudent.getInstance()!!.people[arguments!!.getInt("position", 0)]
            setDefaultData()
        } else student = Student()

        return view
    }
}

