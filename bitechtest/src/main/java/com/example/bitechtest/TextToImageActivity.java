package com.example.bitechtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TextToImageActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native_inference");  // Load the native library
    }

    // Native methods
    private native float[] generateEmbeddingsNative(String text);
    private native byte[] generateImageFromTextNative(float[] embeddings);

    private ImageView imageView;
    private EditText inputEditText;
    private Button sendButton;
    private ProgressBar loadingSpinner;
    private LinearLayout recordList;
    private ImageView listIcon;
    private RelativeLayout leftLayout;

    private static final int REQUEST_CODE = 100; // Request code for runtime permissions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_image);

        // Request permissions
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
        }

        // Get views
        imageView = findViewById(R.id.image_view);
        inputEditText = findViewById(R.id.input_edit_text);
        sendButton = findViewById(R.id.send_button);
        loadingSpinner = findViewById(R.id.loading_spinner);
        recordList = findViewById(R.id.record_list);
        listIcon = findViewById(R.id.list_icon);
        leftLayout = findViewById(R.id.left_layout);

        // Set up button click event
        sendButton.setOnClickListener(view -> {
            String userInput = inputEditText.getText().toString();
            if (!userInput.isEmpty()) {
                loadingSpinner.setVisibility(View.VISIBLE);
                new GenerateImageTask().execute(userInput);
            } else {
                Toast.makeText(this, "请输入文本描述", Toast.LENGTH_SHORT).show();
            }
        });

        // Set up icon click event
        listIcon.setOnClickListener(view -> {
            if (leftLayout.getVisibility() == View.VISIBLE) {
                leftLayout.setVisibility(View.GONE);
                listIcon.setImageResource(R.drawable.list);  // Icon for expanded
            } else {
                leftLayout.setVisibility(View.VISIBLE);
                listIcon.setImageResource(R.drawable.list);  // Icon for collapsed
            }
        });
    }

    private class GenerateImageTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            String input = params[0];
            try {
                // Call native methods
                float[] embeddings = generateEmbeddingsNative(input);
                if (embeddings == null) {
                    return null;
                }
                byte[] imageData = generateImageFromTextNative(embeddings);
                if (imageData == null) {
                    Log.i("ImageData", "Image data length: " + imageData.length);
                    for (int i = 0; i < Math.min(imageData.length, 100); i++) {
                        Log.i("ImageData", "Byte " + i + ": " + (imageData[i] & 0xFF));
                    }
                    return null;
                }

                // Use a ByteArrayInputStream to decode the image data in chunks
                InputStream imageStream = new ByteArrayInputStream(imageData);
                Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
                if (bitmap == null) {
                    Log.e("BitmapError", "BitmapFactory.decodeStream returned null");
                } else {
                    Log.i("BitmapSuccess", "Bitmap generated successfully");
                }

                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(Bitmap generatedImage) {
            loadingSpinner.setVisibility(View.GONE);
            if (generatedImage != null) {
                imageView.setImageBitmap(generatedImage);
                addRecordToList(inputEditText.getText().toString(), generatedImage);
            } else {
                Toast.makeText(TextToImageActivity.this, "图像生成失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void addRecordToList(String description, Bitmap image) {
        LinearLayout newRecord = new LinearLayout(this);
        newRecord.setOrientation(LinearLayout.HORIZONTAL);
        newRecord.setPadding(5, 5, 5, 5);

        ImageView recordImage = new ImageView(this);
        recordImage.setImageBitmap(image);
        recordImage.setLayoutParams(new LinearLayout.LayoutParams(100, 100));

        TextView recordText = new TextView(this);
        recordText.setText(description);
        recordText.setTextColor(Color.BLACK);
        recordText.setPadding(10, 0, 0, 0);

        newRecord.addView(recordImage);
        newRecord.addView(recordText);
        recordList.addView(newRecord);
    }

    private void copyAssetToFile(String assetName, File destination) throws IOException {
        InputStream in = getAssets().open(assetName);
        FileOutputStream out = new FileOutputStream(destination);

        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }

        in.close();
        out.close();
    }


}
