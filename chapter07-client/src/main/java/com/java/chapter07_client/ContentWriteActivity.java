package com.java.chapter07_client;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.java.chapter07_client.entity.User;
import com.java.chapter07_client.util.ToastUtil;

public class ContentWriteActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private CheckBox ck_married;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_content_write);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        ck_married = findViewById(R.id.ck_married);

        findViewById(R.id.btn_save).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        findViewById(R.id.btn_read).setOnClickListener(this);

    }

    @SuppressLint("Range")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_save) {
            ContentValues values = new ContentValues();
            values.put(UserInfoContent.USER_NAME, et_name.getText().toString());
            values.put(UserInfoContent.USER_AGE, Integer.parseInt(et_age.getText().toString()));
            values.put(UserInfoContent.USER_Height, Integer.parseInt(et_height.getText().toString()));
            values.put(UserInfoContent.USER_WEIGHT, Float.parseFloat(et_weight.getText().toString()));
            values.put(UserInfoContent.USER_MARRIED, ck_married.isChecked());
            getContentResolver().insert(UserInfoContent.CONTENT_URI, values);
            ToastUtil.show(this, "保存成功");
        }
        if (view.getId() == R.id.btn_delete) {

        }
        if (view.getId() == R.id.btn_read) {
            Cursor cursor = getContentResolver().query(UserInfoContent.CONTENT_URI, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    User info = new User();
                    info.id = cursor.getInt(cursor.getColumnIndex(UserInfoContent._ID));
                    info.name = cursor.getString(cursor.getColumnIndex(UserInfoContent.USER_NAME));
                    info.age = cursor.getInt(cursor.getColumnIndex(UserInfoContent.USER_AGE));
                    info.height = cursor.getInt(cursor.getColumnIndex(UserInfoContent.USER_Height));
                    info.weight = cursor.getFloat(cursor.getColumnIndex(UserInfoContent.USER_WEIGHT));
                    info.married = cursor.getInt(cursor.getColumnIndex(UserInfoContent.USER_MARRIED)) == 1 ? true : false;
                    Log.d("ldd", info.toString());

                }
                cursor.close();
            }
        }

    }
}