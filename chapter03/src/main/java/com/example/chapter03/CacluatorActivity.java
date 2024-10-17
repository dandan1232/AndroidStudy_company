package com.example.chapter03;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CacluatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_result;
    //第一个操作数
    private String firstNum = "";
    //第二个操作数
    private String secondNum = "";
    //结果
    private String result = "";
    //显示文本内容
    private String showText = "";

    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cacluator);
        tv_result = findViewById(R.id.tv_result);

        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_drive).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_reciprocal).setOnClickListener(this);
        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
        findViewById(R.id.ib_sqrt).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String inputText;
        //开根号按钮
        if (v.getId() == R.id.ib_sqrt) {
            inputText="√";
        } else {
            inputText = ((TextView) v).getText().toString();
        }
        if (v.getId() == R.id.btn_clear) {
            clear();
        } else if (v.getId() == R.id.btn_cancel) {

        } else if (v.getId() == R.id.btn_plus) {
            operator = inputText;
            refreshText(showText + operator);
        } else if (v.getId() == R.id.btn_minus) {
            operator = inputText;
            refreshText(showText + operator);

        } else if (v.getId() == R.id.btn_multiply) {
            operator = inputText;
            refreshText(showText + operator);

        } else if (v.getId() == R.id.btn_drive) {
            operator = inputText;
            refreshText(showText + operator);

        } else if (v.getId() == R.id.btn_equal) { //等号
            double caculate_result = calcuateFour();
            refreshOperate(String.valueOf(caculate_result));
            refreshText(showText + "=" + result);
        }else if(v.getId()==R.id.ib_sqrt){
            double sqrt_result = Math.sqrt(Double.parseDouble(firstNum));
            refreshOperate(String.valueOf(sqrt_result));
            refreshText(showText + "√=" + result);
        }
        else if (v.getId() == R.id.btn_reciprocal) {
            double reciprocal_result = 1.0 / Double.parseDouble(firstNum);
            refreshOperate(String.valueOf(reciprocal_result));
            refreshText(showText + "/=" + result);

        } else {
            //点击了其他按钮，数字、小数点
            //上次的运算结果已经出来了
            if (result.length() > 0 && operator.equals("")) {
                clear();
            }
            //无运算符，则继续拼接第一个操作数
            if (operator.equals("")) {
                firstNum = firstNum + inputText;
            } else {
                secondNum = secondNum + inputText;
            }
            if (showText.equals("0") && !inputText.equals(".")) {
                refreshText(inputText);
            } else {
                refreshText(showText + inputText);
            }

        }


    }

    private double calcuateFour() {
        switch (operator) {
            case "+":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case "-":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            case "×":
                return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
            default:
                return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
        }
    }

    private void clear() {
        refreshOperate("");
        refreshText("");
    }


    //刷新运算结果
    private void refreshOperate(String new_result) {
        result = new_result;
        firstNum = result;
        secondNum = "";
        operator = "";
    }


    //刷新文本显示
    private void refreshText(String text) {
        showText = text;
        tv_result.setText(showText);
    }
}