package com.bitech.chapter05;

import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TimePickerActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private TimePicker tp_time;
    private TextView tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_time_picker);
        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_time).setOnClickListener(this);
        tp_time = findViewById(R.id.tp_time);
        tp_time.setIs24HourView(true);
        tv_time = findViewById(R.id.tv_time);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_ok) {
            String desc = String.format("您选择的时间是%d时%d分", tp_time.getHour(), tp_time.getMinute());
            tv_time.setText(desc);

        } else if (view.getId() == R.id.btn_time) {
            //获取日历的一个实例，里面包含了当前的时分秒
            Calendar calendar = Calendar.getInstance();
            TimePickerDialog dialog = new TimePickerDialog(this, this,
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true);
            dialog.show();
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourofDay, int minute) {
        String desc = String.format("您选择的时间是%d时%d分", hourofDay, minute);
        tv_time.setText(desc);

    }
}