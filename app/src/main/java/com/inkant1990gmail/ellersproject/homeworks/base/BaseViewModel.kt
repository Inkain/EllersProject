package com.inkant1990gmail.ellersproject.homeworks.base

import android.arch.lifecycle.ViewModel
import inkant1990.com.newhomes.homework8.presentation.router.BaseRouter

abstract class BaseViewModel<R: BaseRouter<*>> : ViewModel() {
    protected var router:R?=null

     fun addRouter(router:R){
         this.router=router
     }
    fun removeRouter(){
        this.router=null
    }


}