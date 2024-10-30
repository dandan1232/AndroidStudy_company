package com.bitech.chapter06.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author 念安
 * @create 2024-10-30 14:20
 * @desc
 **/
public class ToastUtil {

    public static void show(Context ctx, String desc) {
        Toast.makeText(ctx,desc,Toast.LENGTH_SHORT).show();
    }
}
