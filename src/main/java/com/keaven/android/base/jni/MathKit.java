package com.keaven.android.base.jni;

/**
 * Created by a-keaven on 2016/11/22.
 */
public class MathKit {
    public static native int square(int num);

    static {
        System.loadLibrary("jnibase");
    }
}
