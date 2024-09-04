plugins {
    alias(libs.plugins.android.application)
}


android {
    namespace = "com.example.bitechtest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bitechtest"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // 配置 NDK 和 CMake
        ndk {
            // 选择要支持的 ABI 架构
            abiFilters.addAll(listOf("armeabi-v7a", "arm64-v8a"))
        }

        externalNativeBuild {
            cmake {
                // 添加C++编译标志
                cppFlags.add("-std=c++17")
            }
        }
    }

    externalNativeBuild {
        cmake {
            // 指定CMakeLists.txt文件的路径
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1") // Java 项目使用 annotationProcessor
    implementation("com.microsoft.onnxruntime:onnxruntime-android:1.11.0")
    implementation(libs.onnxruntime) // ONNX Runtime 依赖
    implementation(libs.okhttp) // OkHttp 依赖
    implementation(libs.retrofit) // Retrofit 依赖
    implementation(libs.tflite) // TFLite 依赖
}

