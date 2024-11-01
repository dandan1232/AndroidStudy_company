package com.bitech.chapter06;

import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MyApplication extends Application {


    //在App启动时调用
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ldd", "MyApplication onCreate");
    }



    //在APP终止时调用
    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d("ldd", "onTerminate");
    }

    //在配置改变时调用，列如从竖屏变为横屏

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("ldd", "onConfigurationChanged");
    }
}