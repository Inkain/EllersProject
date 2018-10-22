package com.inkant1990gmail.ellersproject.homeworks.homework8.presentation.screen.timer


import android.arch.lifecycle.ViewModelProviders
import com.inkant1990gmail.ellersproject.R
import com.inkant1990gmail.ellersproject.databinding.ActivityTimerBinding
import com.inkant1990gmail.ellersproject.homeworks.base.BaseMvvmActivity


class TimerActivity : BaseMvvmActivity<TimerViewModel,
        ActivityTimerBinding, TimerRouter>() {
    override fun provideRouter(): TimerRouter {
        return TimerRouter(this)
    }

    override fun prodiveViewModel(): TimerViewModel {
        return ViewModelProviders.of(this)
            .get(TimerViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_timer


}