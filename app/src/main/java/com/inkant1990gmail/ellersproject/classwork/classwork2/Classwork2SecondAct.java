package com.inkant1990gmail.ellersproject.classwork.classwork2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.inkant1990gmail.ellersproject.R;
import com.squareup.picasso.Picasso;

public class Classwork2SecondAct extends AppCompatActivity {
    private static final String EXTRA_USER_NAME = "EXTRA_USER_NAME";
    private static final String EXTRA_USER_PASSWORD = "EXTRA_USER_PASSWORD";
    private ImageView imsce1;
    private MyView myView;

    public static void show(String username, String password, Activity activity) {
        Intent intent = new Intent(activity, Classwork2SecondAct.class);
        intent.putExtra(Classwork2SecondAct.EXTRA_USER_NAME, String.valueOf(username));
        intent.putExtra(Classwork2SecondAct.EXTRA_USER_PASSWORD, String.valueOf(password));
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2second);
        imsce1 = findViewById(R.id.imCel1);
        ConstraintLayout la = findViewById(R.id.grw);
        Picasso.get().load("http://3.bp.blogspot.com/-oVx_Nta8L2s/Vki1hfH6oDI/AAAAAAAACfo/WmEFTCQrv3U/s1600/Daggett.jpg").resize(1500, 2300).into(imsce1);
        myView = findViewById(R.id.myviev);
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Intent intent = getIntent();
        String username = intent.getStringExtra(EXTRA_USER_NAME);
        String password = intent.getStringExtra(EXTRA_USER_PASSWORD);
        TextView textView = findViewById(R.id.pasu);
        textView.setText(username + " " + password);

    }
}
