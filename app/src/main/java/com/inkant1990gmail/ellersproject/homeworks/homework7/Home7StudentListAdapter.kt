package com.inkant1990gmail.ellersproject.homeworks.homework7

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.inkant1990gmail.ellersproject.R
import com.inkant1990gmail.ellersproject.classwork.classwork2.Students
import com.squareup.picasso.Picasso

class Home7StudentListAdapter() : RecyclerView.Adapter<Home7StudentListAdapter.Holder>() {
    var studentList: List<Home7Student> = emptyList()
        set(v) {
            field = v
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): Holder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_home7_students, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val student = studentList[position]
        holder.firstName.setText(student.name)
        holder.surName.setText(student.surname)
        Picasso.get().load(student.photo).error(R.drawable.sova_anmation_3).into(holder.photo)

    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    inner class Holder : RecyclerView.ViewHolder, View.OnClickListener {
        var firstName: TextView
        var surName: TextView
        var photo: ImageView

        constructor(view: View) : super(view) {
            view.setOnClickListener(this)
            firstName = view.findViewById(R.id.tvHome7FirstName)
            surName = view.findViewById(R.id.tvHome7SurName)
            photo = view.findViewById(R.id.ivHome7photo)
        }


        override fun onClick(v: View?) {
            val intent = Intent(v!!.context, Home7EditActivity::class.java)
            intent.putExtra("EXIST", true)
            intent.putExtra("position", position)
            v.context.startActivity(intent)
        }
    }
}