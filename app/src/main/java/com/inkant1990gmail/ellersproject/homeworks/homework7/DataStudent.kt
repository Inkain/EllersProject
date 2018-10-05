package com.inkant1990gmail.ellersproject.homeworks.homework7

import java.util.*

class DataStudent {
    private constructor()

    companion object {
        private var INSTANCE: DataStudent? = null
        fun setInstance(newINSTANCE: DataStudent) {
            if (INSTANCE == null) INSTANCE = newINSTANCE
        }

        fun getInstance(): DataStudent? {
            return INSTANCE
        }
    }

    lateinit var name: String
    var gender: Int = 0
    lateinit var date: Date
    var people: java.util.ArrayList<Student> = ArrayList<Student>()
}