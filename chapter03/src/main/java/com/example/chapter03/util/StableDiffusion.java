package com.example.chapter03.util;

import android.graphics.Bitmap;

/**
 * @author 念安
 * @create 2024-08-26 11:01
 * @desc  StableDiffusion JNI 类
 **/

public class StableDiffusion {

    // Load the native library
    static {
        System.loadLibrary("yourlibraryname");
    }

    // Native methods
    public native long initModel(String paramPath, String binPath);
    public native Bitmap generateImage(long modelPointer, String textInput);

}
