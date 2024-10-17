package com.bitech.chapter04;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bitech.chapter04.util.DateUtil;


public class ActSendActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_act_send);

        tv_send = findViewById(R.id.tv_send);
        findViewById(R.id.tv_send).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ActReceiveActivity.class);
        //创建一个新包裹
        Bundle bundle = new Bundle();
        bundle.putString("request_time", DateUtil.getNowTime());
        bundle.putString("request_content", tv_send.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}