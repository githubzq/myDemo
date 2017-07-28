package com.swd.qing_zhou.zqandroiddemo;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import java.lang.reflect.Field;

public class Main3Activity extends AppCompatActivity {
    private static final String TAG = "Main3Activity";
    private int mTitleBgResId = -1;
    private View mStatusBarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TypedArray typedArray = getTheme().obtainStyledAttributes(new int[]{R.attr.gradeBg});
        mTitleBgResId = typedArray.getResourceId(R.styleable.AppTitle_gradeBg, -1);
        customizeActionBar();
//
//        addFakeStatusBarView();
        setContentView(R.layout.activity_main3);

    }

    private void customizeActionBar() {
        ActionBar baseActionBar = getSupportActionBar();
        if (baseActionBar != null) {
            baseActionBar.setHomeButtonEnabled(true);
            baseActionBar.setDisplayHomeAsUpEnabled(true);
            baseActionBar.setElevation(0);
            if (mTitleBgResId != -1) {
                Drawable drawable = getResources().getDrawable(mTitleBgResId);
                baseActionBar.setBackgroundDrawable(drawable);
            }
        }
    }

    protected void addFakeStatusBarView() {
        if (mTitleBgResId == -1) {
            return;
        }

        Window window = getWindow();
        ViewGroup decorView = (ViewGroup) window.getDecorView();

        if (mStatusBarView == null) {
            mStatusBarView = new View(this);
            Log.d(TAG, "addFakeStatusBarView, height:" + getStatusBarHeight());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight());
            layoutParams.gravity = Gravity.TOP;
            mStatusBarView.setLayoutParams(layoutParams);
            mStatusBarView.setBackgroundResource(mTitleBgResId);
        }

        if (decorView.indexOfChild(mStatusBarView) < 0) {
            decorView.addView(mStatusBarView);
        }

    }

    private int getStatusBarHeight() {

        int height = 0;
        try {
            Class c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            height = getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return height;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
