package com.inkant1990gmail.ellersproject.homeworks.homework8.presentation.screen.timer

import android.databinding.ObservableField
import com.inkant1990gmail.ellersproject.homeworks.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import java.util.concurrent.TimeUnit


class TimerViewModel : BaseViewModel<TimerRouter>() {

    val studentSize = ObservableField<String>("0")
    val disposable: Disposable = Disposables.empty()

    init {


        var disposable =
            Observable.interval(3, TimeUnit.SECONDS).timeInterval().observeOn(AndroidSchedulers.mainThread()).subscribe(
                { v -> if ((v.value() % 2).toInt() == 0) studentSize.set("" + v.value()) })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}