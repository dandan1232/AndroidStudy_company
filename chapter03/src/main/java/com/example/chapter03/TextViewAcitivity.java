package com.example.chapter03;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 念安
 * @create 2024-08-16 14:28
 * @desc
 **/
public class TextViewAcitivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        TextView tv_hello = findViewById(R.id.tv_hello);
        tv_hello.setText(R.string.hello);

    }
}
