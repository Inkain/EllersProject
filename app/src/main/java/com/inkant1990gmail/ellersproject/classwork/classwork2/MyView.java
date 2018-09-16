package com.inkant1990gmail.ellersproject.classwork.classwork2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Calendar;

public class MyView extends View {
        Paint circle,line;
        private OnMyViewClickListener listener;
        public MyView(Context context) {
            super(context);
            init();
        }

        private void init() {
            circle =new Paint();
            circle.setColor(Color.RED);
            line=new Paint();
            line.setColor(Color.BLACK);
            line.setAntiAlias(true);
            line.setStrokeWidth(10);
        }

        public MyView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);init();
        }

        public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);init();
        }


        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);init();
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            float radius = Math.min(getWidth(), getHeight()) / 2;
            canvas.drawCircle(getWidth()/2,getHeight()/2, radius,circle);
            float xline = getWidth()/2;
            float s = getHeight()/2 -radius;
            float yStartLine= s *0.9f;
            float yEndLine= s *1.1f;
            float step=360/12f;
            canvas.save();
            for (int i =0;i<12;i++){
                canvas.drawLine(xline,yStartLine,xline,yEndLine,line);
                canvas.rotate(step,getWidth()/2,getHeight()/2);

            }
            canvas.restore();
            Calendar calendar = Calendar.getInstance();
            int hour =calendar.get(Calendar.HOUR);
            canvas.save();

            canvas.rotate(step * hour + step / 60 * (calendar.get(Calendar.MINUTE)), getWidth() / 2, getHeight() / 2);
            canvas.drawLine(xline, getHeight() / 2, xline, getHeight() / 2 - radius / 2, line);
            canvas.restore();


        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                Log.v("myLogs","down");
                return true;
            }
            else if (event.getAction()==MotionEvent.ACTION_UP){
                Log.v("myLogs","up");
                if(listener!=null)listener.onclick();
                return true;
            }
            else if (event.getAction()==MotionEvent.ACTION_MOVE){
                Log.v("myLogs","move");
                return true;
            }
            return super.onTouchEvent(event);
        }

        interface  OnMyViewClickListener{
            void  onclick();
        }

    }
