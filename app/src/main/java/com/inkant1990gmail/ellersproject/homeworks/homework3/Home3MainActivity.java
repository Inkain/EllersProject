package com.inkant1990gmail.ellersproject.homeworks.homework3;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.inkant1990gmail.ellersproject.R;
import com.squareup.picasso.Picasso;

public class Home3MainActivity extends AppCompatActivity {
    private EditText url;
    private ImageView image;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3_main);
        url = findViewById(R.id.etHW3n1);
        image = findViewById(R.id.imageHW3n1);
        context = getApplicationContext();
    }

    public void loadImage(View view) {
        Picasso.get().load(String.valueOf(url.getText()))
                .transform(new Home3CircleTransform())
                .placeholder(R.drawable.progress_animation)
                .into(image);
    }

}
