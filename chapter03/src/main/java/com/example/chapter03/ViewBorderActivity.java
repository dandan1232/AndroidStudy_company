package com.example.chapter03;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chapter03.util.Utils;

public class ViewBorderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_border);
        TextView tv_code=findViewById(R.id.tv_code);
        //获取tv_code的布局参数（含宽度和高度）
        ViewGroup.LayoutParams params=tv_code.getLayoutParams();
        //修改布局参数中的宽度数值，注意默认px单位，需要把dp数值转成px数值
        params.width = Utils.dip2px(this, 300);
        //设置tv_code的布局参数
        tv_code.setLayoutParams(params);


    }
}