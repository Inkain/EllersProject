package com.inkant1990gmail.ellersproject.homeworks.homework9.presentation.screen

import android.arch.lifecycle.ViewModelProviders
import com.inkant1990gmail.ellersproject.R
import com.inkant1990gmail.ellersproject.databinding.ActivityHome9ProfileBinding
import com.inkant1990gmail.ellersproject.homeworks.base.BaseMvvmActivity

class ProfileActivity : BaseMvvmActivity<ProfileViewModel, ActivityHome9ProfileBinding, ProfileRouter>() {
    override fun prodiveViewModel() = ViewModelProviders.of(this).get(ProfileViewModel::class.java)

    override fun provideLayoutId() = R.layout.activity_home9_profile

    override fun provideRouter() = ProfileRouter(this)
}