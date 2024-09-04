package com.example.bitechtest.util;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * @author 念安
 * @create 2024-08-26 11:01
 * @desc  将 Stable Diffusion 模型转换为 TFLite 或 ONNX 格式，使用 Llama3 生成的文本嵌入作为输入，传递给 Stable Diffusion 模型，生成图像。
 **/

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class StableDiffusionProcessor {

    private Interpreter stableDiffusionInterpreter;

    public StableDiffusionProcessor(AssetManager assetManager, String modelPath) throws IOException {
        stableDiffusionInterpreter = new Interpreter(loadModelFile(assetManager, modelPath));
    }

    private MappedByteBuffer loadModelFile(AssetManager assetManager, String modelPath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(assetManager.openFd(modelPath).getFileDescriptor());
        FileChannel fileChannel = fileInputStream.getChannel();
        long startOffset = assetManager.openFd(modelPath).getStartOffset();
        long declaredLength = assetManager.openFd(modelPath).getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    public Bitmap generateImageFromEmbeddings(float[] embeddings) {
        int imageSize = 512;  // 假设生成的图像大小为 512x512
        float[][] embeddingsTensor = new float[1][embeddings.length];
        embeddingsTensor[0] = embeddings;

        // 定义输出张量的形状
        float[][][] outputTensor = new float[1][imageSize][imageSize];

        // 执行推理生成图像
        stableDiffusionInterpreter.run(embeddingsTensor, outputTensor);

        return convertToBitmap(outputTensor[0]);
    }

    private Bitmap convertToBitmap(float[][] imageArray) {
        int width = imageArray.length;
        int height = imageArray[0].length;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixelValue = (int)(imageArray[i][j] * 255);
                bitmap.setPixel(i, j, Color.rgb(pixelValue, pixelValue, pixelValue));
            }
        }

        return bitmap;
    }
}
