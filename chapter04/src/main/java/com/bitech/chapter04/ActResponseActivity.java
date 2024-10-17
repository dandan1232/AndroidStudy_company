package com.bitech.chapter04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bitech.chapter04.util.DateUtil;

public class ActResponseActivity extends AppCompatActivity  implements View.OnClickListener{

    private static final String mReponse = "我还没睡，我爸妈不在家。";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_act_response);
        TextView tv_request = findViewById(R.id.tv_request);
        //从上一个页面传来的意图中获取快递包裹
        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request_time");
        String request_content = bundle.getString("request_content");
        String desc = String.format("收到请求消息:\n请求时间为%s\n请求内容为%s", request_time, request_content);
        tv_request.setText(desc);

        findViewById(R.id.btn_response).setOnClickListener(this);
        TextView tv_response= findViewById(R.id.tv_response);
        tv_response.setText("待返回的消息为:" + mReponse);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("request_time", DateUtil.getNowTime());
        bundle.putString("request_content", mReponse);
        intent.putExtras(bundle);
        //携带意图返回上一个页面。RESULT_OK表示处理成功
        setResult(Activity.RESULT_OK,intent);
        finish();

    }
}