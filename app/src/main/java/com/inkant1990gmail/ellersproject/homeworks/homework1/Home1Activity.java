package com.inkant1990gmail.ellersproject.homeworks.homework1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.inkant1990gmail.ellersproject.R;

public class Home1Activity extends Activity implements View.OnClickListener {
    private TextView tvRed, tvBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        tvRed = findViewById(R.id.tvRed);
        tvBlue = findViewById(R.id.tvBlue);
        tvBlue.setOnClickListener(this);
        tvRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable color = tvRed.getBackground();
                tvRed.setBackground(tvBlue.getBackground());
                tvBlue.setBackground(color);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Drawable color = tvBlue.getBackground();
        tvBlue.setBackground(tvRed.getBackground());
        tvRed.setBackground(color);
    }

    public void onClicks(View view) {
        CharSequence text = tvRed.getText();
        tvRed.setText(tvBlue.getText());
        tvBlue.setText(text);

    }

}
