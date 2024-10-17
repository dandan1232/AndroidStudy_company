package com.example.chapter03;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TextColorActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_color);
        //布局文件中获取名叫tv_code_system的文本视图
        TextView tv_code_system=findViewById(R.id.tv_code_system);
        //将tv_code_system设置成系统自带的绿色
        tv_code_system.setTextColor(Color.GREEN);

        //布局文件中获取名叫tv_code_eight的文本视图
        TextView tv_code_eight=findViewById(R.id.tv_code_eight);
        //将tv_code_eight设置成不透明的的绿色
        tv_code_eight.setTextColor(0xff00ff00);


        //布局文件中获取名叫tv_code_six的文本视图
        TextView tv_code_six=findViewById(R.id.tv_code_six);
        //将tv_code_six设置成透明的绿色，就是看不到的绿色
        tv_code_six.setTextColor(0x00ff00);

        //从布局文件中获取名叫tv_code_background的文本视图
        TextView tv_code_background=findViewById(R.id.tv_code_background);
        //将tv_code_six设置成透明的绿色，就是看不到的绿色
//        tv_code_six.setBackgroundColor(Color.GREEN);
        //颜色来自于系统文件
        tv_code_background.setBackgroundColor(R.color.black);
    }
}