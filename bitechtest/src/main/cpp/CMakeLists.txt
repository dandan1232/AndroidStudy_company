cmake_minimum_required(VERSION 3.10.2)  # Android Studio 支持的最低版本

# 项目名称
project("MyInferenceEngine")

# 设置编译选项，如 C++ 标准和编译优化
set(CMAKE_CXX_STANDARD 17)
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O0 -g")


# 添加头文件目录
include_directories(${CMAKE_SOURCE_DIR}/include)

# 添加子目录（如果有的话）
# add_subdirectory(${CMAKE_SOURCE_DIR}/subdir)

# 将源码添加为一个库
add_library(
        native_inference  # 库名称
        SHARED
        llama_inference.cpp
        image_generation.cpp
)
# 查找 log 库（Android 平台上的默认库）
find_library(log-lib log)

# 链接库
target_link_libraries(native_inference ${log-lib})
