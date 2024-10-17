package com.bitech.chapter04;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ActionUriActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_action_uri);
        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
        findViewById(R.id.btn_my).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        String phoneNo = "10086";
        if (view.getId() == R.id.btn_dial) {
            //设置意图动作为准备拨号
            intent.setAction(Intent.ACTION_DIAL);
            Uri uri = Uri.parse("tel:" + phoneNo);
            intent.setData(uri);
            startActivity(intent);
        }else if (view.getId() == R.id.btn_sms) {
            //设置意图动作为准备拨号
            intent.setAction(Intent.ACTION_SENDTO);
            Uri uri2 = Uri.parse("smsto:" + phoneNo);
            intent.setData(uri2);
            startActivity(intent);
        }
        else if (view.getId() == R.id.btn_my) {
            intent.setAction("android.intent.action.NING");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            startActivity(intent);
        }
    }
}