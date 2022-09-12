package com.creditscoreinfo.report.check;

import android.app.Application;

public class BaseApplication extends Application {


    public static String TAG = "TAG";
    public static BaseApplication application;

    public static BaseApplication getInstance() {
        if (application == null)
            application = new BaseApplication();
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    static {
        System.loadLibrary("native-lib");
    }
}
