package com.example.bitechtest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 念安
 * @create 2024-08-20 10:41
 * @desc 获取当前时间
 **/
public class DateUtil {
    public static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }
}
