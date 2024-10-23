package com.bitech.chapter05;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bitech.chapter05.util.ViewUtil;

public class EditHideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_hide);
        EditText et_phone = findViewById(R.id.et_phone);
        EditText et_password = findViewById(R.id.et_password);

        et_phone.addTextChangedListener(new HideTexztWatcher(et_phone, 11));
        et_password.addTextChangedListener(new HideTexztWatcher(et_password, 6));
    }

    private class HideTexztWatcher implements TextWatcher {
        //声明一个编辑框对象
        private EditText mView;
        private int mMaxLength;

        public HideTexztWatcher(EditText v, int maxLength) {
            this.mView = v;
            this.mMaxLength = maxLength;

        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        //在编辑框的输入文本变化后触发
        @Override
        public void afterTextChanged(Editable s) {
            //获得已输入的文本字符串
            String str = s.toString();
            //输入文本达到11位（如手机号码），或者达到6位（如密码）时，隐藏输入内容
            if (str.length()==mMaxLength){
                //隐藏输入法软键盘
                ViewUtil.hideOneInputMethod(EditHideActivity.this,mView);
            }


        }
    }
}