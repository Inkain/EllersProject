package com.inkant1990gmail.ellersproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.inkant1990gmail.ellersproject.homeworks.homework1.Home1Activity;
import com.inkant1990gmail.ellersproject.homeworks.homework2.Home2Activity;
import com.inkant1990gmail.ellersproject.homeworks.homework3.Home3MainActivity;
import com.inkant1990gmail.ellersproject.homeworks.homework4.Home4MainActivity;
import com.inkant1990gmail.ellersproject.homeworks.homework5.Home5MainActivity;
import com.inkant1990gmail.ellersproject.homeworks.homework6.Home6MainActivity;
import com.inkant1990gmail.ellersproject.homeworks.homework7.Home7MainActivity;
import com.inkant1990gmail.ellersproject.homeworks.homework7.Home7Student;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        Log.v("myLogs","start");
    }


    public void toHome(View view) {
        switch (view.getId()) {
            case R.id.home1: {
                Intent intent = new Intent(this, Home1Activity.class);
                startActivity(intent);
                break;
            }
            case R.id.home2: {
                Intent intent = new Intent(this, Home2Activity.class);
                startActivity(intent);
                break;
            }
            case R.id.home3: {
                Intent intent = new Intent(this, Home3MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.home4: {
                Intent intent = new Intent(this, Home4MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.home5: {
                Intent intent = new Intent(this, Home5MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.home6: {
                Intent intent = new Intent(this, Home6MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.home7: {
                Intent intent = new Intent(this, Home7MainActivity.class);
                startActivity(intent);
                break;

            }

        }

    }

}
