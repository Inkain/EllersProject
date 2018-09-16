package com.inkant1990gmail.ellersproject.homeworks.homework5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

class Home5ViewIndicator : View {
    private var indicatorPaint = Paint()
    var state: Boolean = false

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init()
    }

    fun wificheck(boolean: Boolean) {
      state=boolean
      if (state)indicatorPaint.setColor(Color.GREEN)
        else indicatorPaint.setColor(Color.RED)
    invalidate()
    }

    private fun init() {
        this.indicatorPaint.setColor(Color.RED)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val radius = (Math.min(width, height) / 2).toFloat()
        canvas!!.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, indicatorPaint)
    }
}