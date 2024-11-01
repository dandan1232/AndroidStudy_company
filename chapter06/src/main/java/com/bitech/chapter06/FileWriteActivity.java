package com.bitech.chapter06;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bitech.chapter06.enity.FileUtil;
import com.bitech.chapter06.util.ToastUtil;

import java.io.File;

public class FileWriteActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView et_name;
    private TextView et_age;
    private TextView et_height;
    private TextView et_weight;
    private CheckBox ck_married;
    private String path;
    private TextView tv_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_file_write);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        ck_married = findViewById(R.id.ck_married);

        findViewById(R.id.btn_save).setOnClickListener(this);
        findViewById(R.id.btn_read).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_save) {
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String height = et_height.getText().toString();
            String weight = et_weight.getText().toString();

            StringBuffer sb = new StringBuffer();
            sb.append("姓名").append(name);
            sb.append("\n年龄").append(age);
            sb.append("\n身高").append(height);
            sb.append("\n体重").append(weight);
            sb.append("\n婚否").append(ck_married.isChecked() ? "是" : "否");

            String fileName = System.currentTimeMillis() + ".txt";
            String directory = null;
            // 外部存储的私有空间
            directory = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString();
            // 外部存储的公共空间
            //directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();

            // 内部存储私有空间
            directory = getFilesDir().toString();
            path = directory + File.separatorChar + fileName;
            Log.d("ldddddd", path);
            FileUtil.saveText(path, sb.toString());
            ToastUtil.show(this, "保存成功");

        } else if (view.getId() == R.id.btn_read) {
            tv_txt.setText(FileUtil.openText(path));
        }
    }
}