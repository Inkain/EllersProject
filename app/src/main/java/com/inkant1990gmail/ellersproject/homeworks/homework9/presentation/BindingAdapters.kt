package com.inkant1990gmail.ellersproject.homeworks.homework9.presentation

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.inkant1990gmail.ellersproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home4_second.view.*

        @BindingAdapter("android:src")
        fun loadImage(view: ImageView, url: String) {
            Picasso.get().load(url).error(R.drawable.sova_anmation_3).into(view)
        }



