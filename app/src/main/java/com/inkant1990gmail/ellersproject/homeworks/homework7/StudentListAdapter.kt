package com.inkant1990gmail.ellersproject.homeworks.homework7

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.inkant1990gmail.ellersproject.R
import com.squareup.picasso.Picasso

class StudentListAdapter(var mTwoPane: Boolean, var activity: MainFragment) : RecyclerView.Adapter<StudentListAdapter.Holder>() {
    var studentList: List<Student> = emptyList()
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

    inner class Holder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var firstName: TextView
        var surName: TextView
        var photo: ImageView

        init {
            view.setOnClickListener(this)
            firstName = view.findViewById(R.id.tvHome7FirstName)
            surName = view.findViewById(R.id.tvHome7SurName)
            photo = view.findViewById(R.id.ivHome7photo)
        }


        override fun onClick(v: View?) {
            val bundle: Bundle = Bundle()
            bundle.putInt("position", position)
            bundle.putBoolean("EXIST", true)
            bundle.putBoolean("mTwoPane", mTwoPane)
            val fragment = StudentDetailFragment.getInstance()
            fragment.arguments = bundle
            if (mTwoPane) {
                fragment.setArguments(bundle)
                activity.fragmentManager!!.beginTransaction().replace(R.id.hm7studentDetailConteiner, fragment).addToBackStack(null).commit()
            } else {
                fragment.setArguments(bundle)
                activity.fragmentManager!!.beginTransaction().replace(R.id.hm7MainContainer, fragment).commit()
            }
        }
    }
}