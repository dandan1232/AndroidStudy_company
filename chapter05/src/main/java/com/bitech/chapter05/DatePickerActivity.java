package com.bitech.chapter05;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DatePickerActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private DatePicker dp_date;
    private TextView tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_date_picker);
        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_date).setOnClickListener(this);
        tv_date = findViewById(R.id.tv_date);
        dp_date = findViewById(R.id.dp_date);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_ok) {
            String desc = String.format("您选择的日期是%d年%d月%d日", dp_date.getYear(), dp_date.getMonth() + 1, dp_date.getDayOfMonth());
            tv_date.setText(desc);
        } else if (view.getId() == R.id.btn_date) {
/*            //获取日历的一个实例，里面包含了当前的年月日
            Calendar calendar = Calendar.getInstance();
            calendar.get(Calendar.YEAR);
            calendar.get(Calendar.MONDAY);
            calendar.get(Calendar.DAY_OF_MONTH);*/
            DatePickerDialog dialog = new DatePickerDialog(this, this, 2090, 11, 8);
            //显示日期对话框
            dialog.show();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayofMonth) {
        String desc = String.format("您选择的日期是%d年%d月%d日", year, month + 1, dayofMonth);
        tv_date.setText(desc);

    }
}