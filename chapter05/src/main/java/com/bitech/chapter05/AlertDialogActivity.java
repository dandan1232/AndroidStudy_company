package com.bitech.chapter05;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlertDialogActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alert_dialog);
        Button btn_alert = findViewById(R.id.btn_alert);
        btn_alert.setOnClickListener(this);
        tv_alert = findViewById(R.id.tv_alert);
    }

    @Override
    public void onClick(View view) {
        //创建提醒对话框的建造器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("尊敬的用户");
        builder.setMessage("你要离开我了吗？");
        builder.setPositiveButton("残忍卸载", (dialog, which) -> {
            tv_alert.setText("虽然 但是 再见");
        });


        builder.setNegativeButton("我再想想", (dialog, which) -> {
            tv_alert.setText("一直在");

        });

        //根据建造器构建提醒对话框对象
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}