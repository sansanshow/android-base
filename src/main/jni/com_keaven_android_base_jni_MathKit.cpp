//
// Created by HX-MG01 on 2016/11/22.
//
#include <com_keaven_android_base_jni_MathKit.h>

JNIEXPORT jint JNICALL Java_com_keaven_android_base_jni_MathKit_square
  (JNIEnv *env, jclass cls, jint num)
  {
        return num*num;
  }
