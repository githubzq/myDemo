package com.swd.qing_zhou.zqandroiddemo;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.util.Log;

/**
 * Created by ZQ on 2017/7/26.
 */

public class DemoApplication extends Application{
    private static final String TAG = "DemoApplication";
    private static DemoApplication mDemoApplication = null;

    public static DemoApplication getInstance(){
        synchronized (DemoApplication.class){
            if(mDemoApplication == null){
                mDemoApplication = new DemoApplication();
            }
        }
        return mDemoApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppLifecycleCallback.init(this);
    }



    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.e(TAG, "onLowMemory:" );
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.e(TAG, "onTerminate: " );
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }

    @Override
    public String getPackageName() {
        return super.getPackageName();
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        return super.getApplicationInfo();
    }
}
