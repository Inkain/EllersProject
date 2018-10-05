package com.inkant1990gmail.ellersproject.homeworks.homework7

import android.text.Editable
import android.text.TextWatcher
import java.util.*


class FilterStudent(adapter: StudentListAdapter) : TextWatcher {
    private val adapter = adapter
    override fun afterTextChanged(s: Editable) {
        val list = ArrayList<Student>()
        val filterQuery = s.toString()
        for (student in DataStudent.getInstance()!!.people) {
            if (filterQuery.isNotEmpty()) {
                student.visible = compareFullName(student.name, filterQuery, student.surname)
            } else student.visible = true
            if (student.visible) list.add(student)
        }
        adapter.studentList = list
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        for (student in DataStudent.getInstance()!!.people) {
            student.visible = true
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    private fun compareFullName(name: String?, query: String, surName: String?): Boolean {
        var sumName = name + " " + surName
        return sumName.contains(query, true)
    }
}