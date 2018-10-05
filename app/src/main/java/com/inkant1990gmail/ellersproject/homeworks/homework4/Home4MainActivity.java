package com.inkant1990gmail.ellersproject.homeworks.homework4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.inkant1990gmail.ellersproject.R;

public class Home4MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home4_main);

    }

    public void swap(View view) {
        Intent intent = new Intent(this, Home4SecondActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.start_anim1, R.anim.end_anim1);
    }
}
