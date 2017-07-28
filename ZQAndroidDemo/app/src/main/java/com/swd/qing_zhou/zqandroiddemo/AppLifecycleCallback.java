package com.swd.qing_zhou.zqandroiddemo;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ZQ on 2017/7/26.
 */

public class AppLifecycleCallback implements ActivityLifecycleCallbacks{
    private static final String TAG = "AppLifecycleCallback";
    public static AppLifecycleCallback mCallback;
    private Application mApplication;

    private AppLifecycleCallback(Application application){
        this.mApplication = application;
        mApplication.registerActivityLifecycleCallbacks(this);

    }

    public static void init(Application application){
        mCallback = new AppLifecycleCallback(application);
    }

    public AppLifecycleCallback getInstance(){
        return mCallback;
    }
    
    
    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.d(TAG,"onActivityCreated:");

    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.d(TAG, "onActivityStarted: ");

    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.d(TAG, "onActivityResumed: ");

    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.d(TAG, "onActivityPaused: ");

    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.d(TAG, "onActivityStopped: ");

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Log.d(TAG, "onActivitySaveInstanceState: ");

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.d(TAG, "onActivityDestroyed: ");

    }
}
