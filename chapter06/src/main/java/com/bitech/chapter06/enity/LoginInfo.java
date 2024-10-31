package com.bitech.chapter06.enity;

/**
 * @author 念安
 * @create 2024-10-31 13:47
 * @desc
 **/
public class LoginInfo {

    public int id;
    public String phone;
    public String password;
    public boolean remember = false;


    public LoginInfo() {

    }

    public LoginInfo(String phone, String password, boolean remember) {
        this.phone = phone;
        this.password = password;
        this.remember = remember;

    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", remember=" + remember +
                '}';
    }
}
