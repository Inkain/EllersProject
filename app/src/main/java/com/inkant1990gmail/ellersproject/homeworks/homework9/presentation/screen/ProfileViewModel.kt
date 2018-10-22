package com.inkant1990gmail.ellersproject.homeworks.homework9.presentation.screen

import android.databinding.ObservableField
import android.view.View
import com.inkant1990gmail.ellersproject.homeworks.base.BaseViewModel

class ProfileViewModel : BaseViewModel<ProfileRouter>() {
    val fio = ObservableField<String>("no data")
    val age = ObservableField("0")
    val gender = ObservableField("women")
    val image = ObservableField<String>("no data")
    var gend = ObservableField<Boolean>(false)

    init {
        gender.set("man")
        if (gender.equals("man")) gend.set(true)
        fio.set("somethings")
        age.set("12")
        image.set("http://3.bp.blogspot.com/-oVx_Nta8L2s/Vki1hfH6oDI/AAAAAAAACfo/WmEFTCQrv3U/s1600/Daggett.jpg")
    }

    fun onClick(v: View) {
        if (gender.get().equals("man")) {
            gender.set("woman")
            gend.set(true)
        } else {
            gender.set("man")
            gend.set(false)

        }
    }
}