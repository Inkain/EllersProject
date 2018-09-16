package com.inkant1990gmail.ellersproject;

import com.squareup.leakcanary.LeakCanary;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
            LeakCanary.install(this);
    }
}
