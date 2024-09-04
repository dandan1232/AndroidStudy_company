package com.example.chapter03;

import static android.graphics.Color.BLUE;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter03.util.DateUtil;

public class ButtonEnableActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_test;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button_enable);
        Button btn_enable = findViewById(R.id.btn_enable);
        Button btn_disable = findViewById(R.id.btn_disable);
        Button btn_test = findViewById(R.id.btn_test);
        TextView tv_result = findViewById(R.id.tv_result);

        btn_enable.setOnClickListener(this);
        btn_disable.setOnClickListener(this);
        btn_test.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_enable) {
            btn_test.setEnabled(true);
            btn_test.setTextColor(BLUE);
        } else if (v.getId() == R.id.btn_disable) {
            btn_test.setEnabled(false);
            btn_test.setTextColor(Color.alpha(0xFF000000));
        } else {
            String desc = String.format("%s 您点击了按钮: %s", DateUtil.getNowTime(), ((Button) v).getText());
            tv_result.setText(desc);
        }

    }
}