package com.bitech.chapter06.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.bitech.chapter06.enity.BookInfo;

import java.util.List;

/**
 * @author 念安
 * @create 2024-11-12 14:22
 * @desc
 **/
public interface BookDao {

    @Insert
    void insert(BookInfo... book);

    @Delete
    void delete(BookInfo... book);

    //删除所有书籍信息
    @Query("DELETE FROM BookInfo")
    void deleteAll();

    @Update
    int update(BookInfo... book);

    //加载所有书籍信息
    @Query("SELECT * FROM BookInfo")
    List<BookInfo> queryAll();

    // 根据名字加载书籍
    @Query("SELECT * FROM BookInfo WHERE name = :name ORDER BY id DESC limit 1")
    BookInfo queryByName(String name);
}
