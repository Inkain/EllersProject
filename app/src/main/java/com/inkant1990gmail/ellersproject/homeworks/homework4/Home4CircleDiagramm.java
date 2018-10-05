package com.inkant1990gmail.ellersproject.homeworks.homework4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Home4CircleDiagramm extends View {
    private Paint paint, mTextPaint;
    private int[] colors = new int[3];
    private float[] values;
    private float sum;
    private RectF rectf;


    public Home4CircleDiagramm(Context context) {
        super(context);
        init();
    }

    public void init() {
        mTextPaint = new Paint();
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextSize(40f);
        mTextPaint.setColor(Color.BLACK);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(false);
        paint.setStyle(Paint.Style.FILL);
        rectf = new RectF(0, 0, 500, 500);
        colors[0] = Color.GREEN;
        colors[1] = Color.BLUE;
        colors[2] = Color.RED;
    }

    public Home4CircleDiagramm(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setValues(float[] values2) {
        values = new float[values2.length];
        values[0] = values2[0];
        values[1] = values2[1];
        values[2] = values2[2];
        sum = values[0] + values[1] + values[2];
    }

    public Home4CircleDiagramm(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Home4CircleDiagramm(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String text;
        float start = 0f, temp, tempT1;
        float startT = (((360.0f / sum) * values[0]) + ((360.0f / sum) * values[1]) + ((360.0f / sum) * values[2])) / 1.3f, tempT = startT + ((360.0f / sum) * values[2]) / 2;

        super.onDraw(canvas);
        for (int i = 0; i < values.length; i++) {
            paint.setColor(colors[i]);
            text = String.valueOf(values[i]);
            canvas.drawArc(rectf, start, temp = ((360.0f / sum) * values[i]), true, paint);
            tempT1 = startT + ((360.0f / sum) * values[values.length - i - 1]) / 2;
            if (tempT1 <= 150f) tempT = tempT1;
            Log.i("myLogs", tempT + "");
            canvas.drawText(text, startT, tempT, mTextPaint);
            startT = startT - ((360.0f / sum) * values[values.length - i - 1]) / 1.3f;
            start += temp;
        }
    }
}




