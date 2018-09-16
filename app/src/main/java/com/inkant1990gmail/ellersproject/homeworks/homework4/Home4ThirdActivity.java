package com.inkant1990gmail.ellersproject.homeworks.homework4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.inkant1990gmail.ellersproject.R;

public class Home4ThirdActivity extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home4_third);
        float[] values = new float[3];
        values[0] = 5f;
        values[1] = 5f;
        values[2] = 10f;
        linearLayout =findViewById(R.id.linearhome4);
        Home4CircleDiagramm dia = new Home4CircleDiagramm(this);
        dia.setValues(values);
        linearLayout.addView(dia);
    }

}
