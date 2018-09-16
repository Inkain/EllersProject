package com.inkant1990gmail.ellersproject.homeworks.homework4;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.inkant1990gmail.ellersproject.R;

public class Home4SecondActivity extends AppCompatActivity {
    private AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home4_second);
        ImageView home2sova = findViewById(R.id.imgHome4sova);
        home2sova.setBackgroundResource(R.drawable.sovaanimation);
        animation = (AnimationDrawable) home2sova.getBackground();

    }

    public void sovaControl(View view) {
        switch (view.getId()) {
            case R.id.btHome4StartAnim: {
                animation.start();
                Toast.makeText(this,"start",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.btHome4StopAnim: {
                animation.stop();
                Toast.makeText(this,"stop",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.btHome4toCircle: {
                Intent intent =new Intent(this,Home4ThirdActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
