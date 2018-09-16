package com.inkant1990gmail.ellersproject.classwork.classwork2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inkant1990gmail.ellersproject.R;

public class Classwork2MainAct extends Activity {
    private EditText etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2main);
        Button log = findViewById(R.id.btLog);
        etUsername=findViewById(R.id.etName);
        etPassword=findViewById(R.id.etPass);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startsecondactivity();
            }
        });

    }

    private void startsecondactivity(){
        if (TextUtils.isEmpty((etUsername.getText()))|| TextUtils.isEmpty((etPassword.getText()))){
            Toast.makeText(this,"no pass or log",Toast.LENGTH_LONG).show();
        return;
        }
        Classwork2SecondAct.show(String.valueOf(etUsername.getText()),String.valueOf(etPassword.getText()),this);

        Log.v("TAGS","HELLW");
    }

    public void loggoClick(View view) {
    }
}
