package com.bitech.chapter06.util;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * @author 念安
 * @create 2024-10-22 15:16
 * @desc
 **/
public class ViewUtil {
    public static void hideOneInputMethod(Activity act, View v) {
     //从系统服务中获取输入法管理器
        InputMethodManager imm=(InputMethodManager) act.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //关闭屏幕上的输入法
        imm.hideSoftInputFromWindow(v.getWindowToken(),0);
    }
}
