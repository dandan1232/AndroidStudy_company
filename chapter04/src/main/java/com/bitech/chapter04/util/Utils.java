package com.bitech.chapter04.util;

import android.content.Context;

/**
 * @author 念安
 * @create 2024-08-19 14:38
 * @desc
 **/
public class Utils {
    public static int dip2px(Context context, float dpValue){
        //获取当前手机的像素密度（1个dp对应几个px）
        float scale = context.getResources().getDisplayMetrics().density;
       return (int)(dpValue*scale+0.5f);
    }
}
