package com.inkant1990gmail.ellersproject.classwork.classwork2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.inkant1990gmail.ellersproject.R

class StudentListAdapter : RecyclerView.Adapter<StudentListAdapter.Holder>() {
     var listData: List<Students> = emptyList()
    set(value){
        field=value
        notifyDataSetChanged()
    }
   var onItemClick:RecycleMainActivity.onItemClick?=null

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): Holder {
        var view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_recucle, viewGroup, false)
        return Holder(view)

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return listData.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val students = listData[p1]
        p0.nameTextView.setText(students.name)
        p0.surNameTextView.setText(students.surname)
        p0.itemView.setOnClickListener{
           onItemClick?.onClick(students)

        }


    }


    inner class Holder : RecyclerView.ViewHolder {
        lateinit var nameTextView: TextView
        lateinit var surNameTextView: TextView


        constructor(view: View) : super(view) {
            nameTextView = view.findViewById(R.id.item_text_1)
            surNameTextView = view.findViewById(R.id.item_text_2)
        }

    }

}