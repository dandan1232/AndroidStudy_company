package com.java.chapter07_client.entity;

/**
 * @author 念安
 * @create 2024-11-19 14:03
 * @desc
 **/
public class User {

    public int id; // 序号
    public String name; // 姓名
    public int age; // 年龄
    public long height; // 身高
    public float weight; // 体重
    public boolean married; // 婚否

    public User(){

    }

    public User(String name, int age, long height, float weight, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.married = married;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", married=" + married +
                '}';
    }
}
