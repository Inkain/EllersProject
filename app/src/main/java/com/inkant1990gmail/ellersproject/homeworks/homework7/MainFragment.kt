package com.inkant1990gmail.ellersproject.homeworks.homework7

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.inkant1990gmail.ellersproject.R


class MainFragment : Fragment() {
    private lateinit var studentRecyclerView: RecyclerView
    private lateinit var editFilter: EditText
    private lateinit var studentAdapter: StudentListAdapter

    companion object {
        fun getInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        studentRecyclerView = view.findViewById(R.id.rvHome7Students)
        editFilter = view.findViewById(R.id.etHome7filter)
        studentAdapter = StudentListAdapter(arguments!!.getBoolean("mTwoPane"), this)
        studentAdapter.studentList = DataStudent.getInstance()!!.people
        editFilter.addTextChangedListener(FilterStudent(studentAdapter))
        studentRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        studentRecyclerView.adapter = studentAdapter
        studentRecyclerView.setHasFixedSize(true)
        if (arguments!!.getBoolean("mTwoPane"))studentAdapter.notifyDataSetChanged()
        return view
    }
}
