package com.inkant1990gmail.ellersproject.homeworks.homework5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.util.*

class Home5ClockView : View {
    private var clockPaint = Paint()
    private var linePaint = Paint()
    private var textPaint = Paint()
    private var hoursPaint = Paint()
    private var minutePaint = Paint()
    private var secondPaint = Paint()
    var minute: Int = 0

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

    private fun init() {
        clockPaint.setColor(Color.YELLOW)
        linePaint.setColor(Color.RED)
        linePaint.setStrokeWidth(10f)
        linePaint.setAntiAlias(true)
        textPaint.setColor(Color.GREEN)
        textPaint.setTextSize(50f)
        hoursPaint.setColor(Color.BLACK)
        hoursPaint.setStrokeWidth(20f)
        minutePaint.setColor(Color.BLUE)
        minutePaint.setStrokeWidth(5f)
        secondPaint.setColor(Color.DKGRAY)
    }

    fun clockrun() {

        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var hours: Int = 3
        val radius = (Math.min(width/2, height/2) /1.47).toFloat()
        canvas!!.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, clockPaint)
        val xline = (width / 2).toFloat()
        val s = height / 2 - radius
        val yStartLine = s * 1.05f
        val yEndLine = s * 0.96f
        val step = 360 / 12f
        val textStep = 360 / 4f - 0.9f
        val minuteStep = 360 / 60f
        val calendar = Calendar.getInstance()


        canvas.save()
        for (i in 0..11) {
            canvas.drawLine(xline, yStartLine, xline, yEndLine, linePaint)
            canvas.rotate(step, (width / 2).toFloat(), (height / 2).toFloat())
        }
        canvas.restore()
        canvas.save()
        for (i in 0..3) {

            canvas.rotate(textStep, (width / 2).toFloat(), (height / 2).toFloat())
            if (hours.toString().length > 1) canvas.drawText(hours.toString(), xline - 6f, yEndLine + 60f, textPaint)
            else canvas.drawText(hours.toString(), xline - 2f, yEndLine + 60f, textPaint)
            hours += 3
        }
        canvas.restore()

        val hour = calendar.get(Calendar.HOUR)
        canvas.save()
        canvas.rotate(step * hour + step / 60 * calendar.get(Calendar.MINUTE), (width / 2).toFloat(), (height / 2).toFloat())
        canvas.drawLine(xline, (height / 2).toFloat(), xline, height / 2 - radius / 1.6f, hoursPaint)
        canvas.restore()
        minute = calendar.get(Calendar.MINUTE)
        canvas.save()
        canvas.rotate(minuteStep * minute, (width / 2).toFloat(), (height / 2).toFloat())
        canvas.drawLine(xline, (height / 2).toFloat(), xline, height / 2 - radius / 1.6f, minutePaint)
        canvas.restore()

        canvas.save()
        canvas.rotate(minuteStep * calendar.get(Calendar.SECOND), (width / 2).toFloat(), (height / 2).toFloat())
        canvas.drawLine(xline, (height / 2).toFloat(), xline, height / 2 - radius / 1.6f, secondPaint)
        canvas.restore()


    }
}