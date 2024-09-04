package com.example.chapter03;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImageScaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_scale);
        ImageView iv_scale=findViewById(R.id.iv_scale);
        iv_scale.setImageResource(R.drawable.cat);
        iv_scale.setScaleType(ImageView.ScaleType.CENTER);


    }
}