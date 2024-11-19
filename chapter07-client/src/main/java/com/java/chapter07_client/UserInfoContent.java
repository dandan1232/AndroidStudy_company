package com.java.chapter07_client;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author 念安
 * @create 2024-11-19 13:38
 * @desc
 **/
public class UserInfoContent implements BaseColumns {
    public static final String AUTHORITIES="com.java.chapter07_server.provider.UserInfoProvider";

    //content://com.java.chapter07_server.provider.UserInfoProvider/user

    //访问内容提供器的URI
    public static final Uri CONTENT_URI=Uri.parse("content://"+AUTHORITIES+"/user");

    //下面是该表的各个字段名称
    public static final String USER_NAME="name";
    public static final String USER_AGE="age";
    public static final String USER_Height="height";
    public static final String USER_WEIGHT="weight";
    public static final String USER_MARRIED="married";
}
