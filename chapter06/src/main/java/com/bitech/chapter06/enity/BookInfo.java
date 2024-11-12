package com.bitech.chapter06.enity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author 念安
 * @create 2024-11-04 16:09
 * @desc 书籍信息
 **/

@Entity
public class BookInfo {


    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;//书籍姓名
    private String author;//作者
    private String press;//出版社
    private double price;//价格

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "BookInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", price=" + price +
                '}';
    }
}
 