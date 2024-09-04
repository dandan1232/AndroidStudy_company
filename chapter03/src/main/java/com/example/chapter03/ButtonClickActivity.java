package com.example.chapter03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chapter03.util.DateUtil;

public class ButtonClickActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);
        tv_result = findViewById(R.id.tv_result);
        Button btn_click_single = findViewById(R.id.btn_click_single);
        btn_click_single.setOnClickListener(new MyOnclickLinstener(tv_result));

        Button btn_click_public = findViewById(R.id.btn_click_public);
        btn_click_public.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_click_public) {
            String desc = String.format("%s 您点击了按钮: %s", DateUtil.getNowTime(), ((Button) v).getText());
            tv_result.setText(desc);
        }
    }

    static class MyOnclickLinstener implements View.OnClickListener {
        public final TextView tv_result;

        public MyOnclickLinstener(TextView tv_result) {
            this.tv_result = tv_result;
        }

        @Override
        public void onClick(View v) {
            String desc = String.format("%s 您点击了按钮: %s", DateUtil.getNowTime(), ((Button) v).getText());
            tv_result.setText(desc);

        }
    }
}